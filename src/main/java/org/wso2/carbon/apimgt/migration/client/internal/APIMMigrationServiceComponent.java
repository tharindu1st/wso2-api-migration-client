/*
 *  Copyright WSO2 Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.carbon.apimgt.migration.client.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.apimgt.api.APIManagementException;
import org.wso2.carbon.apimgt.impl.APIManagerConfigurationService;
import org.wso2.carbon.apimgt.impl.utils.APIMgtDBUtil;
import org.wso2.carbon.apimgt.migration.client.MigrateFrom16to17;
import org.wso2.carbon.apimgt.migration.client.MigrateFrom17to18;
import org.wso2.carbon.apimgt.migration.client.MigrateFrom18to19;
import org.wso2.carbon.apimgt.migration.client.MigrationClient;
import org.wso2.carbon.apimgt.migration.client.util.Constants;
import org.wso2.carbon.registry.core.service.RegistryService;
import org.wso2.carbon.registry.core.service.TenantRegistryLoader;
import org.wso2.carbon.user.api.UserStoreException;
import org.wso2.carbon.user.core.service.RealmService;

import java.io.IOException;
import java.sql.SQLException;


/**
 * @scr.component name="org.wso2.carbon.apimgt.migration.client" immediate="true"
 * @scr.reference name="realm.service"
 * interface="org.wso2.carbon.user.core.service.RealmService" cardinality="1..1"
 * policy="dynamic" bind="setRealmService" unbind="unsetRealmService"
 * @scr.reference name="registry.service"
 * interface="org.wso2.carbon.registry.core.service.RegistryService" cardinality="1..1"
 * policy="dynamic" bind="setRegistryService" unbind="unsetRegistryService"
 * @scr.reference name="registry.core.dscomponent"
 * interface="org.wso2.carbon.registry.core.service.RegistryService" cardinality="1..1"
 * policy="dynamic" bind="setRegistryService" unbind="unsetRegistryService"
 * @scr.reference name="tenant.registryloader" interface="org.wso2.carbon.registry.core.service.TenantRegistryLoader" cardinality="1..1"
 * policy="dynamic" bind="setTenantRegistryLoader" unbind="unsetTenantRegistryLoader"
 * @scr.reference name="apim.configuration" interface="org.wso2.carbon.apimgt.impl.APIManagerConfigurationService" cardinality="1..1"
 * policy="dynamic" bind="setApiManagerConfig" unbind="unsetApiManagerConfig"
 */

@SuppressWarnings("unused")
public class APIMMigrationServiceComponent {

    private static final Log log = LogFactory.getLog(APIMMigrationServiceComponent.class);
    private boolean cleanupNeeded;

    /**
     * Method to activate bundle.
     *
     * @param context OSGi component context.
     */
    protected void activate(ComponentContext context) {
        try {
            APIMgtDBUtil.initialize();
        } catch (Exception e) {
            log.error("Error occurred while initializing DB Util " + e.getMessage());
        }
        String migrateVersion = System.getProperty("migrate");
        if(System.getProperty("cleanup")!=null) {
            cleanupNeeded = Boolean.parseBoolean(System.getProperty("cleanup"));
        }


        if (migrateVersion != null && migrateVersion.equalsIgnoreCase(Constants.VERSION_1_7)) {
            log.info("Migrating WSO2 API Manager 1.6 swagger and documentation resources to WSO2 API Manager 1.7");
            try {

                MigrateFrom16to17 migrateFrom16to17 = new MigrateFrom16to17();

                //Database Migration
                log.info("Migrating WSO2 API Manager 1.6.0 databases to WSO2 API Manager 1.7.0");
                migrateFrom16to17.databaseMigration(migrateVersion);

                //Swagger Resource Migration
                log.info("Migrating WSO2 API Manager 1.6.0 swagger resources to WSO2 API Manager 1.7.0");
                migrateFrom16to17.swaggerResourceMigration();

                //Registry Migration
                log.info("Migrating WSO2 API Manager 1.6.0 registry resources to WSO2 API Manager 1.7.0");

                //Rxt Migration
                log.info("Migrating WSO2 API Manager 1.6.0 Rxt resources to WSO2 API Manager 1.7.0");

                if (log.isDebugEnabled()) {
                    log.debug("API Manager 1.6.0 to 1.7.0 migration successfully completed");
                }
            } catch (UserStoreException e) {
                log.error("User store exception occurred while migrating " + e.getMessage());
            } catch (SQLException e) {
                log.error("SQL exception occurred while migrating " + e.getMessage());
            }

        } else if (migrateVersion != null && migrateVersion.equalsIgnoreCase(Constants.VERSION_1_8)) {
            log.info("Migrating WSO2 API Manager 1.7.0 Swagger resources to WSO2 API Manager 1.8.0");
            // Create a thread and wait till the APIManager DBUtils is initialized
            try {
                MigrateFrom17to18 migrateFrom17to18 = new MigrateFrom17to18();

                //Database Migration
                log.info("Migrating WSO2 API Manager 1.7.0 databases to WSO2 API Manager 1.8.0");
                migrateFrom17to18.databaseMigration(migrateVersion);

                //Swagger Resource Migration
                log.info("Migrating WSO2 API Manager 1.7.0 swagger resources to WSO2 API Manager 1.8.0");
                migrateFrom17to18.swaggerResourceMigration();

                //Registry Migration
                log.info("Migrating WSO2 API Manager 1.7.0 registry resources to WSO2 API Manager 1.8.0");

                //Rxt Migration
                log.info("Migrating WSO2 API Manager 1.7.0 Rxt resources to WSO2 API Manager 1.8.0");

                if (log.isDebugEnabled()) {
                    log.debug("API Manager 1.7.0 to 1.8.0 migration successfully completed");
                }

            } catch (UserStoreException e) {
                log.error("User store exception occurred while migrating " + e.getMessage());
            } catch (InterruptedException e) {
                log.error("Interrupted exception occurred while migrating " + e.getMessage());
            } catch (SQLException e) {
                log.error("SQL exception occurred while migrating " + e.getMessage());
            } catch (IOException e) {
                log.error("IO exception occurred while migrating " + e.getMessage());
            } catch (APIManagementException e) {
                log.error("APIManagementException occurred while migrating " + e.getMessage());
            }

        } else if (migrateVersion != null && migrateVersion.equalsIgnoreCase(Constants.VERSION_1_9)) {
            log.info("Migrating WSO2 API Manager 1.8.0 Swagger resources to WSO2 API Manager 1.9.0");
            // Create a thread and wait till the APIManager DBUtils is initialized
            try {
                MigrateFrom18to19 migrateFrom18to19 = new MigrateFrom18to19();

                //Database Migration
                log.info("Migrating WSO2 API Manager 1.8.0 databases to WSO2 API Manager 1.9.0");
                migrateFrom18to19.databaseMigration(migrateVersion);

                //Swagger Resource Migration
                log.info("Migrating WSO2 API Manager 1.8.0 swagger resources to WSO2 API Manager 1.9.0");
                migrateFrom18to19.swaggerResourceMigration();

                //Registry Migration
                log.info("Migrating WSO2 API Manager 1.8.0 registry resources to WSO2 API Manager 1.9.0");
                migrateFrom18to19.registryMigration();

                //Rxt Migration
                log.info("Migrating WSO2 API Manager 1.8.0 Rxt resources to WSO2 API Manager 1.9.0");
                migrateFrom18to19.rxtMigration();

                //Old resource cleanup
                if(cleanupNeeded) {
                    migrateFrom18to19.cleanOldResources();
                    log.info("Old resources cleaned up.");
                }

                if (log.isDebugEnabled()) {
                    log.debug("API Manager 1.8.0 to 1.9.0 migration successfully completed");
                }
            } catch (UserStoreException e) {
                log.error("User store exception occurred while migrating " + e.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        log.info("WSO2 API Manager migration component successfully activated.");
    }

    /**
     * Method to deactivate bundle.
     *
     * @param context OSGi component context.
     */
    protected void deactivate(ComponentContext context) {
        log.info("WSO2 API Manager migration bundle is deactivated");
    }

    /**
     * Method to set registry service.
     *
     * @param registryService service to get tenant data.
     */
    protected void setRegistryService(RegistryService registryService) {
        if (log.isDebugEnabled()) {
            log.debug("Setting RegistryService for WSO2 API Manager migration");
        }
        ServiceHolder.setRegistryService(registryService);
    }

    /**
     * Method to unset registry service.
     *
     * @param registryService service to get registry data.
     */
    protected void unsetRegistryService(RegistryService registryService) {
        if (log.isDebugEnabled()) {
            log.debug("Unset Registry service");
        }
        ServiceHolder.setRegistryService(null);
    }

    /**
     * Method to set realm service.
     *
     * @param realmService service to get tenant data.
     */
    protected void setRealmService(RealmService realmService) {
        log.debug("Setting RealmService for WSO2 API Manager migration");
        ServiceHolder.setRealmService(realmService);
    }

    /**
     * Method to unset realm service.
     *
     * @param realmService service to get tenant data.
     */
    protected void unsetRealmService(RealmService realmService) {
        if (log.isDebugEnabled()) {
            log.debug("Unset Realm service");
        }
        ServiceHolder.setRealmService(null);
    }

    /**
     * Method to set tenant registry loader
     *
     * @param tenantRegLoader tenant registry loader
     */
    protected void setTenantRegistryLoader(TenantRegistryLoader tenantRegLoader) {
        log.debug("Setting TenantRegistryLoader for WSO2 API Manager migration");
        ServiceHolder.setTenantRegLoader(tenantRegLoader);
    }

    /**
     * Method to unset tenant registry loader
     *
     * @param tenantRegLoader tenant registry loader
     */
    protected void unsetTenantRegistryLoader(TenantRegistryLoader tenantRegLoader) {
        log.debug("Unset Tenant Registry Loader");
        ServiceHolder.setTenantRegLoader(null);
    }

    /**
     * Method to set API Manager configuration
     *
     * @param apiManagerConfig api manager configuration
     */
    protected void setApiManagerConfig(APIManagerConfigurationService apiManagerConfig) {
        log.info("Setting APIManager configuration");
    }

    /**
     * Method to unset API manager configuration
     *
     * @param apiManagerConfig api manager configuration
     */
    protected void unsetApiManagerConfig(APIManagerConfigurationService apiManagerConfig) {
        log.info("Un-setting APIManager configuration");
    }

}
