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
package org.wso2.carbon.apimgt.migration.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.wso2.carbon.apimgt.api.APIManagementException;
import org.wso2.carbon.apimgt.api.doc.model.Operation;
import org.wso2.carbon.apimgt.api.doc.model.Parameter;
import org.wso2.carbon.apimgt.api.model.API;
import org.wso2.carbon.apimgt.api.model.APIIdentifier;
import org.wso2.carbon.apimgt.api.model.Documentation;
import org.wso2.carbon.apimgt.api.model.URITemplate;
import org.wso2.carbon.apimgt.impl.APIConstants;
import org.wso2.carbon.apimgt.impl.utils.APIUtil;
import org.wso2.carbon.apimgt.migration.client.internal.ServiceHolder;
import org.wso2.carbon.apimgt.migration.client.util.Constants;
import org.wso2.carbon.apimgt.migration.client.util.ResourceUtil;
import org.wso2.carbon.base.MultitenantConstants;
import org.wso2.carbon.context.PrivilegedCarbonContext;
import org.wso2.carbon.governance.api.common.dataobjects.GovernanceArtifact;
import org.wso2.carbon.governance.api.exception.GovernanceException;
import org.wso2.carbon.governance.api.generic.GenericArtifactManager;
import org.wso2.carbon.governance.api.generic.dataobjects.GenericArtifact;
import org.wso2.carbon.governance.api.util.GovernanceUtils;
import org.wso2.carbon.registry.core.*;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.session.UserRegistry;
import org.wso2.carbon.user.api.Tenant;
import org.wso2.carbon.user.api.UserStoreException;
import org.wso2.carbon.user.core.tenant.TenantManager;

import java.sql.SQLException;
import java.util.*;

@SuppressWarnings("unchecked")
public class MigrateFrom16to17 implements MigrationClient {

    private static final Log log = LogFactory.getLog(MigrateFrom16to17.class);


        /*String databaseDriverName = ResourceUtil.getDatabaseDriverName();
        String queryToExecute;

        Connection connection = APIMgtDBUtil.getConnection();
        connection.setAutoCommit(false);

        if (databaseDriverName.equalsIgnoreCase("mysql")) {
            queryToExecute = Constants.MYSQL_QUERY_16_TO_17;
        } else if (databaseDriverName.equalsIgnoreCase("mssql")) {
            queryToExecute = Constants.MSSQL_QUERY_16_TO_17;
        } else if (databaseDriverName.equalsIgnoreCase("h2")) {
            queryToExecute = Constants.H2_QUERY_16_TO_17;
        }else {
            queryToExecute = Constants.ORACLE_QUERY_16_TO_17;
        }

        PreparedStatement preparedStatement = connection.prepareStatement(queryToExecute);
        boolean isUpdated = preparedStatement.execute();
        if (isUpdated) {
            connection.commit();
        } else {
            connection.rollback();
        }
        preparedStatement.close();

        if (log.isDebugEnabled()) {
            log.debug("Query " + queryToExecute + " executed on " + databaseDriverName);
        }

        connection.close();
        log.info("DB resource migration done for all the tenants");*/


    @Override
    public void databaseMigration(String migrateVersion) throws SQLException {

    }

    @Override
    public void swaggerResourceMigration() throws UserStoreException {
        log.info("Swagger migration for API Manager 1.7.0 started");

        TenantManager tenantManager = ServiceHolder.getRealmService().getTenantManager();
        Tenant[] tenantsArray = tenantManager.getAllTenants();
        if(log.isDebugEnabled()){
            log.debug("Tenant array loaded successfully");
        }

        // Add  super tenant to the tenant array
        Tenant[] allTenantsArray = Arrays.copyOf(tenantsArray, tenantsArray.length + 1);
        org.wso2.carbon.user.core.tenant.Tenant superTenant = new org.wso2.carbon.user.core.tenant.Tenant();
        superTenant.setId(MultitenantConstants.SUPER_TENANT_ID);
        superTenant.setDomain(MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        allTenantsArray[allTenantsArray.length - 1] = superTenant;
        if (log.isDebugEnabled()) {
            log.debug("Super tenant added to the tenant array");
        }

        for (Tenant tenant : allTenantsArray) {
            log.info("Swagger resource migration for tenant " + tenant.getDomain() + "[" + tenant.getId() + "]");
            try {
                //Start a new tenant flow
                PrivilegedCarbonContext.startTenantFlow();
                PrivilegedCarbonContext.getThreadLocalCarbonContext().setTenantDomain(tenant.getDomain());
                PrivilegedCarbonContext.getThreadLocalCarbonContext().setTenantId(tenant.getId());

                String adminName = ServiceHolder.getRealmService().getTenantUserRealm(tenant.getId()).getRealmConfiguration().getAdminUserName();
                ServiceHolder.getTenantRegLoader().loadTenantRegistry(tenant.getId());
                Registry registry = ServiceHolder.getRegistryService().getGovernanceUserRegistry(adminName, tenant.getId());
                GenericArtifactManager manager = new GenericArtifactManager(registry, "api");
                GovernanceUtils.loadGovernanceArtifacts((UserRegistry) registry);
                GenericArtifact[] artifacts = manager.getAllGenericArtifacts();

                for (GenericArtifact artifact : artifacts) {
                    try {
                        API api = APIUtil.getAPI(artifact, registry);
                        APIIdentifier apiIdentifier = api.getId();
                        String apiName = apiIdentifier.getApiName();
                        String apiVersion = apiIdentifier.getVersion();
                        String apiProviderName = apiIdentifier.getProviderName();
                        artifact.setAttribute(APIConstants.PROTOTYPE_OVERVIEW_IMPLEMENTATION, APIConstants.IMPLEMENTATION_TYPE_ENDPOINT);
                        manager.updateGenericArtifact(artifact);
                        String apiDefinitionFilePath = ResourceUtil.getAPIDefinitionFilePath(apiName, apiVersion, apiProviderName);
                        Resource resource = registry.get(apiDefinitionFilePath);
                        String text = new String((byte[]) resource.getContent());
                        String newContentPath = APIUtil.getAPIDefinitionFilePath(apiName, apiVersion, apiProviderName);
                        Resource docContent = registry.newResource();
                        docContent.setContent(text);
                        docContent.setMediaType("text/plain");
                        registry.put(newContentPath, docContent);
                        String visibleRolesList = api.getVisibleRoles();
                        String[] visibleRoles = new String[0];
                        if (visibleRolesList != null) {
                            visibleRoles = visibleRolesList.split(",");
                        }
                        ServiceHolder.getRealmService().getTenantUserRealm(tenant.getId()).getAuthorizationManager().authorizeRole(APIConstants.ANONYMOUS_ROLE,
                                "_system/governance" + newContentPath,
                                ActionConstants.GET);


                        //add swagger 1.2 resources
                        log.info("Creating swagger 1.2 docs resources for : " + apiName + "-" + apiVersion + "-" + apiProviderName);

                        createSwagger12Resources(artifact, registry, api, tenant);

                        //merge swagger 1.1 content with 1.2 resources
                        log.info("Updating swagger 1.2 docs resource for : " + apiName + "-" + apiVersion + "-" + apiProviderName);

                        updateSwagger12ResourcesUsingSwagger11Doc(apiIdentifier, registry);

                    } catch (RegistryException e) {
                        log.error("RegistryException while migrating api in " + tenant.getDomain(), e);
                    } catch (APIManagementException e) {
                        log.error("APIManagementException while migrating api in " + tenant.getDomain(), e);
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                }
            } catch (RegistryException e) {
                log.error("RegistryException while getting artifacts for  " + tenant.getDomain(), e);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            } finally {
                PrivilegedCarbonContext.endTenantFlow();
            }
        }
    }

    @Override
    public void registryMigration() throws UserStoreException {
        log.info("Registry migration for API Manager 1.7.0 started");

        TenantManager tenantManager = ServiceHolder.getRealmService().getTenantManager();
        Tenant[] tenantsArray = tenantManager.getAllTenants();
        if(log.isDebugEnabled()){
            log.debug("Tenant array loaded successfully");
        }

        // Add  super tenant to the tenant array
        Tenant[] allTenantsArray = Arrays.copyOf(tenantsArray, tenantsArray.length + 1);
        org.wso2.carbon.user.core.tenant.Tenant superTenant = new org.wso2.carbon.user.core.tenant.Tenant();
        superTenant.setId(MultitenantConstants.SUPER_TENANT_ID);
        superTenant.setDomain(MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        allTenantsArray[allTenantsArray.length - 1] = superTenant;
        if (log.isDebugEnabled()) {
            log.debug("Super tenant added to the tenant array");
        }

        for (Tenant tenant : allTenantsArray) {
            log.info("Document file migration for tenant " + tenant.getDomain() + "[" + tenant.getId() + "]");
            try {
                //Start a new tenant flow
                PrivilegedCarbonContext.getThreadLocalCarbonContext().startTenantFlow();
                PrivilegedCarbonContext.getThreadLocalCarbonContext().setTenantDomain(tenant.getDomain());
                PrivilegedCarbonContext.getThreadLocalCarbonContext().setTenantId(tenant.getId());

                String adminName = ServiceHolder.getRealmService().getTenantUserRealm(tenant.getId()).getRealmConfiguration().getAdminUserName();
                ServiceHolder.getTenantRegLoader().loadTenantRegistry(tenant.getId());
                Registry registry = ServiceHolder.getRegistryService().getGovernanceUserRegistry(adminName, tenant.getId());
                GenericArtifactManager manager = new GenericArtifactManager(registry, "api");
                GovernanceUtils.loadGovernanceArtifacts((UserRegistry) registry);
                GenericArtifact[] artifacts = manager.getAllGenericArtifacts();

                for (GenericArtifact artifact : artifacts) {
                    try {
                        API api = getAPI(artifact, registry);
                        APIIdentifier adiIdentifier = api.getId();
                        String apiResourcePath = APIUtil.getAPIPath(adiIdentifier);
                        Association[] docAssociations = registry.getAssociations(apiResourcePath, "document");
                        for (Association association : docAssociations) {
                            String docPath = association.getDestinationPath();
                            Resource docResource = registry.get(docPath);
                            GenericArtifactManager docArtifactManager = new GenericArtifactManager(registry, APIConstants.DOCUMENTATION_KEY);
                            GenericArtifact docArtifact = docArtifactManager.getGenericArtifact(docResource.getUUID());
                            String docFilePath = docArtifact.getAttribute(APIConstants.DOC_FILE_PATH);
                            Documentation doc = APIUtil.getDocumentation(docArtifact);
                            if (Documentation.DocumentSourceType.FILE.equals(doc.getSourceType())) {
                                if (docFilePath != null && !docFilePath.equals("")) {
                                    //The docFilePatch comes as /t/tenanatdoman/registry/resource/_system/governance/apimgt/applicationdata..
                                    //We need to remove the /t/tenanatdoman/registry/resource/_system/governance section to set permissions.
                                    int startIndex = docFilePath.indexOf("governance") + "governance".length();
                                    String filePath = docFilePath.substring(startIndex, docFilePath.length());
                                    if (!filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".")) {
                                        Resource resource = registry.get(filePath);
                                        resource.setMediaType("text/plain");
                                        registry.put(filePath, resource);
                                    } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".wsdl")) {
                                        String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                        if (registry.resourceExists(resourcePath)) {
                                            Resource resource = registry.get(filePath);
                                            resource.setMediaType("application/api-wsdl");
                                            registry.put(filePath, resource);
                                        }
                                    } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".pdf")) {
                                        String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                        if (registry.resourceExists(resourcePath)) {
                                            Resource resource = registry.get(filePath);
                                            resource.setMediaType("application/pdf");
                                            registry.put(filePath, resource);
                                        }
                                    } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".xl")) {
                                        String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                        if (registry.resourceExists(resourcePath)) {
                                            Resource resource = registry.get(filePath);
                                            resource.setMediaType("application/vnd.ms-excel");
                                            registry.put(filePath, resource);
                                        }
                                    } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".ppt")) {
                                        String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                        if (registry.resourceExists(resourcePath)) {
                                            Resource resource = registry.get(filePath);
                                            resource.setMediaType("application/vnd.ms-powerpoint");
                                            registry.put(filePath, resource);
                                        }
                                    } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".xml")) {
                                        String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                        if (registry.resourceExists(resourcePath)) {
                                            Resource resource = registry.get(filePath);
                                            resource.setMediaType("application/xml");
                                            registry.put(filePath, resource);
                                        }
                                    } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".js")) {
                                        String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                        if (registry.resourceExists(resourcePath)) {
                                            Resource resource = registry.get(filePath);
                                            resource.setMediaType("application/javascript");
                                            registry.put(filePath, resource);
                                        }
                                    } else {
                                        if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".css")) {
                                            String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                            if (registry.resourceExists(resourcePath)) {
                                                Resource resource = registry.get(filePath);
                                                resource.setMediaType("text/css");
                                                registry.put(filePath, resource);
                                            }
                                        } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".csv")) {
                                            String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                            if (registry.resourceExists(resourcePath)) {
                                                Resource resource = registry.get(filePath);
                                                resource.setMediaType("text/csv");
                                                registry.put(filePath, resource);
                                            }
                                        } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".html")) {
                                            String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                            if (registry.resourceExists(resourcePath)) {
                                                Resource resource = registry.get(filePath);
                                                resource.setMediaType("text/html");
                                                registry.put(filePath, resource);
                                            }
                                        } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".json")) {
                                            String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                            if (registry.resourceExists(resourcePath)) {
                                                Resource resource = registry.get(filePath);
                                                resource.setMediaType("application/json");
                                                registry.put(filePath, resource);
                                            }
                                        } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".png")) {
                                            String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                            if (registry.resourceExists(resourcePath)) {
                                                Resource resource = registry.get(filePath);
                                                resource.setMediaType("image/png");
                                                registry.put(filePath, resource);
                                            }
                                        } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".ttf")) {
                                            String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                            if (registry.resourceExists(resourcePath)) {
                                                Resource resource = registry.get(filePath);
                                                resource.setMediaType("application/x-font-ttf");
                                                registry.put(filePath, resource);
                                            }
                                        } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".eot")) {
                                            String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                            if (registry.resourceExists(resourcePath)) {
                                                Resource resource = registry.get(filePath);
                                                resource.setMediaType("application/vnd.ms-fontobject");
                                                registry.put(filePath, resource);
                                            }
                                        } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".woff")) {
                                            String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                            if (registry.resourceExists(resourcePath)) {
                                                Resource resource = registry.get(filePath);
                                                resource.setMediaType("application/font-woff");
                                                registry.put(filePath, resource);
                                            }
                                        } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".otf")) {
                                            String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                            if (registry.resourceExists(resourcePath)) {
                                                Resource resource = registry.get(filePath);
                                                resource.setMediaType("application/x-font-otf");
                                                registry.put(filePath, resource);
                                            }
                                        } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".zip")) {
                                            String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                            if (registry.resourceExists(resourcePath)) {
                                                Resource resource = registry.get(filePath);
                                                resource.setMediaType("application/zip");
                                                registry.put(filePath, resource);
                                            }
                                        } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".xhtml")) {
                                            String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                            if (registry.resourceExists(resourcePath)) {
                                                Resource resource = registry.get(filePath);
                                                resource.setMediaType("application/xhtml+xml");
                                                registry.put(filePath, resource);
                                            }
                                        } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".txt")) {
                                            String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                            if (registry.resourceExists(resourcePath)) {
                                                Resource resource = registry.get(filePath);
                                                resource.setMediaType("text/plain");
                                                registry.put(filePath, resource);
                                            }
                                        } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".png")) {
                                            String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                            if (registry.resourceExists(resourcePath)) {
                                                Resource resource = registry.get(filePath);
                                                resource.setMediaType("image/png");
                                                registry.put(filePath, resource);
                                            }
                                        } else if (filePath.split(RegistryConstants.PATH_SEPARATOR + "files" + RegistryConstants.PATH_SEPARATOR)[1].contains(".jpeg")) {
                                            String resourcePath = "_system" + RegistryConstants.PATH_SEPARATOR + "governance" + filePath;
                                            if (registry.resourceExists(resourcePath)) {
                                                Resource resource = registry.get(filePath);
                                                resource.setMediaType("image/jpeg");
                                                registry.put(filePath, resource);
                                            }
                                        }
                                    }
                                    registry.copy(filePath, filePath);
                                    registry.addAssociation(docArtifact.getPath(), filePath, APIConstants.DOCUMENTATION_FILE_ASSOCIATION);
                                }
                            }
                        }
                    } catch (APIManagementException e) {
                        log.error(e.getMessage(), e);
                    } catch (RegistryException e) {
                        log.error(e.getMessage(), e);
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                }
            } catch (RegistryException e) {
                log.error(e.getMessage(), e);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            } finally {
                PrivilegedCarbonContext.getThreadLocalCarbonContext().endTenantFlow();
            }
        }
    }

    @Override
    public void rxtMigration() {

    }

    @Override
    public void cleanOldResources() {

    }

    /**
     * This method returns API object
     *
     * @param artifact API Artifact
     * @param registry User Registry
     * @return api object according to the given api artifact
     * @throws APIManagementException
     */
    public static API getAPI(GovernanceArtifact artifact, Registry registry)
            throws APIManagementException {

        API api;
        try {
            String providerName = artifact.getAttribute(APIConstants.API_OVERVIEW_PROVIDER);
            String apiName = artifact.getAttribute(APIConstants.API_OVERVIEW_NAME);
            String apiVersion = artifact.getAttribute(APIConstants.API_OVERVIEW_VERSION);
            APIIdentifier apiId = new APIIdentifier(providerName, apiName, apiVersion);
            api = new API(apiId);

            api.setUrl(artifact.getAttribute(APIConstants.API_OVERVIEW_ENDPOINT_URL));
            api.setSandboxUrl(artifact.getAttribute(APIConstants.API_OVERVIEW_SANDBOX_URL));
            api.setVisibility(artifact.getAttribute(APIConstants.API_OVERVIEW_VISIBILITY));
            api.setVisibleRoles(artifact.getAttribute(APIConstants.API_OVERVIEW_VISIBLE_ROLES));


        } catch (GovernanceException e) {
            String msg = "Failed to get API fro artifact ";
            throw new APIManagementException(msg, e);
        }
        return api;
    }


    /**
     * Update the swagger 1.2 resources using swagger 1.1 doc
     *
     * @param apiIdentifier api identifier
     * @param registry      user registry
     * @throws APIManagementException
     * @throws org.wso2.carbon.registry.core.exceptions.RegistryException
     */
    private static void updateSwagger12ResourcesUsingSwagger11Doc(APIIdentifier apiIdentifier, Registry registry)
            throws APIManagementException, RegistryException {

        String apiName = apiIdentifier.getApiName();
        String apiProviderName = apiIdentifier.getProviderName();
        String apiVersion = apiIdentifier.getVersion();
        String apiDef11Path = APIUtil.getAPIDefinitionFilePath(apiName, apiVersion, apiProviderName);
        Resource apiDef11 = registry.get(apiDef11Path);

        String apiDef11Json = new String((byte[]) apiDef11.getContent());

        String swagger12location = ResourceUtil.getSwagger12ResourceLocation(apiName, apiVersion, apiProviderName);
        Resource swagger12Res = registry.get(swagger12location);
        String[] resourcePaths = (String[]) swagger12Res.getContent();

        try {
            ResourceUtil.updateAPISwaggerDocs(apiDef11Json, resourcePaths, registry);
        } catch (ParseException e) {
            throw new APIManagementException("Unable to parse registry resource", e);
        }

    }


    /**
     * save create resource at the given location and set permission
     *
     * @param registry     user registry
     * @param content      content
     * @param resourcePath resource paths
     * @param api          api object
     * @throws org.wso2.carbon.user.api.UserStoreException
     */
    private static void createResource(Registry registry, String content, String resourcePath, API api, Tenant tenant) throws UserStoreException {
        try {
            Resource docContent = registry.newResource();
            docContent.setContent(content);
            docContent.setMediaType("text/plain");
            registry.put(resourcePath, docContent);

            String visibleRolesList = api.getVisibleRoles();
            String[] visibleRoles = new String[0];
            if (visibleRolesList != null) {
                visibleRoles = visibleRolesList.split(",");
            }
            ServiceHolder.getRealmService().getTenantUserRealm(tenant.getId()).getAuthorizationManager().authorizeRole(APIConstants.ANONYMOUS_ROLE,
                    "_system/governance" + resourcePath, ActionConstants.GET);
        } catch (RegistryException e) {
            String msg = "Failed to add the API Definition content of : " + APIConstants.API_DEFINITION_DOC_NAME + " of API :" + api.getId().getApiName();
            log.error(msg);
        }
    }

    /**
     * create swagger 1.2 resources
     *
     * @param artifact api artifact
     * @param registry user registry
     * @param api      api object
     * @throws APIManagementException
     * @throws UserStoreException
     */
    public static void createSwagger12Resources(GovernanceArtifact artifact, Registry registry,
                                                API api, Tenant tenant) throws UserStoreException, APIManagementException {

        JSONParser parser = new JSONParser();

        //Auth Types
        HashMap<String, String> auth_types = new HashMap<String, String>();
        auth_types.put("None", "None");
        auth_types.put("Application_User", "Application User");
        auth_types.put("Application", "Application");
        auth_types.put("Any", "Application & Application User");


        List<String> uriTemplatePathNames = new ArrayList<String>();

        Map<String, JSONObject> resourceNameJSONs = new HashMap<String, JSONObject>();


        // resource path operations list
        Map<String, List<JSONObject>> resourcePathOperations = new HashMap<String, List<JSONObject>>();

        Map<String, String> resourceNamePathNameMap = new HashMap<String, String>();
        JSONObject mainAPIJson = null;
        try {

            String apiVersion = artifact.getAttribute(APIConstants.API_OVERVIEW_VERSION);

            Set<URITemplate> uriTemplates = api.getUriTemplates();
            Map<String, List<String>> resourceNamePaths = new HashMap<String, List<String>>();
            Map<String, List<JSONObject>> resourcePathJSONs = new HashMap<String, List<JSONObject>>();

            for (URITemplate template : uriTemplates) {
                List<Operation> ops;
                List<Parameter> parameters = null;

                String path = template.getUriTemplate();

                if (path != null && (path.equals("/*") || (path.equals("/")))) {
                    path = "/*";
                }
                List<String> resourcePaths;
                int resourceNameEndIndex = path.indexOf("/", 1);
                String resourceName = "/default";
                if (resourceNameEndIndex != -1) {
                    resourceName = path.substring(1, resourceNameEndIndex);
                }

                if (!resourceName.startsWith("/")) {
                    resourceName = "/" + resourceName;
                }

                if (resourceNamePaths.get(resourceName) != null) {
                    resourcePaths = resourceNamePaths.get(resourceName);
                    if (!resourcePaths.contains(path)) {
                        resourcePaths.add(path);
                    }
                    //verbs comes as a [POST, GET] type of a string
                    String[] httpVerbs = template.getMethodsAsString().split(" ");
                    String[] authtypes = template.getAuthTypeAsString().split(" ");
                    String[] tries = template.getThrottlingTiersAsString().split(" ");

                    for (int j = 0; j < httpVerbs.length; j++) {
                        final JSONObject operationJson = (JSONObject) parser.parse(Constants.OPERATION_JSON_TEMPLATE);
                        operationJson.put("method", httpVerbs[j]);
                        operationJson.put("auth_type", auth_types.get(authtypes[j]));
                        operationJson.put("throttling_tier", tries[j]);

                        if (resourcePathJSONs.get(path) != null) {
                            resourcePathJSONs.get(path).add(operationJson);

                        } else {
                            resourcePathJSONs.put(path, new ArrayList<JSONObject>() {{
                                add(operationJson);
                            }});
                        }
                    }
                    resourceNamePaths.put(resourceName, resourcePaths);
                } else {
                    JSONObject resourcePathJson = (JSONObject) parser.parse(Constants.API_RESOURCE_JSON_TEMPALTE);

                    resourcePaths = new ArrayList<String>();
                    resourcePaths.add(path);

                    //verbs comes as a [POST, GET] type of a string
                    String[] httpVerbs = template.getMethodsAsString().split(" ");
                    String[] authtypes = template.getAuthTypeAsString().split(" ");
                    String[] tries = template.getThrottlingTiersAsString().split(" ");

                    for (int j = 0; j < httpVerbs.length; j++) {
                        final JSONObject operationJson = (JSONObject) parser.parse(Constants.OPERATION_JSON_TEMPLATE);
                        operationJson.put("method", httpVerbs[j]);
                        operationJson.put("auth_type", auth_types.get(authtypes[j]));
                        operationJson.put("throttling_tier", tries[j]);

                        if (resourcePathJSONs.get(path) != null) {
                            resourcePathJSONs.get(path).add(operationJson);

                        } else {
                            resourcePathJSONs.put(path, new ArrayList<JSONObject>() {{
                                add(operationJson);
                            }});
                        }
                    }

                    resourceNamePaths.put(resourceName, resourcePaths);
                }
            }

            // store api object(which contains operations objects) against the resource path
            Map<String, JSONObject> pathNameApi = new HashMap<String, JSONObject>();

            //list to store the api array objects
            List<JSONObject> apiArray = new ArrayList<JSONObject>();

            for (Map.Entry<String, List<JSONObject>> entry : resourcePathJSONs.entrySet()) {
                String resourcePath = entry.getKey();
                JSONObject pathJson = (JSONObject) parser.parse(Constants.PATH_JSON_TEMPLATE);
                pathJson.put("path", resourcePath);
                List<JSONObject> methodJsons = entry.getValue();
                for (JSONObject methodJson : methodJsons) {
                    JSONArray operations = (JSONArray) pathJson.get("operations");
                    operations.add(methodJson);
                }

                pathNameApi.put(resourcePath, pathJson);

                apiArray.add(pathJson);
            }


            /**
             * create only one resource doc for all the resources. name it as 'resources'
             */
            // create resources in the registry
            APIIdentifier apiIdentfier = api.getId();
            String apiDefinitionFilePath = APIUtil.getSwagger12DefinitionFilePath(apiIdentfier.getApiName(),
                    apiIdentfier.getVersion(), apiIdentfier.getProviderName());

            String resourceName = Constants.API_DOC_12_ALL_RESOURCES_DOC;
            JSONObject resourcesObj = (JSONObject) parser.parse(Constants.API_RESOURCE_JSON_TEMPALTE);
            resourcesObj.put("apiVersion", apiVersion);
            resourcesObj.put("resourcePath", "/" + resourceName);
            JSONArray apis = (JSONArray) resourcesObj.get("apis");
            //add all the apis to single one
            for (JSONObject arrayObj : apiArray) {
                apis.add(arrayObj);
            }
            String registryRes = apiDefinitionFilePath + RegistryConstants.PATH_SEPARATOR + resourceName;
            createResource(registry, resourcesObj.toJSONString(), registryRes, api, tenant);

            // create api-doc file in the 1.2 resource location

            mainAPIJson = (JSONObject) parser.parse(Constants.API_JSON_TEMPALTE);
            mainAPIJson.put("apiVersion", apiVersion);
            ((JSONObject) mainAPIJson.get("info")).put("description", "Available resources");
            ((JSONObject) mainAPIJson.get("info")).put("title", artifact.getAttribute(APIConstants.API_OVERVIEW_NAME));

            JSONArray apis1 = (JSONArray) mainAPIJson.get("apis");
            JSONObject pathjob = new JSONObject();
            pathjob.put("path", "/" + resourceName);
            pathjob.put("description", "All resources for the api");
            apis1.add(pathjob);
            createResource(registry, mainAPIJson.toJSONString(), apiDefinitionFilePath + APIConstants.API_DOC_1_2_RESOURCE_NAME, api, tenant);

        } catch (GovernanceException e) {
            String msg = "Failed to get API fro artifact ";
            throw new APIManagementException(msg, e);
        } catch (ParseException e) {
            throw new APIManagementException(
                    "Error while generating swagger 1.2 resource for api ", e);
        }
    }
}
