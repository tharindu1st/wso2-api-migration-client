package org.wso2.carbon.apimgt.migration.client.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.apimgt.impl.APIManagerConfigurationService;
import org.wso2.carbon.apimgt.impl.utils.APIMgtDBUtil;
//import org.wso2.carbon.apimgt.migration.DocFileMigration;
//import org.wso2.carbon.apimgt.migration.Swagger18Migration;
//import org.wso2.carbon.apimgt.migration.Swagger19Migration;
//import org.wso2.carbon.apimgt.migration.SwaggerResMigration;
import org.wso2.carbon.apimgt.migration.client.MigrateFrom18to19;
import org.wso2.carbon.apimgt.migration.client.util.Constants;
import org.wso2.carbon.registry.core.service.RegistryService;
import org.wso2.carbon.registry.core.service.TenantRegistryLoader;
import org.wso2.carbon.user.api.UserStoreException;
import org.wso2.carbon.user.core.service.RealmService;


@SuppressWarnings("unused")
public class APIMMigrationServiceComponent {

    private static final Log log = LogFactory.getLog(APIMMigrationServiceComponent.class);

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
        log.info("Migrate version => " + migrateVersion);
        if (migrateVersion != null && migrateVersion.equalsIgnoreCase(Constants.VERSION_1_6)) {
            log.info("Migrating WSO2 API Manager 1.6 swagger and documentation resources to WSO2 API Manager 1.7");
//            SwaggerResMigration swaggerMigration = new SwaggerResMigration();
//            DocFileMigration docMigration = new DocFileMigration();
//            try {
//                swaggerMigration.migrate();
//                if (log.isDebugEnabled()) {
//                    log.debug("Swagger migration successfully completed");
//                }
//                docMigration.migrate();
//                if (log.isDebugEnabled()) {
//                    log.debug("Document file migration successfully completed");
//                }
//            } catch (UserStoreException e) {
//                log.error("User store exception occurred while migrating " + e.getMessage());
//            }
        } else if (migrateVersion != null && migrateVersion.equalsIgnoreCase(Constants.VERSION_1_7)) {
            log.info("Migrating WSO2 API Manager 1.7 Swagger resources to WSO2 API Manager 1.8");
            // Create a thread and wait till the APIManager DBUtils is initialized
//            try {
//                Swagger18Migration swagger18Migration = new Swagger18Migration();
//                swagger18Migration.migrate();
//                if (log.isDebugEnabled()) {
//                    log.debug("Swagger migration successfully completed");
//                }
//            } catch (UserStoreException e) {
//                log.error("User store exception occurred while migrating " + e.getMessage());
//            } catch (InterruptedException e) {
//                log.error("Interrupted exception occurred while migrating " + e.getMessage());
//            }

        } else if (migrateVersion != null && migrateVersion.equalsIgnoreCase(Constants.VERSION_1_8)) {

            // Create a thread and wait till the APIManager DBUtils is initialized
            try {
                MigrateFrom18to19 swagger19Migration = new MigrateFrom18to19();
                log.info("Migrating WSO2 API Manager 1.8.0 swagger resources to WSO2 API Manager 1.9.0");
                swagger19Migration.swaggerResourceMigration();
                if (log.isDebugEnabled()) {
                    log.debug("Swagger migration successfully completed");
                }
            } catch (UserStoreException e) {
                log.error("User store exception occurred while migrating " + e.getMessage());
            } catch (InterruptedException e) {
                log.error("Interrupted exception occurred while migrating " + e.getMessage());
            }
        }
        log.info("WSO2 API Manager migration bundle activated successfully");
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
