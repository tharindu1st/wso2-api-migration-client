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
package org.wso2.carbon.apimgt.migration.client.util;

public class Constants {
    /*
	 * Variables in api_doc.json version 1.1
	 */

    public static final String API_DOC_11_BASE_PATH = "basePath";
    public static final String API_DOC_11_RESOURCE_PATH = "resourcePath";
    public static final String API_DOC_11_API_VERSION = "apiVersion";
    public static final String API_DOC_11_APIS = "apis";
    public static final String API_DOC_11_PATH = "path";
    public static final String API_DOC_11_OPERATIONS = "operations";
    public static final String API_DOC_11_METHOD = "httpMethod";
    public static final String API_DOC_11_PARAMETERS = "parameters";

	/*
	 * Variables in api_doc.json version 1.2
	 */

    public static final String API_DOC_12_BASE_PATH = "basePath";
    public static final String API_DOC_12_RESOURCE_PATH = "resourcePath";
    public static final String API_DOC_12_API_VERSION = "apiVersion";
    public static final String API_DOC_12_APIS = "apis";
    public static final String API_DOC_12_PATH = "path";
    public static final String API_DOC_12_OPERATIONS = "operations";
    public static final String API_DOC_12_METHOD = "method";
    public static final String API_DOC_12_PARAMETERS = "parameters";
    public static final String API_DOC_12_NICKNAME = "nickname";
    //this resource contains all the resources. This is introduced to swagger 1.2 location to hold
    //all the resource during the migration of 1.6. AM 1.6 does not have resources separated by name
    //so all resources are in one doc
    public static final String API_DOC_12_ALL_RESOURCES_DOC = "resources";


    /**
     * default parameter array
     */
    public static final String DEFAULT_PARAM_ARRAY = "[ " + "  { "
            + "    \"dataType\": \"String\", "
            + "    \"description\": \"Access Token\", "
            + "    \"name\": \"Authorization\", "
            + "    \"allowMultiple\": false, "
            + "    \"required\": true, "
            + "    \"paramType\": \"header\" " + "  }, "
            + "  { "
            + "    \"description\": \"Request Body\", "
            + "    \"name\": \"body\", "
            + "    \"allowMultiple\": false, "
            + "    \"type\": \"string\", "
            + "    \"required\": true, "
            + "    \"paramType\": \"body\" " + "  } "
            + "]";

    public static final String DEFAULT_PARAM_FOR_URL_TEMPLATE = " { "
            + "\"name\": \"\", "
            + "\"allowMultiple\": false, "
            + "\"required\": true, "
            + "\"type\": \"string\", "
            + "\"paramType\": \"path\" "
            + "}";

    public static final String VERSION_1_6 = "1.6";
    public static final String VERSION_1_7 = "1.7";
    public static final String VERSION_1_8 = "1.8";
    public static final String VERSION_1_9 = "1.9";

    //constants for swagger v1.2

    public static final String PATH_JSON_TEMPLATE = "{\n    \"path\": \"\",\n    \"operations\": []\n}";
    public static final String OPERATION_JSON_TEMPLATE = "{\n    \"method\": \"\",\n    \"parameters\": []\n}";
    public static final String API_JSON_TEMPALTE = "{\n    \"apiVersion\": \"\",\n    \"swaggerVersion\": \"1.2\",\n    " +
            "\"apis\": [],\n    \"info\": {\n        \"title\": \"\",\n        \"description\": \"\",\n        " +
            "\"termsOfServiceUrl\": \"\",\n        \"contact\": \"\",\n        \"license\": \"\",\n        " +
            "\"licenseUrl\": \"\"\n    },\n    \"authorizations\": {\n        \"oauth2\": {\n            " +
            "\"type\": \"oauth2\",\n            \"scopes\": []\n        }\n    }\n}";

    public static final String API_RESOURCE_JSON_TEMPALTE = "{\n    \"apiVersion\": \"\",\n    \"swaggerVersion\": \"1.2\",\n    \"resourcePath\":\"\",\n    \"apis\": [] \n}";



    //constants for swagger v2

    //default Swagger v2 response parameter
    public static final String DEFAULT_RESPONSE = "{ " +
            "\"200\": "
            + "{ " +
            "\"description\": \"No response was specified\"} "
            + "}";

    public static final String DEFAULT_SECURITY_SCHEME = "{" +
            "\"x-wso2-scopes\" : \"\", " +
            "\"type\" : \"\", " +
            "\"description\" : \"\", " +
            "\"name\" : \"\"," +
            " \"in\" : \"\", " +
            "\"flow\" : \"\", " +
            "\"authorizationUrl\" : \"\", " +
            "\"tokenUrl\" : \"\", " +
            "\"scopes\" : \"\"}";

    public static final String DEFAULT_INFO = "{" +
            "\"title\" : \"\", " +
            "\"version\" : \"\"" +
            "}";

    //Database migration queries for 1.7.0 to 1.8.0 migration
    public static final String H2_QUERY_17_TO_18 = "ALTER TABLE AM_SUBSCRIPTION ADD SUBS_CREATE_STATE VARCHAR(50) DEFAULT 'SUBSCRIBE';";
    public static final String MSSQL_QUERY_17_TO_18 = "ALTER TABLE AM_SUBSCRIPTION ADD SUBS_CREATE_STATE VARCHAR(50) DEFAULT 'SUBSCRIBE';";
    public static final String MYSQL_QUERY_17_TO_18 = "ALTER TABLE AM_SUBSCRIPTION ADD COLUMN SUBS_CREATE_STATE VARCHAR(50) DEFAULT 'SUBSCRIBE';";
    public static final String ORACLE_QUERY_17_TO_18 = "ALTER TABLE AM_APPLICATION GROUP_ID VARCHAR(100);";
    public static final String POSTGRESQL_QUERY_17_TO_18 = "ALTER TABLE AM_SUBSCRIPTION ADD COLUMN SUBS_CREATE_STATE VARCHAR(50) DEFAULT 'SUBSCRIBE';";

    //Database migration queries for 1.6.0 to 1.7.0 migration
    public static final String H2_QUERY_16_TO_17 = "ALTER TABLE IDN_OAUTH_CONSUMER_APPS DROP LOGIN_PAGE_URL;\n" +
            "ALTER TABLE IDN_OAUTH_CONSUMER_APPS DROP ERROR_PAGE_URL;\n" +
            "ALTER TABLE IDN_OAUTH_CONSUMER_APPS DROP CONSENT_PAGE_URL;\n" +
            "\n" +
            "ALTER TABLE IDN_OAUTH2_ACCESS_TOKEN ALTER TOKEN_SCOPE VARCHAR (2048);\n" +
            "\n" +
            "ALTER TABLE AM_API_URL_MAPPING ADD MEDIATION_SCRIPT BLOB DEFAULT NULL;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDN_OAUTH2_SCOPE (\n" +
            "            SCOPE_ID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "            SCOPE_KEY VARCHAR(100) NOT NULL,\n" +
            "            NAME VARCHAR(255) NULL,\n" +
            "            DESCRIPTION VARCHAR(512) NULL,\n" +
            "            TENANT_ID INTEGER NOT NULL DEFAULT 0,\n" +
            "\t    ROLES VARCHAR (500) NULL,\n" +
            "            PRIMARY KEY (SCOPE_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDN_OAUTH2_RESOURCE_SCOPE (\n" +
            "            RESOURCE_PATH VARCHAR(255) NOT NULL,\n" +
            "            SCOPE_ID INTEGER (11) NOT NULL,\n" +
            "            PRIMARY KEY (RESOURCE_PATH),\n" +
            "            FOREIGN KEY (SCOPE_ID) REFERENCES IDN_OAUTH2_SCOPE (SCOPE_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDN_SCIM_GROUP (\n" +
            "            ID INTEGER GENERATED ALWAYS AS IDENTITY,\n" +
            "            TENANT_ID INTEGER NOT NULL,\n" +
            "            ROLE_NAME VARCHAR(255) NOT NULL,\n" +
            "            ATTR_NAME VARCHAR(1024) NOT NULL,\n" +
            "\t\t\tATTR_VALUE VARCHAR(1024),\n" +
            "            PRIMARY KEY (ID)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDN_SCIM_PROVIDER (\n" +
            "            CONSUMER_ID VARCHAR(255) NOT NULL,\n" +
            "            PROVIDER_ID VARCHAR(255) NOT NULL,\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            USER_PASSWORD VARCHAR(255) NOT NULL,\n" +
            "            USER_URL VARCHAR(1024) NOT NULL,\n" +
            "\t\t\tGROUP_URL VARCHAR(1024),\n" +
            "\t\t\tBULK_URL VARCHAR(1024),\n" +
            "            PRIMARY KEY (CONSUMER_ID,PROVIDER_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDN_OPENID_REMEMBER_ME (\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            TENANT_ID INTEGER DEFAULT 0,\n" +
            "            COOKIE_VALUE VARCHAR(1024),\n" +
            "            CREATED_TIME TIMESTAMP,\n" +
            "            PRIMARY KEY (USER_NAME, TENANT_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDN_OPENID_ASSOCIATIONS (\n" +
            "\t\t\tHANDLE VARCHAR(255) NOT NULL,\n" +
            "\t\t\tASSOC_TYPE VARCHAR(255) NOT NULL,\n" +
            "\t\t\tEXPIRE_IN TIMESTAMP NOT NULL,\n" +
            "\t\t\tMAC_KEY VARCHAR(255) NOT NULL,\n" +
            "\t\t\tASSOC_STORE VARCHAR(128) DEFAULT 'SHARED',\n" +
            "\t\t\tPRIMARY KEY (HANDLE)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IDN_STS_STORE (\n" +
            "            ID INTEGER AUTO_INCREMENT,\n" +
            "            TOKEN_ID VARCHAR(255) NOT NULL,\n" +
            "            TOKEN_CONTENT BLOB NOT NULL,\n" +
            "            CREATE_DATE TIMESTAMP NOT NULL,\n" +
            "            EXPIRE_DATE TIMESTAMP NOT NULL,\n" +
            "            STATE INTEGER DEFAULT 0,\n" +
            "            PRIMARY KEY (ID)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IDN_IDENTITY_USER_DATA (\n" +
            "            TENANT_ID INTEGER DEFAULT -1234,\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            DATA_KEY VARCHAR(255) NOT NULL,\n" +
            "            DATA_VALUE VARCHAR(255) NOT NULL,\n" +
            "            PRIMARY KEY (TENANT_ID, USER_NAME, DATA_KEY)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IDN_IDENTITY_META_DATA (\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            TENANT_ID INTEGER DEFAULT -1234,\n" +
            "            METADATA_TYPE VARCHAR(255) NOT NULL,\n" +
            "            METADATA VARCHAR(255) NOT NULL,\n" +
            "            VALID VARCHAR(255) NOT NULL,\n" +
            "            PRIMARY KEY (TENANT_ID, USER_NAME, METADATA_TYPE,METADATA)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDN_THRIFT_SESSION (\n" +
            "            SESSION_ID VARCHAR(255) NOT NULL,\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            CREATED_TIME VARCHAR(255) NOT NULL,\n" +
            "            LAST_MODIFIED_TIME VARCHAR(255) NOT NULL,\n" +
            "            PRIMARY KEY (SESSION_ID)\n" +
            ");\n" +
            "\n" +
            "-- End of IDN Tables --\n" +
            "\n" +
            "\n" +
            "-- Start of IDN-APPLICATION-MGT Tables--\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_APP (\n" +
            "            ID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "            TENANT_ID INTEGER NOT NULL,\n" +
            "\t    \tAPP_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    \tUSER_STORE VARCHAR (255) NOT NULL,\n" +
            "            USERNAME VARCHAR (255) NOT NULL ,\n" +
            "            DESCRIPTION VARCHAR (1024),\n" +
            "\t    \tROLE_CLAIM VARCHAR (512),\n" +
            "            AUTH_TYPE VARCHAR (255) NOT NULL,\n" +
            "\t    \tPROVISIONING_USERSTORE_DOMAIN VARCHAR (512),\n" +
            "\t    \tIS_LOCAL_CLAIM_DIALECT CHAR(1) DEFAULT '1',\n" +
            "\t    \tIS_SEND_LOCAL_SUBJECT_ID CHAR(1) DEFAULT '0',\n" +
            "\t    \tIS_SEND_AUTH_LIST_OF_IDPS CHAR(1) DEFAULT '0',\n" +
            "\t    \tSUBJECT_CLAIM_URI VARCHAR (512),\n" +
            "\t    \tIS_SAAS_APP CHAR(1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID));\n" +
            "\n" +
            "ALTER TABLE SP_APP ADD CONSTRAINT APPLICATION_NAME_CONSTRAINT UNIQUE(APP_NAME, TENANT_ID);\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_INBOUND_AUTH (\n" +
            "            ID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "\t     \tTENANT_ID INTEGER NOT NULL,\n" +
            "\t     \tINBOUND_AUTH_KEY VARCHAR (255) NOT NULL,\n" +
            "            INBOUND_AUTH_TYPE VARCHAR (255) NOT NULL, \n" +
            "            PROP_NAME VARCHAR (255),\n" +
            "            PROP_VALUE VARCHAR (1024) ,\n" +
            "\t     \tAPP_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID));\n" +
            "\n" +
            "ALTER TABLE SP_INBOUND_AUTH ADD CONSTRAINT APPLICATION_ID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_AUTH_STEP (\n" +
            "            ID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "            TENANT_ID INTEGER NOT NULL,\n" +
            "\t     \tSTEP_ORDER INTEGER DEFAULT 1,\n" +
            "            APP_ID INTEGER NOT NULL ,\n" +
            "            IS_SUBJECT_STEP CHAR(1) DEFAULT '0',\n" +
            "            IS_ATTRIBUTE_STEP CHAR(1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID));\n" +
            "\n" +
            "ALTER TABLE SP_AUTH_STEP ADD CONSTRAINT APPLICATION_ID_CONSTRAINT_STEP FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_FEDERATED_IDP (\n" +
            "            ID INTEGER NOT NULL,\n" +
            "            TENANT_ID INTEGER NOT NULL,\n" +
            "            AUTHENTICATOR_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID, AUTHENTICATOR_ID));\n" +
            "\n" +
            "ALTER TABLE SP_FEDERATED_IDP ADD CONSTRAINT STEP_ID_CONSTRAINT FOREIGN KEY (ID) REFERENCES SP_AUTH_STEP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_CLAIM_MAPPING (\n" +
            "\t    \tID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "\t    \tTENANT_ID INTEGER NOT NULL,\n" +
            "\t    \tIDP_CLAIM VARCHAR (512) NOT NULL ,\n" +
            "            SP_CLAIM VARCHAR (512) NOT NULL ,\n" +
            "\t   \t\tAPP_ID INTEGER NOT NULL,\n" +
            "\t    \tIS_REQUESTED VARCHAR(128) DEFAULT '0',\n" +
            "\t    \tDEFAULT_VALUE VARCHAR(255),\n" +
            "            PRIMARY KEY (ID));\n" +
            "\n" +
            "ALTER TABLE SP_CLAIM_MAPPING ADD CONSTRAINT CLAIMID_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_ROLE_MAPPING (\n" +
            "\t    \tID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "\t    \tTENANT_ID INTEGER NOT NULL,\n" +
            "\t    \tIDP_ROLE VARCHAR (255) NOT NULL ,\n" +
            "            SP_ROLE VARCHAR (255) NOT NULL ,\n" +
            "\t    \tAPP_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID));\n" +
            "\n" +
            "ALTER TABLE SP_ROLE_MAPPING ADD CONSTRAINT ROLEID_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_REQ_PATH_AUTHENTICATOR (\n" +
            "\t    \tID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "\t    \tTENANT_ID INTEGER NOT NULL,\n" +
            "\t    \tAUTHENTICATOR_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    \tAPP_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID));\n" +
            "\n" +
            "ALTER TABLE SP_REQ_PATH_AUTHENTICATOR ADD CONSTRAINT REQ_AUTH_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_PROVISIONING_CONNECTOR (\n" +
            "\t    \tID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "\t    \tTENANT_ID INTEGER NOT NULL,\n" +
            "            IDP_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    \tCONNECTOR_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    \tAPP_ID INTEGER NOT NULL,\n" +
            "\t    \tIS_JIT_ENABLED CHAR(1) NOT NULL DEFAULT '0',\n" +
            "\t\tBLOCKING CHAR(1) NOT NULL DEFAULT '0',\n" +
            "            PRIMARY KEY (ID));\n" +
            "\n" +
            "ALTER TABLE SP_PROVISIONING_CONNECTOR ADD CONSTRAINT PRO_CONNECTOR_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP (\n" +
            "\t\t\tID INTEGER AUTO_INCREMENT,\n" +
            "\t\t\tTENANT_ID INTEGER,\n" +
            "\t\t\tNAME VARCHAR(254) NOT NULL,\n" +
            "\t\t\tIS_ENABLED CHAR(1) NOT NULL DEFAULT '1',\n" +
            "\t\t\tIS_PRIMARY CHAR(1) NOT NULL DEFAULT '0',\n" +
            "\t\t\tHOME_REALM_ID VARCHAR(254),\n" +
            "\t\t\tIMAGE MEDIUMBLOB,\n" +
            "\t\t\tCERTIFICATE BLOB,\n" +
            "\t\t\tALIAS VARCHAR(254),\n" +
            "\t\t\tINBOUND_PROV_ENABLED CHAR (1) NOT NULL DEFAULT '0',\n" +
            "\t\t\tINBOUND_PROV_USER_STORE_ID VARCHAR(254),\n" +
            " \t\t\tUSER_CLAIM_URI VARCHAR(254),\n" +
            " \t\t\tROLE_CLAIM_URI VARCHAR(254),\n" +
            "  \t\t\tDESCRIPTION VARCHAR (1024),\n" +
            " \t\t\tDEFAULT_AUTHENTICATOR_NAME VARCHAR(254),\n" +
            " \t\t\tDEFAULT_PRO_CONNECTOR_NAME VARCHAR(254),\n" +
            " \t\t\tPROVISIONING_ROLE VARCHAR(128),\n" +
            " \t\t\tIS_FEDERATION_HUB CHAR(1) NOT NULL DEFAULT '0',\n" +
            " \t\t\tIS_LOCAL_CLAIM_DIALECT CHAR(1) NOT NULL DEFAULT '0',\n" +
            "\t                DISPLAY_NAME VARCHAR(255),\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (TENANT_ID, NAME));\n" +
            "\n" +
            "INSERT INTO IDP (TENANT_ID, NAME, HOME_REALM_ID) VALUES (-1234, 'LOCAL', 'localhost');\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_ROLE (\n" +
            "\t\t\tID INTEGER AUTO_INCREMENT,\n" +
            "\t\t\tIDP_ID INTEGER,\n" +
            "\t\t\tTENANT_ID INTEGER,\n" +
            "\t\t\tROLE VARCHAR(254),\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (IDP_ID, ROLE),\n" +
            "\t\t\tFOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE);\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_ROLE_MAPPING (\n" +
            "\t\t\tID INTEGER AUTO_INCREMENT,\n" +
            "\t\t\tIDP_ROLE_ID INTEGER,\n" +
            "\t\t\tTENANT_ID INTEGER,\n" +
            "\t\t\tUSER_STORE_ID VARCHAR (253),\n" +
            "\t\t\tLOCAL_ROLE VARCHAR(253),\t\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (IDP_ROLE_ID, TENANT_ID, USER_STORE_ID, LOCAL_ROLE),\n" +
            "\t\t\tFOREIGN KEY (IDP_ROLE_ID) REFERENCES IDP_ROLE(ID) ON DELETE CASCADE);\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_CLAIM (\n" +
            "\t\t\tID INTEGER AUTO_INCREMENT,\n" +
            "\t\t\tIDP_ID INTEGER,\n" +
            "\t\t\tTENANT_ID INTEGER,\n" +
            "\t\t\tCLAIM VARCHAR(254),\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (IDP_ID, CLAIM),\n" +
            "\t\t\tFOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE);\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_CLAIM_MAPPING (\n" +
            "\t\t\tID INTEGER AUTO_INCREMENT,\n" +
            "\t\t\tIDP_CLAIM_ID INTEGER,\n" +
            "\t\t\tTENANT_ID INTEGER,\t\t\t\n" +
            "\t\t\tLOCAL_CLAIM VARCHAR(253),\n" +
            "\t\t    \tDEFAULT_VALUE VARCHAR(255),\n" +
            "\t\t\tIS_REQUESTED VARCHAR(128) DEFAULT '0',\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (IDP_CLAIM_ID, TENANT_ID, LOCAL_CLAIM),\n" +
            "\t\t\tFOREIGN KEY (IDP_CLAIM_ID) REFERENCES IDP_CLAIM(ID) ON DELETE CASCADE);\t\t\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_AUTHENTICATOR (\n" +
            "            ID INTEGER AUTO_INCREMENT,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            IDP_ID INTEGER,\n" +
            "            NAME VARCHAR(255) NOT NULL,\n" +
            "            IS_ENABLED CHAR (1) DEFAULT '1',\n" +
            "            DISPLAY_NAME VARCHAR(255),\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, IDP_ID, NAME),\n" +
            "            FOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE);\n" +
            "\n" +
            "INSERT INTO IDP_AUTHENTICATOR (TENANT_ID, IDP_ID, NAME) VALUES (-1234, 1, 'samlsso');\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_AUTHENTICATOR_PROPERTY (\n" +
            "            ID INTEGER AUTO_INCREMENT,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            AUTHENTICATOR_ID INTEGER,\n" +
            "            PROPERTY_KEY VARCHAR(255) NOT NULL,\n" +
            "            PROPERTY_VALUE VARCHAR(2047),\n" +
            "            IS_SECRET CHAR (1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, AUTHENTICATOR_ID, PROPERTY_KEY),\n" +
            "            FOREIGN KEY (AUTHENTICATOR_ID) REFERENCES IDP_AUTHENTICATOR(ID) ON DELETE CASCADE);\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_PROVISIONING_CONFIG (\n" +
            "            ID INTEGER AUTO_INCREMENT,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            IDP_ID INTEGER,\n" +
            "            PROVISIONING_CONNECTOR_TYPE VARCHAR(255) NOT NULL,\n" +
            "            IS_ENABLED CHAR (1) DEFAULT '0',\n" +
            "            IS_BLOCKING CHAR (1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, IDP_ID, PROVISIONING_CONNECTOR_TYPE),\n" +
            "            FOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE);\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_PROV_CONFIG_PROPERTY (\n" +
            "            ID INTEGER AUTO_INCREMENT,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            PROVISIONING_CONFIG_ID INTEGER,\n" +
            "            PROPERTY_KEY VARCHAR(255) NOT NULL,\n" +
            "            PROPERTY_VALUE VARCHAR(2048),\n" +
            "            PROPERTY_BLOB_VALUE BLOB,\n" +
            "            PROPERTY_TYPE CHAR(32) NOT NULL,\n" +
            "            IS_SECRET CHAR (1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, PROVISIONING_CONFIG_ID, PROPERTY_KEY),\n" +
            "            FOREIGN KEY (PROVISIONING_CONFIG_ID) REFERENCES IDP_PROVISIONING_CONFIG(ID) ON DELETE CASCADE);\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_PROVISIONING_ENTITY (\n" +
            "            ID INTEGER AUTO_INCREMENT,\n" +
            "            PROVISIONING_CONFIG_ID INTEGER,\n" +
            "            ENTITY_TYPE VARCHAR(255) NOT NULL,\n" +
            "            ENTITY_LOCAL_USERSTORE VARCHAR(255) NOT NULL,\n" +
            "            ENTITY_NAME VARCHAR(255) NOT NULL,\n" +
            "            ENTITY_VALUE VARCHAR(255),\n" +
            "            TENANT_ID INTEGER,\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (ENTITY_TYPE, TENANT_ID, ENTITY_LOCAL_USERSTORE, ENTITY_NAME),\n" +
            "            UNIQUE (PROVISIONING_CONFIG_ID, ENTITY_TYPE, ENTITY_VALUE),\n" +
            "            FOREIGN KEY (PROVISIONING_CONFIG_ID) REFERENCES IDP_PROVISIONING_CONFIG(ID) ON DELETE CASCADE);\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_LOCAL_CLAIM (\n" +
            "            ID INTEGER AUTO_INCREMENT,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            IDP_ID INTEGER,\n" +
            "            CLAIM_URI VARCHAR(255) NOT NULL,\n" +
            "            DEFAULT_VALUE VARCHAR(255),\n" +
            "\t    IS_REQUESTED VARCHAR(128) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, IDP_ID, CLAIM_URI),\n" +
            "            FOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE);\n" +
            "\n" +
            "-- End of IDN-APPLICATION-MGT Tables--\n" +
            "\n" +
            "\n" +
            "ALTER TABLE AM_APPLICATION_KEY_MAPPING DROP PRIMARY KEY;\n" +
            "ALTER TABLE AM_APPLICATION_KEY_MAPPING ALTER CONSUMER_KEY SET NULL;\n" +
            "ALTER TABLE AM_APPLICATION_KEY_MAPPING ADD PRIMARY KEY(APPLICATION_ID,KEY_TYPE);\n" +
            "ALTER TABLE AM_APPLICATION_KEY_MAPPING ADD STATE VARCHAR(30) DEFAULT 'COMPLETED';\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS AM_APPLICATION_REGISTRATION (\n" +
            "    REG_ID INT AUTO_INCREMENT,\n" +
            "    SUBSCRIBER_ID INT,\n" +
            "    WF_REF VARCHAR(255) NOT NULL,\n" +
            "    APP_ID INT,\n" +
            "    TOKEN_TYPE VARCHAR(30),\n" +
            "    ALLOWED_DOMAINS VARCHAR(256),\n" +
            "    VALIDITY_PERIOD BIGINT,\n" +
            "    UNIQUE (SUBSCRIBER_ID,APP_ID,TOKEN_TYPE),\n" +
            "    FOREIGN KEY(SUBSCRIBER_ID) REFERENCES AM_SUBSCRIBER(SUBSCRIBER_ID) ON UPDATE CASCADE ON DELETE RESTRICT,\n" +
            "    FOREIGN KEY(APP_ID) REFERENCES AM_APPLICATION(APPLICATION_ID) ON UPDATE CASCADE ON DELETE RESTRICT,\n" +
            "    PRIMARY KEY (REG_ID)\n" +
            ");\n" +
            " \n" +
            "CREATE TABLE IF NOT EXISTS AM_API_SCOPES (\n" +
            "   API_ID  INTEGER NOT NULL,\n" +
            "   SCOPE_ID  INTEGER NOT NULL,\n" +
            "   FOREIGN KEY (API_ID) REFERENCES AM_API (API_ID) ON DELETE CASCADE  ON UPDATE CASCADE,\n" +
            "   FOREIGN KEY (SCOPE_ID) REFERENCES IDN_OAUTH2_SCOPE (SCOPE_ID) ON DELETE CASCADE ON UPDATE CASCADE\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS AM_API_DEFAULT_VERSION (\n" +
            "            DEFAULT_VERSION_ID INT AUTO_INCREMENT, \n" +
            "            API_NAME VARCHAR(256) NOT NULL ,\n" +
            "            API_PROVIDER VARCHAR(256) NOT NULL , \n" +
            "            DEFAULT_API_VERSION VARCHAR(30) , \n" +
            "            PUBLISHED_DEFAULT_API_VERSION VARCHAR(30) ,\n" +
            "            PRIMARY KEY (DEFAULT_VERSION_ID)\n" +
            ");\n" +
            "\n" +
            "\n";

    public static final String MSSQL_QUERY_16_TO_17 = "ALTER TABLE IDN_OAUTH_CONSUMER_APPS DROP COLUMN  LOGIN_PAGE_URL;\n" +
            "ALTER TABLE IDN_OAUTH_CONSUMER_APPS DROP COLUMN  ERROR_PAGE_URL;\n" +
            "ALTER TABLE IDN_OAUTH_CONSUMER_APPS DROP COLUMN  CONSENT_PAGE_URL;\n" +
            "\n" +
            "ALTER TABLE AM_API_URL_MAPPING ADD MEDIATION_SCRIPT VARBINARY(MAX) DEFAULT NULL;\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[IDN_OAUTH2_SCOPE]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE IDN_OAUTH2_SCOPE (\n" +
            "            SCOPE_ID  INTEGER IDENTITY(1,1),\n" +
            "            SCOPE_KEY VARCHAR(100) NOT NULL,\n" +
            "            NAME VARCHAR(255) NULL,\n" +
            "            DESCRIPTION VARCHAR(512) NULL,\n" +
            "            TENANT_ID  INTEGER NOT NULL DEFAULT 0,\n" +
            "\t\t\tROLES VARCHAR (500) NULL,\n" +
            "            PRIMARY KEY (SCOPE_ID)\n" +
            ");\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[IDN_OAUTH2_RESOURCE_SCOPE]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE IDN_OAUTH2_RESOURCE_SCOPE (\n" +
            "            RESOURCE_PATH VARCHAR(255) NOT NULL,\n" +
            "            SCOPE_ID  INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (RESOURCE_PATH),\n" +
            "            FOREIGN KEY (SCOPE_ID) REFERENCES IDN_OAUTH2_SCOPE (SCOPE_ID) ON DELETE CASCADE ON UPDATE CASCADE\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IDN_SCIM_GROUP (\n" +
            "\t\t\tID INTEGER IDENTITY(1,1),\n" +
            "\t\t\tTENANT_ID INTEGER NOT NULL,\n" +
            "\t\t\tROLE_NAME VARCHAR(255) NOT NULL,\n" +
            "            ATTR_NAME VARCHAR(1024) NOT NULL,\n" +
            "\t\t\tATTR_VALUE VARCHAR(1024),\n" +
            "            PRIMARY KEY (ID)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IDN_SCIM_PROVIDER (\n" +
            "            CONSUMER_ID VARCHAR(255) NOT NULL,\n" +
            "            PROVIDER_ID VARCHAR(255) NOT NULL,\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            USER_PASSWORD VARCHAR(255) NOT NULL,\n" +
            "            USER_URL VARCHAR(1024) NOT NULL,\n" +
            "\t\t\tGROUP_URL VARCHAR(1024),\n" +
            "\t\t\tBULK_URL VARCHAR(1024),\n" +
            "            PRIMARY KEY (CONSUMER_ID,PROVIDER_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IDN_OPENID_REMEMBER_ME (\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            TENANT_ID INTEGER DEFAULT 0,\n" +
            "            COOKIE_VALUE VARCHAR(1024),\n" +
            "            CREATED_TIME DATETIME,\n" +
            "            PRIMARY KEY (USER_NAME, TENANT_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IDN_OPENID_ASSOCIATIONS (\n" +
            "\t\t\tHANDLE VARCHAR(255) NOT NULL,\n" +
            "\t\t\tASSOC_TYPE VARCHAR(255) NOT NULL,\n" +
            "\t\t\tEXPIRE_IN DATETIME NOT NULL,\n" +
            "\t\t\tMAC_KEY VARCHAR(255) NOT NULL,\n" +
            "\t\t\tASSOC_STORE VARCHAR(128) DEFAULT 'SHARED',\n" +
            "\t\t\tPRIMARY KEY (HANDLE)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IDN_STS_STORE (\n" +
            "            ID INTEGER  IDENTITY(1,1),\n" +
            "            TOKEN_ID VARCHAR(255) NOT NULL,\n" +
            "            TOKEN_CONTENT VARBINARY(MAX) NOT NULL,\n" +
            "            CREATE_DATE DATETIME NOT NULL,\n" +
            "            EXPIRE_DATE DATETIME NOT NULL,\n" +
            "            STATE INTEGER DEFAULT 0,\n" +
            "            PRIMARY KEY (ID)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IDN_IDENTITY_USER_DATA (\n" +
            "            TENANT_ID INTEGER DEFAULT -1234,\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            DATA_KEY VARCHAR(255) NOT NULL,\n" +
            "            DATA_VALUE VARCHAR(255) NOT NULL,\n" +
            "            PRIMARY KEY (TENANT_ID, USER_NAME, DATA_KEY)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IDN_IDENTITY_META_DATA (\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            TENANT_ID INTEGER DEFAULT -1234,\n" +
            "            METADATA_TYPE VARCHAR(255) NOT NULL,\n" +
            "            METADATA VARCHAR(255) NOT NULL,\n" +
            "            VALID VARCHAR(255) NOT NULL,\n" +
            "            PRIMARY KEY (TENANT_ID, USER_NAME, METADATA_TYPE,METADATA)\n" +
            ");\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[IDN_THRIFT_SESSION]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  IDN_THRIFT_SESSION (\n" +
            "            SESSION_ID VARCHAR(255) NOT NULL,\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            CREATED_TIME VARCHAR(255) NOT NULL,\n" +
            "            LAST_MODIFIED_TIME VARCHAR(255) NOT NULL,\n" +
            "            PRIMARY KEY (SESSION_ID)\n" +
            ");\n" +
            "\n" +
            "-- End of IDN Tables --\n" +
            "\n" +
            "\n" +
            "-- Start of IDN-APPLICATION-MGT Tables--\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[SP_APP]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  SP_APP (\n" +
            "            ID INTEGER NOT NULL  IDENTITY(1,1),\n" +
            "            TENANT_ID INTEGER NOT NULL,\n" +
            "\t    \tAPP_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    \tUSER_STORE VARCHAR (255) NOT NULL,\n" +
            "            USERNAME VARCHAR (255) NOT NULL ,\n" +
            "            DESCRIPTION VARCHAR (1024),\n" +
            "\t    \tROLE_CLAIM VARCHAR (512),\n" +
            "            AUTH_TYPE VARCHAR (255) NOT NULL,\n" +
            "\t    \tPROVISIONING_USERSTORE_DOMAIN VARCHAR (512),\n" +
            "\t    \tIS_LOCAL_CLAIM_DIALECT CHAR(1) DEFAULT '1',\n" +
            "\t    \tIS_SEND_LOCAL_SUBJECT_ID CHAR(1) DEFAULT '0',\n" +
            "\t    \tIS_SEND_AUTH_LIST_OF_IDPS CHAR(1) DEFAULT '0',\n" +
            "\t    \tSUBJECT_CLAIM_URI VARCHAR (512),\n" +
            "\t    \tIS_SAAS_APP CHAR(1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID)\n" +
            ");\n" +
            "\n" +
            "ALTER TABLE SP_APP ADD CONSTRAINT APPLICATION_NAME_CONSTRAINT UNIQUE(APP_NAME, TENANT_ID);\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[SP_INBOUND_AUTH]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  SP_INBOUND_AUTH (\n" +
            "            ID INTEGER NOT NULL  IDENTITY(1,1),\n" +
            "\t     \tTENANT_ID INTEGER NOT NULL,\n" +
            "\t     \tINBOUND_AUTH_KEY VARCHAR (255) NOT NULL,\n" +
            "            INBOUND_AUTH_TYPE VARCHAR (255) NOT NULL,\n" +
            "            PROP_NAME VARCHAR (255),\n" +
            "            PROP_VALUE VARCHAR (1024) ,\n" +
            "\t     \tAPP_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID)\n" +
            ");\n" +
            "\n" +
            "ALTER TABLE SP_INBOUND_AUTH ADD CONSTRAINT APPLICATION_ID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[SP_AUTH_STEP]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  SP_AUTH_STEP (\n" +
            "            ID INTEGER NOT NULL  IDENTITY(1,1),\n" +
            "            TENANT_ID INTEGER NOT NULL,\n" +
            "\t     \tSTEP_ORDER INTEGER DEFAULT 1,\n" +
            "            APP_ID INTEGER NOT NULL ,\n" +
            "            IS_SUBJECT_STEP CHAR(1) DEFAULT '0',\n" +
            "            IS_ATTRIBUTE_STEP CHAR(1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID)\n" +
            ");\n" +
            "\n" +
            "ALTER TABLE SP_AUTH_STEP ADD CONSTRAINT APPLICATION_ID_CONSTRAINT_STEP FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[SP_FEDERATED_IDP]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  SP_FEDERATED_IDP (\n" +
            "            ID INTEGER NOT NULL,\n" +
            "            TENANT_ID INTEGER NOT NULL,\n" +
            "            AUTHENTICATOR_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID, AUTHENTICATOR_ID)\n" +
            ");\n" +
            "\n" +
            "ALTER TABLE SP_FEDERATED_IDP ADD CONSTRAINT STEP_ID_CONSTRAINT FOREIGN KEY (ID) REFERENCES SP_AUTH_STEP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[SP_CLAIM_MAPPING]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  SP_CLAIM_MAPPING (\n" +
            "\t    \tID INTEGER NOT NULL  IDENTITY(1,1),\n" +
            "\t    \tTENANT_ID INTEGER NOT NULL,\n" +
            "\t    \tIDP_CLAIM VARCHAR (512) NOT NULL ,\n" +
            "            SP_CLAIM VARCHAR (512) NOT NULL ,\n" +
            "\t   \t\tAPP_ID INTEGER NOT NULL,\n" +
            "\t    \tIS_REQUESTED VARCHAR(128) DEFAULT '0',\n" +
            "\t\t\tDEFAULT_VALUE VARCHAR(255),\n" +
            "            PRIMARY KEY (ID)\n" +
            ");\n" +
            "\n" +
            "ALTER TABLE SP_CLAIM_MAPPING ADD CONSTRAINT CLAIMID_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[SP_ROLE_MAPPING]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  SP_ROLE_MAPPING (\n" +
            "\t    \tID INTEGER NOT NULL  IDENTITY(1,1),\n" +
            "\t    \tTENANT_ID INTEGER NOT NULL,\n" +
            "\t    \tIDP_ROLE VARCHAR (255) NOT NULL ,\n" +
            "            SP_ROLE VARCHAR (255) NOT NULL ,\n" +
            "\t    \tAPP_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID)\n" +
            ");\n" +
            "\n" +
            "ALTER TABLE SP_ROLE_MAPPING ADD CONSTRAINT ROLEID_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[SP_REQ_PATH_AUTHENTICATOR]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  SP_REQ_PATH_AUTHENTICATOR (\n" +
            "\t    \tID INTEGER NOT NULL  IDENTITY(1,1),\n" +
            "\t    \tTENANT_ID INTEGER NOT NULL,\n" +
            "\t    \tAUTHENTICATOR_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    \tAPP_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID)\n" +
            ");\n" +
            "\n" +
            "ALTER TABLE SP_REQ_PATH_AUTHENTICATOR ADD CONSTRAINT REQ_AUTH_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[SP_PROVISIONING_CONNECTOR]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  SP_PROVISIONING_CONNECTOR (\n" +
            "\t    \tID INTEGER NOT NULL  IDENTITY(1,1),\n" +
            "\t    \tTENANT_ID INTEGER NOT NULL,\n" +
            "            IDP_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    \tCONNECTOR_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    \tAPP_ID INTEGER NOT NULL,\n" +
            "\t    \tIS_JIT_ENABLED CHAR(1) NOT NULL DEFAULT '0',\n" +
            "\t\t\tBLOCKING CHAR(1) NOT NULL DEFAULT '0',\n" +
            "            PRIMARY KEY (ID)\n" +
            ");\n" +
            "\n" +
            "ALTER TABLE SP_PROVISIONING_CONNECTOR ADD CONSTRAINT PRO_CONNECTOR_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[IDP]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  IDP (\n" +
            "\t\t\tID INTEGER  IDENTITY(1,1),\n" +
            "\t\t\tTENANT_ID INTEGER,\n" +
            "\t\t\tNAME VARCHAR(254) NOT NULL,\n" +
            "\t\t\tIS_ENABLED CHAR(1) NOT NULL DEFAULT '1',\n" +
            "\t\t\tIS_PRIMARY CHAR(1) NOT NULL DEFAULT '0',\n" +
            "\t\t\tHOME_REALM_ID VARCHAR(254),\n" +
            "\t\t\tIMAGE VARBINARY(MAX),\n" +
            "\t\t\tCERTIFICATE VARBINARY(MAX),\n" +
            "\t\t\tALIAS VARCHAR(254),\n" +
            "\t\t\tINBOUND_PROV_ENABLED CHAR (1) NOT NULL DEFAULT '0',\n" +
            "\t\t\tINBOUND_PROV_USER_STORE_ID VARCHAR(254),\n" +
            " \t\t\tUSER_CLAIM_URI VARCHAR(254),\n" +
            " \t\t\tROLE_CLAIM_URI VARCHAR(254),\n" +
            "  \t\t\tDESCRIPTION VARCHAR (1024),\n" +
            " \t\t\tDEFAULT_AUTHENTICATOR_NAME VARCHAR(254),\n" +
            " \t\t\tDEFAULT_PRO_CONNECTOR_NAME VARCHAR(254),\n" +
            " \t\t\tPROVISIONING_ROLE VARCHAR(128),\n" +
            " \t\t\tIS_FEDERATION_HUB CHAR(1) NOT NULL DEFAULT '0',\n" +
            " \t\t\tIS_LOCAL_CLAIM_DIALECT CHAR(1) NOT NULL DEFAULT '0',\n" +
            "\t                DISPLAY_NAME VARCHAR(255),\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (TENANT_ID, NAME)\n" +
            ");\n" +
            "\n" +
            "INSERT INTO IDP (TENANT_ID, NAME, HOME_REALM_ID) VALUES (-1234, 'LOCAL', 'localhost');\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[IDP_ROLE]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  IDP_ROLE (\n" +
            "\t\t\tID INTEGER  IDENTITY(1,1),\n" +
            "\t\t\tIDP_ID INTEGER,\n" +
            "\t\t\tTENANT_ID INTEGER,\n" +
            "\t\t\tROLE VARCHAR(254),\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (IDP_ID, ROLE),\n" +
            "\t\t\tFOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE\n" +
            ");\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[IDP_ROLE_MAPPING]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  IDP_ROLE_MAPPING (\n" +
            "\t\t\tID INTEGER  IDENTITY(1,1),\n" +
            "\t\t\tIDP_ROLE_ID INTEGER,\n" +
            "\t\t\tTENANT_ID INTEGER,\n" +
            "\t\t\tUSER_STORE_ID VARCHAR (253),\n" +
            "\t\t\tLOCAL_ROLE VARCHAR(253),\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (IDP_ROLE_ID, TENANT_ID, USER_STORE_ID, LOCAL_ROLE),\n" +
            "\t\t\tFOREIGN KEY (IDP_ROLE_ID) REFERENCES IDP_ROLE(ID) ON DELETE CASCADE\n" +
            ");\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[IDP_CLAIM]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  IDP_CLAIM (\n" +
            "\t\t\tID INTEGER  IDENTITY(1,1),\n" +
            "\t\t\tIDP_ID INTEGER,\n" +
            "\t\t\tTENANT_ID INTEGER,\n" +
            "\t\t\tCLAIM VARCHAR(254),\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (IDP_ID, CLAIM),\n" +
            "\t\t\tFOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE\n" +
            ");\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[IDP_CLAIM_MAPPING]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  IDP_CLAIM_MAPPING (\n" +
            "\t\t\tID INTEGER  IDENTITY(1,1),\n" +
            "\t\t\tIDP_CLAIM_ID INTEGER,\n" +
            "\t\t\tTENANT_ID INTEGER,\n" +
            "\t\t\tLOCAL_CLAIM VARCHAR(253),\n" +
            "\t\t    \tDEFAULT_VALUE VARCHAR(255),\n" +
            "\t\t\tIS_REQUESTED VARCHAR(128) DEFAULT '0',\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (IDP_CLAIM_ID, TENANT_ID, LOCAL_CLAIM),\n" +
            "\t\t\tFOREIGN KEY (IDP_CLAIM_ID) REFERENCES IDP_CLAIM(ID) ON DELETE CASCADE\n" +
            ");\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[IDP_AUTHENTICATOR]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  IDP_AUTHENTICATOR (\n" +
            "            ID INTEGER  IDENTITY(1,1),\n" +
            "            TENANT_ID INTEGER,\n" +
            "            IDP_ID INTEGER,\n" +
            "            NAME VARCHAR(255) NOT NULL,\n" +
            "            IS_ENABLED CHAR (1) DEFAULT '1',\n" +
            "            DISPLAY_NAME VARCHAR(255),\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, IDP_ID, NAME),\n" +
            "            FOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE\n" +
            ");\n" +
            "\n" +
            "INSERT INTO IDP_AUTHENTICATOR (TENANT_ID, IDP_ID, NAME) VALUES (-1234, 1, 'samlsso');\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[IDP_AUTHENTICATOR_PROPERTY]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  IDP_AUTHENTICATOR_PROPERTY (\n" +
            "            ID INTEGER  IDENTITY(1,1),\n" +
            "            TENANT_ID INTEGER,\n" +
            "            AUTHENTICATOR_ID INTEGER,\n" +
            "            PROPERTY_KEY VARCHAR(255) NOT NULL,\n" +
            "            PROPERTY_VALUE VARCHAR(2047),\n" +
            "            IS_SECRET CHAR (1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, AUTHENTICATOR_ID, PROPERTY_KEY),\n" +
            "            FOREIGN KEY (AUTHENTICATOR_ID) REFERENCES IDP_AUTHENTICATOR(ID) ON DELETE CASCADE\n" +
            ");\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[IDP_PROVISIONING_CONFIG]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  IDP_PROVISIONING_CONFIG (\n" +
            "            ID INTEGER  IDENTITY(1,1),\n" +
            "            TENANT_ID INTEGER,\n" +
            "            IDP_ID INTEGER,\n" +
            "            PROVISIONING_CONNECTOR_TYPE VARCHAR(255) NOT NULL,\n" +
            "            IS_ENABLED CHAR (1) DEFAULT '0',\n" +
            "            IS_BLOCKING CHAR (1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, IDP_ID, PROVISIONING_CONNECTOR_TYPE),\n" +
            "            FOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE\n" +
            ");\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[IDP_PROV_CONFIG_PROPERTY]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  IDP_PROV_CONFIG_PROPERTY (\n" +
            "            ID INTEGER  IDENTITY(1,1),\n" +
            "            TENANT_ID INTEGER,\n" +
            "            PROVISIONING_CONFIG_ID INTEGER,\n" +
            "            PROPERTY_KEY VARCHAR(255) NOT NULL,\n" +
            "            PROPERTY_VALUE VARCHAR(2048),\n" +
            "            PROPERTY_BLOB_VALUE VARBINARY(MAX),\n" +
            "            PROPERTY_TYPE CHAR(32) NOT NULL,\n" +
            "            IS_SECRET CHAR (1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, PROVISIONING_CONFIG_ID, PROPERTY_KEY),\n" +
            "            FOREIGN KEY (PROVISIONING_CONFIG_ID) REFERENCES IDP_PROVISIONING_CONFIG(ID) ON DELETE CASCADE\n" +
            ");\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[IDP_PROVISIONING_ENTITY]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  IDP_PROVISIONING_ENTITY (\n" +
            "            ID INTEGER  IDENTITY(1,1),\n" +
            "            PROVISIONING_CONFIG_ID INTEGER,\n" +
            "            ENTITY_TYPE VARCHAR(255) NOT NULL,\n" +
            "            ENTITY_LOCAL_USERSTORE VARCHAR(255) NOT NULL,\n" +
            "            ENTITY_NAME VARCHAR(255) NOT NULL,\n" +
            "            ENTITY_VALUE VARCHAR(255),\n" +
            "            TENANT_ID INTEGER,\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (ENTITY_TYPE, TENANT_ID, ENTITY_LOCAL_USERSTORE, ENTITY_NAME),\n" +
            "            UNIQUE (PROVISIONING_CONFIG_ID, ENTITY_TYPE, ENTITY_VALUE),\n" +
            "            FOREIGN KEY (PROVISIONING_CONFIG_ID) REFERENCES IDP_PROVISIONING_CONFIG(ID) ON DELETE CASCADE\n" +
            ");\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[IDP_LOCAL_CLAIM]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  IDP_LOCAL_CLAIM (\n" +
            "            ID INTEGER  IDENTITY(1,1),\n" +
            "            TENANT_ID INTEGER,\n" +
            "            IDP_ID INTEGER,\n" +
            "            CLAIM_URI VARCHAR(255) NOT NULL,\n" +
            "            DEFAULT_VALUE VARCHAR(255),\n" +
            "\t        IS_REQUESTED VARCHAR(128) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, IDP_ID, CLAIM_URI),\n" +
            "            FOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE\n" +
            ");\n" +
            "-- End of IDN-APPLICATION-MGT Tables--\n" +
            "\n" +
            "ALTER TABLE AM_APPLICATION_KEY_MAPPING ADD STATE VARCHAR(30) DEFAULT 'COMPLETED';\n" +
            "\n" +
            "DECLARE @SQL VARCHAR(4000);\n" +
            "SET @SQL = 'ALTER TABLE |TABLE_NAME| DROP CONSTRAINT |CONSTRAINT_NAME|';\n" +
            "\n" +
            "SET @SQL = REPLACE(@SQL, '|CONSTRAINT_NAME|',( SELECT name FROM sysobjects WHERE xtype = 'PK' AND parent_obj = OBJECT_ID('AM_APPLICATION_KEY_MAPPING')));\n" +
            "SET @SQL = REPLACE(@SQL,'|TABLE_NAME|','AM_APPLICATION_KEY_MAPPING');\n" +
            "EXEC (@SQL);\n" +
            "\n" +
            "ALTER TABLE AM_APPLICATION_KEY_MAPPING ADD PRIMARY KEY(APPLICATION_ID,KEY_TYPE);\n" +
            "ALTER TABLE AM_APPLICATION_KEY_MAPPING ALTER COLUMN CONSUMER_KEY VARCHAR(512) NULL;\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[AM_APPLICATION_REGISTRATION]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE AM_APPLICATION_REGISTRATION (\n" +
            "    REG_ID INTEGER IDENTITY(1,1),\n" +
            "    SUBSCRIBER_ID INTEGER,\n" +
            "    WF_REF VARCHAR(255) NOT NULL,\n" +
            "    APP_ID INTEGER,\n" +
            "    TOKEN_TYPE VARCHAR(30),\n" +
            "    ALLOWED_DOMAINS VARCHAR(256),\n" +
            "    VALIDITY_PERIOD BIGINT,\n" +
            "    UNIQUE (SUBSCRIBER_ID,APP_ID,TOKEN_TYPE),\n" +
            "    FOREIGN KEY(SUBSCRIBER_ID) REFERENCES AM_SUBSCRIBER(SUBSCRIBER_ID) ON DELETE NO ACTION,\n" +
            "    FOREIGN KEY(APP_ID) REFERENCES AM_APPLICATION(APPLICATION_ID) ON UPDATE CASCADE ON DELETE NO ACTION,\n" +
            "    PRIMARY KEY (REG_ID)\n" +
            ");\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[AM_API_SCOPES]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  AM_API_SCOPES (\n" +
            "   API_ID  INTEGER NOT NULL,\n" +
            "   SCOPE_ID  INTEGER NOT NULL,\n" +
            "   FOREIGN KEY (API_ID) REFERENCES AM_API (API_ID) ON DELETE CASCADE  ON UPDATE CASCADE,\n" +
            "   FOREIGN KEY (SCOPE_ID) REFERENCES IDN_OAUTH2_SCOPE (SCOPE_ID) ON DELETE CASCADE ON UPDATE CASCADE\n" +
            ");\n" +
            "\n" +
            "IF NOT  EXISTS (SELECT * FROM SYS.OBJECTS WHERE OBJECT_ID = OBJECT_ID(N'[DBO].[AM_API_DEFAULT_VERSION]') AND TYPE IN (N'U'))\n" +
            "CREATE TABLE  AM_API_DEFAULT_VERSION (\n" +
            "            DEFAULT_VERSION_ID INT  IDENTITY(1,1), \n" +
            "            API_NAME VARCHAR(256) NOT NULL ,\n" +
            "            API_PROVIDER VARCHAR(256) NOT NULL , \n" +
            "            DEFAULT_API_VERSION VARCHAR(30) , \n" +
            "            PUBLISHED_DEFAULT_API_VERSION VARCHAR(30) ,\n" +
            "            PRIMARY KEY (DEFAULT_VERSION_ID)\n" +
            ");\n";
    public static final String MYSQL_QUERY_16_TO_17 = "ALTER TABLE IDN_OAUTH_CONSUMER_APPS DROP LOGIN_PAGE_URL;\n" +
            "ALTER TABLE IDN_OAUTH_CONSUMER_APPS DROP ERROR_PAGE_URL;\n" +
            "ALTER TABLE IDN_OAUTH_CONSUMER_APPS DROP CONSENT_PAGE_URL;\n" +
            "\n" +
            "ALTER TABLE AM_API_URL_MAPPING ADD MEDIATION_SCRIPT BLOB DEFAULT NULL;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDN_OAUTH2_SCOPE (\n" +
            "            SCOPE_ID INT(11) NOT NULL AUTO_INCREMENT,\n" +
            "            SCOPE_KEY VARCHAR(100) NOT NULL,\n" +
            "            NAME VARCHAR(255) NULL,\n" +
            "            DESCRIPTION VARCHAR(512) NULL,\n" +
            "            TENANT_ID INT(11) NOT NULL DEFAULT 0,\n" +
            "\t    ROLES VARCHAR (500) NULL,\n" +
            "            PRIMARY KEY (SCOPE_ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDN_OAUTH2_RESOURCE_SCOPE (\n" +
            "            RESOURCE_PATH VARCHAR(255) NOT NULL,\n" +
            "            SCOPE_ID INTEGER (11) NOT NULL,\n" +
            "            PRIMARY KEY (RESOURCE_PATH),\n" +
            "            FOREIGN KEY (SCOPE_ID) REFERENCES IDN_OAUTH2_SCOPE (SCOPE_ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IDN_SCIM_GROUP (\n" +
            "\t\t\tID INTEGER AUTO_INCREMENT,\n" +
            "\t\t\tTENANT_ID INTEGER NOT NULL,\n" +
            "\t\t\tROLE_NAME VARCHAR(255) NOT NULL,\n" +
            "            ATTR_NAME VARCHAR(1024) NOT NULL,\n" +
            "\t\t\tATTR_VALUE VARCHAR(1024),\n" +
            "            PRIMARY KEY (ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IDN_SCIM_PROVIDER (\n" +
            "            CONSUMER_ID VARCHAR(255) NOT NULL,\n" +
            "            PROVIDER_ID VARCHAR(255) NOT NULL,\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            USER_PASSWORD VARCHAR(255) NOT NULL,\n" +
            "            USER_URL VARCHAR(1024) NOT NULL,\n" +
            "\t\t\tGROUP_URL VARCHAR(1024),\n" +
            "\t\t\tBULK_URL VARCHAR(1024),\n" +
            "            PRIMARY KEY (CONSUMER_ID,PROVIDER_ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IDN_OPENID_REMEMBER_ME (\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            TENANT_ID INTEGER DEFAULT 0,\n" +
            "            COOKIE_VALUE VARCHAR(1024),\n" +
            "            CREATED_TIME TIMESTAMP,\n" +
            "            PRIMARY KEY (USER_NAME, TENANT_ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IDN_OPENID_ASSOCIATIONS (\n" +
            "\t\t\tHANDLE VARCHAR(255) NOT NULL,\n" +
            "\t\t\tASSOC_TYPE VARCHAR(255) NOT NULL,\n" +
            "\t\t\tEXPIRE_IN TIMESTAMP NOT NULL,\n" +
            "\t\t\tMAC_KEY VARCHAR(255) NOT NULL,\n" +
            "\t\t\tASSOC_STORE VARCHAR(128) DEFAULT 'SHARED',\n" +
            "\t\t\tPRIMARY KEY (HANDLE)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IDN_STS_STORE (\n" +
            "            ID INTEGER AUTO_INCREMENT,\n" +
            "            TOKEN_ID VARCHAR(255) NOT NULL,\n" +
            "            TOKEN_CONTENT BLOB(1024) NOT NULL,\n" +
            "            CREATE_DATE TIMESTAMP NOT NULL,\n" +
            "            EXPIRE_DATE TIMESTAMP NOT NULL,\n" +
            "            STATE INTEGER DEFAULT 0,\n" +
            "            PRIMARY KEY (ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IDN_IDENTITY_USER_DATA (\n" +
            "            TENANT_ID INTEGER DEFAULT -1234,\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            DATA_KEY VARCHAR(255) NOT NULL,\n" +
            "            DATA_VALUE VARCHAR(255) NOT NULL,\n" +
            "            PRIMARY KEY (TENANT_ID, USER_NAME, DATA_KEY)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IDN_IDENTITY_META_DATA (\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            TENANT_ID INTEGER DEFAULT -1234,\n" +
            "            METADATA_TYPE VARCHAR(255) NOT NULL,\n" +
            "            METADATA VARCHAR(255) NOT NULL,\n" +
            "            VALID VARCHAR(255) NOT NULL,\n" +
            "            PRIMARY KEY (TENANT_ID, USER_NAME, METADATA_TYPE,METADATA)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDN_THRIFT_SESSION (\n" +
            "            SESSION_ID VARCHAR(255) NOT NULL,\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            CREATED_TIME VARCHAR(255) NOT NULL,\n" +
            "            LAST_MODIFIED_TIME VARCHAR(255) NOT NULL,\n" +
            "            PRIMARY KEY (SESSION_ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "-- End of IDN Tables --\n" +
            "\n" +
            "\n" +
            "-- Start of IDN-APPLICATION-MGT Tables--\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_APP (\n" +
            "            ID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "            TENANT_ID INTEGER NOT NULL,\n" +
            "\t    \tAPP_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    \tUSER_STORE VARCHAR (255) NOT NULL,\n" +
            "            USERNAME VARCHAR (255) NOT NULL ,\n" +
            "            DESCRIPTION VARCHAR (1024),\n" +
            "\t    \tROLE_CLAIM VARCHAR (512),\n" +
            "            AUTH_TYPE VARCHAR (255) NOT NULL,\n" +
            "\t    \tPROVISIONING_USERSTORE_DOMAIN VARCHAR (512),\n" +
            "\t    \tIS_LOCAL_CLAIM_DIALECT CHAR(1) DEFAULT '1',\n" +
            "\t    \tIS_SEND_LOCAL_SUBJECT_ID CHAR(1) DEFAULT '0',\n" +
            "\t    \tIS_SEND_AUTH_LIST_OF_IDPS CHAR(1) DEFAULT '0',\n" +
            "\t    \tSUBJECT_CLAIM_URI VARCHAR (512),\n" +
            "\t    \tIS_SAAS_APP CHAR(1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "ALTER TABLE SP_APP ADD CONSTRAINT APPLICATION_NAME_CONSTRAINT UNIQUE(APP_NAME, TENANT_ID);\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_INBOUND_AUTH (\n" +
            "            ID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "\t     \tTENANT_ID INTEGER NOT NULL,\n" +
            "\t     \tINBOUND_AUTH_KEY VARCHAR (255) NOT NULL,\n" +
            "            INBOUND_AUTH_TYPE VARCHAR (255) NOT NULL,\n" +
            "            PROP_NAME VARCHAR (255),\n" +
            "            PROP_VALUE VARCHAR (1024) ,\n" +
            "\t     \tAPP_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "ALTER TABLE SP_INBOUND_AUTH ADD CONSTRAINT APPLICATION_ID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_AUTH_STEP (\n" +
            "            ID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "            TENANT_ID INTEGER NOT NULL,\n" +
            "\t     \tSTEP_ORDER INTEGER DEFAULT 1,\n" +
            "            APP_ID INTEGER NOT NULL ,\n" +
            "            IS_SUBJECT_STEP CHAR(1) DEFAULT '0',\n" +
            "            IS_ATTRIBUTE_STEP CHAR(1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "ALTER TABLE SP_AUTH_STEP ADD CONSTRAINT APPLICATION_ID_CONSTRAINT_STEP FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_FEDERATED_IDP (\n" +
            "            ID INTEGER NOT NULL,\n" +
            "            TENANT_ID INTEGER NOT NULL,\n" +
            "            AUTHENTICATOR_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID, AUTHENTICATOR_ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "ALTER TABLE SP_FEDERATED_IDP ADD CONSTRAINT STEP_ID_CONSTRAINT FOREIGN KEY (ID) REFERENCES SP_AUTH_STEP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_CLAIM_MAPPING (\n" +
            "\t    \tID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "\t    \tTENANT_ID INTEGER NOT NULL,\n" +
            "\t    \tIDP_CLAIM VARCHAR (512) NOT NULL ,\n" +
            "            SP_CLAIM VARCHAR (512) NOT NULL ,\n" +
            "\t   \t\tAPP_ID INTEGER NOT NULL,\n" +
            "\t    \tIS_REQUESTED VARCHAR(128) DEFAULT '0',\n" +
            "\t\t\tDEFAULT_VALUE VARCHAR(255),\n" +
            "            PRIMARY KEY (ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "ALTER TABLE SP_CLAIM_MAPPING ADD CONSTRAINT CLAIMID_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_ROLE_MAPPING (\n" +
            "\t    \tID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "\t    \tTENANT_ID INTEGER NOT NULL,\n" +
            "\t    \tIDP_ROLE VARCHAR (255) NOT NULL ,\n" +
            "            SP_ROLE VARCHAR (255) NOT NULL ,\n" +
            "\t    \tAPP_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "ALTER TABLE SP_ROLE_MAPPING ADD CONSTRAINT ROLEID_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_REQ_PATH_AUTHENTICATOR (\n" +
            "\t    \tID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "\t    \tTENANT_ID INTEGER NOT NULL,\n" +
            "\t    \tAUTHENTICATOR_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    \tAPP_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "ALTER TABLE SP_REQ_PATH_AUTHENTICATOR ADD CONSTRAINT REQ_AUTH_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS SP_PROVISIONING_CONNECTOR (\n" +
            "\t    \tID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "\t    \tTENANT_ID INTEGER NOT NULL,\n" +
            "            IDP_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    \tCONNECTOR_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    \tAPP_ID INTEGER NOT NULL,\n" +
            "\t    \tIS_JIT_ENABLED CHAR(1) NOT NULL DEFAULT '0',\n" +
            "\t\tBLOCKING CHAR(1) NOT NULL DEFAULT '0',\n" +
            "            PRIMARY KEY (ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "ALTER TABLE SP_PROVISIONING_CONNECTOR ADD CONSTRAINT PRO_CONNECTOR_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP (\n" +
            "\t\t\tID INTEGER AUTO_INCREMENT,\n" +
            "\t\t\tTENANT_ID INTEGER,\n" +
            "\t\t\tNAME VARCHAR(254) NOT NULL,\n" +
            "\t\t\tIS_ENABLED CHAR(1) NOT NULL DEFAULT '1',\n" +
            "\t\t\tIS_PRIMARY CHAR(1) NOT NULL DEFAULT '0',\n" +
            "\t\t\tHOME_REALM_ID VARCHAR(254),\n" +
            "\t\t\tIMAGE MEDIUMBLOB,\n" +
            "\t\t\tCERTIFICATE BLOB,\n" +
            "\t\t\tALIAS VARCHAR(254),\n" +
            "\t\t\tINBOUND_PROV_ENABLED CHAR (1) NOT NULL DEFAULT '0',\n" +
            "\t\t\tINBOUND_PROV_USER_STORE_ID VARCHAR(254),\n" +
            " \t\t\tUSER_CLAIM_URI VARCHAR(254),\n" +
            " \t\t\tROLE_CLAIM_URI VARCHAR(254),\n" +
            "  \t\t\tDESCRIPTION VARCHAR (1024),\n" +
            " \t\t\tDEFAULT_AUTHENTICATOR_NAME VARCHAR(254),\n" +
            " \t\t\tDEFAULT_PRO_CONNECTOR_NAME VARCHAR(254),\n" +
            " \t\t\tPROVISIONING_ROLE VARCHAR(128),\n" +
            " \t\t\tIS_FEDERATION_HUB CHAR(1) NOT NULL DEFAULT '0',\n" +
            " \t\t\tIS_LOCAL_CLAIM_DIALECT CHAR(1) NOT NULL DEFAULT '0',\n" +
            "\t                DISPLAY_NAME VARCHAR(255),\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (TENANT_ID, NAME)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "INSERT INTO IDP (TENANT_ID, NAME, HOME_REALM_ID) VALUES (-1234, 'LOCAL', 'localhost');\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_ROLE (\n" +
            "\t\t\tID INTEGER AUTO_INCREMENT,\n" +
            "\t\t\tIDP_ID INTEGER,\n" +
            "\t\t\tTENANT_ID INTEGER,\n" +
            "\t\t\tROLE VARCHAR(254),\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (IDP_ID, ROLE),\n" +
            "\t\t\tFOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_ROLE_MAPPING (\n" +
            "\t\t\tID INTEGER AUTO_INCREMENT,\n" +
            "\t\t\tIDP_ROLE_ID INTEGER,\n" +
            "\t\t\tTENANT_ID INTEGER,\n" +
            "\t\t\tUSER_STORE_ID VARCHAR (253),\n" +
            "\t\t\tLOCAL_ROLE VARCHAR(253),\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (IDP_ROLE_ID, TENANT_ID, USER_STORE_ID, LOCAL_ROLE),\n" +
            "\t\t\tFOREIGN KEY (IDP_ROLE_ID) REFERENCES IDP_ROLE(ID) ON DELETE CASCADE\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_CLAIM (\n" +
            "\t\t\tID INTEGER AUTO_INCREMENT,\n" +
            "\t\t\tIDP_ID INTEGER,\n" +
            "\t\t\tTENANT_ID INTEGER,\n" +
            "\t\t\tCLAIM VARCHAR(254),\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (IDP_ID, CLAIM),\n" +
            "\t\t\tFOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_CLAIM_MAPPING (\n" +
            "\t\t\tID INTEGER AUTO_INCREMENT,\n" +
            "\t\t\tIDP_CLAIM_ID INTEGER,\n" +
            "\t\t\tTENANT_ID INTEGER,\n" +
            "\t\t\tLOCAL_CLAIM VARCHAR(253),\n" +
            "\t\t    \tDEFAULT_VALUE VARCHAR(255),\n" +
            "\t\t\tIS_REQUESTED VARCHAR(128) DEFAULT '0',\n" +
            "\t\t\tPRIMARY KEY (ID),\n" +
            "\t\t\tUNIQUE (IDP_CLAIM_ID, TENANT_ID, LOCAL_CLAIM),\n" +
            "\t\t\tFOREIGN KEY (IDP_CLAIM_ID) REFERENCES IDP_CLAIM(ID) ON DELETE CASCADE\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_AUTHENTICATOR (\n" +
            "            ID INTEGER AUTO_INCREMENT,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            IDP_ID INTEGER,\n" +
            "            NAME VARCHAR(255) NOT NULL,\n" +
            "            IS_ENABLED CHAR (1) DEFAULT '1',\n" +
            "            DISPLAY_NAME VARCHAR(255),\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, IDP_ID, NAME),\n" +
            "            FOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "INSERT INTO IDP_AUTHENTICATOR (TENANT_ID, IDP_ID, NAME) VALUES (-1234, 1, 'samlsso');\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_AUTHENTICATOR_PROPERTY (\n" +
            "            ID INTEGER AUTO_INCREMENT,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            AUTHENTICATOR_ID INTEGER,\n" +
            "            PROPERTY_KEY VARCHAR(255) NOT NULL,\n" +
            "            PROPERTY_VALUE VARCHAR(2047),\n" +
            "            IS_SECRET CHAR (1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, AUTHENTICATOR_ID, PROPERTY_KEY),\n" +
            "            FOREIGN KEY (AUTHENTICATOR_ID) REFERENCES IDP_AUTHENTICATOR(ID) ON DELETE CASCADE\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_PROVISIONING_CONFIG (\n" +
            "            ID INTEGER AUTO_INCREMENT,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            IDP_ID INTEGER,\n" +
            "            PROVISIONING_CONNECTOR_TYPE VARCHAR(255) NOT NULL,\n" +
            "            IS_ENABLED CHAR (1) DEFAULT '0',\n" +
            "            IS_BLOCKING CHAR (1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, IDP_ID, PROVISIONING_CONNECTOR_TYPE),\n" +
            "            FOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_PROV_CONFIG_PROPERTY (\n" +
            "            ID INTEGER AUTO_INCREMENT,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            PROVISIONING_CONFIG_ID INTEGER,\n" +
            "            PROPERTY_KEY VARCHAR(255) NOT NULL,\n" +
            "            PROPERTY_VALUE VARCHAR(2048),\n" +
            "            PROPERTY_BLOB_VALUE BLOB,\n" +
            "            PROPERTY_TYPE CHAR(32) NOT NULL,\n" +
            "            IS_SECRET CHAR (1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, PROVISIONING_CONFIG_ID, PROPERTY_KEY),\n" +
            "            FOREIGN KEY (PROVISIONING_CONFIG_ID) REFERENCES IDP_PROVISIONING_CONFIG(ID) ON DELETE CASCADE\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_PROVISIONING_ENTITY (\n" +
            "            ID INTEGER AUTO_INCREMENT,\n" +
            "            PROVISIONING_CONFIG_ID INTEGER,\n" +
            "            ENTITY_TYPE VARCHAR(255) NOT NULL,\n" +
            "            ENTITY_LOCAL_USERSTORE VARCHAR(255) NOT NULL,\n" +
            "            ENTITY_NAME VARCHAR(255) NOT NULL,\n" +
            "            ENTITY_VALUE VARCHAR(255),\n" +
            "            TENANT_ID INTEGER,\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (ENTITY_TYPE, TENANT_ID, ENTITY_LOCAL_USERSTORE, ENTITY_NAME),\n" +
            "            UNIQUE (PROVISIONING_CONFIG_ID, ENTITY_TYPE, ENTITY_VALUE),\n" +
            "            FOREIGN KEY (PROVISIONING_CONFIG_ID) REFERENCES IDP_PROVISIONING_CONFIG(ID) ON DELETE CASCADE\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS IDP_LOCAL_CLAIM (\n" +
            "            ID INTEGER AUTO_INCREMENT,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            IDP_ID INTEGER,\n" +
            "            CLAIM_URI VARCHAR(255) NOT NULL,\n" +
            "            DEFAULT_VALUE VARCHAR(255),\n" +
            "\t        IS_REQUESTED VARCHAR(128) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, IDP_ID, CLAIM_URI),\n" +
            "            FOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE\n" +
            ")ENGINE INNODB;\n" +
            "-- End of IDN-APPLICATION-MGT Tables--\n" +
            "\n" +
            "ALTER TABLE AM_APPLICATION_KEY_MAPPING ADD STATE VARCHAR(30) DEFAULT 'COMPLETED';\n" +
            "\n" +
            "ALTER TABLE AM_APPLICATION_KEY_MAPPING DROP PRIMARY KEY, ADD PRIMARY KEY(APPLICATION_ID,KEY_TYPE);\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS AM_APPLICATION_REGISTRATION (\n" +
            "    REG_ID INT AUTO_INCREMENT,\n" +
            "    SUBSCRIBER_ID INT,\n" +
            "    WF_REF VARCHAR(255) NOT NULL,\n" +
            "    APP_ID INT,\n" +
            "    TOKEN_TYPE VARCHAR(30),\n" +
            "    ALLOWED_DOMAINS VARCHAR(256),\n" +
            "    VALIDITY_PERIOD BIGINT,\n" +
            "    UNIQUE (SUBSCRIBER_ID,APP_ID,TOKEN_TYPE),\n" +
            "    FOREIGN KEY(SUBSCRIBER_ID) REFERENCES AM_SUBSCRIBER(SUBSCRIBER_ID) ON UPDATE CASCADE ON DELETE RESTRICT,\n" +
            "    FOREIGN KEY(APP_ID) REFERENCES AM_APPLICATION(APPLICATION_ID) ON UPDATE CASCADE ON DELETE RESTRICT,\n" +
            "    PRIMARY KEY (REG_ID)\n" +
            ")ENGINE INNODB;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS AM_API_SCOPES (\n" +
            "   API_ID  INTEGER NOT NULL,\n" +
            "   SCOPE_ID  INTEGER NOT NULL,\n" +
            "   FOREIGN KEY (API_ID) REFERENCES AM_API (API_ID) ON DELETE CASCADE  ON UPDATE CASCADE,\n" +
            "   FOREIGN KEY (SCOPE_ID) REFERENCES IDN_OAUTH2_SCOPE (SCOPE_ID) ON DELETE CASCADE ON UPDATE CASCADE\n" +
            ")ENGINE = INNODB;\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS AM_API_DEFAULT_VERSION (\n" +
            "            DEFAULT_VERSION_ID INT AUTO_INCREMENT, \n" +
            "            API_NAME VARCHAR(256) NOT NULL ,\n" +
            "            API_PROVIDER VARCHAR(256) NOT NULL , \n" +
            "            DEFAULT_API_VERSION VARCHAR(30) , \n" +
            "            PUBLISHED_DEFAULT_API_VERSION VARCHAR(30) ,\n" +
            "            PRIMARY KEY (DEFAULT_VERSION_ID)\n" +
            ");\n";
    public static final String ORACLE_QUERY_16_TO_17 = "ALTER TABLE IDN_OAUTH_CONSUMER_APPS DROP COLUMN LOGIN_PAGE_URL\n" +
            "/\n" +
            "ALTER TABLE IDN_OAUTH_CONSUMER_APPS DROP COLUMN ERROR_PAGE_URL\n" +
            "/\n" +
            "ALTER TABLE IDN_OAUTH_CONSUMER_APPS DROP COLUMN CONSENT_PAGE_URL\n" +
            "/\n" +
            "/*\n" +
            "DROP INDEX IDX_AT_CK_AU\n" +
            "/\n" +
            "DROP SEQUENCE IDP_SEQUENCE\n" +
            "/\n" +
            "DROP SEQUENCE IDP_ROLE_MAPPINGS_SEQUENCE\n" +
            "/\n" +
            "DROP SEQUENCE IDP_ROLES_SEQUENCE\n" +
            "/\n" +
            "ALTER TABLE UM_TENANT_IDP_ROLE_MAPPINGS DROP PRIMARY KEY CASCADE\n" +
            "/\n" +
            "ALTER TABLE UM_TENANT_IDP_ROLES DROP PRIMARY KEY CASCADE\n" +
            "/\n" +
            "ALTER TABLE IDP_BASE_TABLE DROP PRIMARY KEY CASCADE\n" +
            "/\n" +
            "ALTER TABLE UM_TENANT_IDP DROP PRIMARY KEY CASCADE\n" +
            "/\n" +
            "DROP TABLE UM_TENANT_IDP_ROLE_MAPPINGS CASCADE CONSTRAINTS\n" +
            "/\n" +
            "DROP TABLE UM_TENANT_IDP_ROLES CASCADE CONSTRAINTS\n" +
            "/\n" +
            "DROP TABLE UM_TENANT_IDP CASCADE CONSTRAINTS\n" +
            "/\n" +
            "DROP TABLE IDP_BASE_TABLE CASCADE CONSTRAINTS\n" +
            "/\n" +
            "*/\n" +
            "ALTER TABLE AM_API_URL_MAPPING ADD (MEDIATION_SCRIPT BLOB DEFAULT NULL)\n" +
            "/\n" +
            "CREATE TABLE IDN_OAUTH2_SCOPE (\n" +
            "            SCOPE_ID INTEGER,\n" +
            "            SCOPE_KEY VARCHAR2 (100) NOT NULL,\n" +
            "            NAME VARCHAR2 (255) NULL,\n" +
            "            DESCRIPTION VARCHAR2 (512) NULL,\n" +
            "            TENANT_ID INTEGER DEFAULT 0 NOT NULL,\n" +
            "\t    ROLES VARCHAR2 (500) NULL,\n" +
            "            PRIMARY KEY (SCOPE_ID))\n" +
            "/\n" +
            "CREATE SEQUENCE IDN_OAUTH2_SCOPE_SEQUENCE START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER IDN_OAUTH2_SCOPE_TRIGGER\n" +
            "\t\t    BEFORE INSERT\n" +
            "            ON IDN_OAUTH2_SCOPE\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "            BEGIN\n" +
            "                SELECT IDN_OAUTH2_SCOPE_SEQUENCE.nextval INTO :NEW.SCOPE_ID FROM dual;\n" +
            "            END;\n" +
            "/\n" +
            "CREATE TABLE IDN_OAUTH2_RESOURCE_SCOPE (\n" +
            "            RESOURCE_PATH VARCHAR2 (255) NOT NULL,\n" +
            "            SCOPE_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (RESOURCE_PATH),\n" +
            "            FOREIGN KEY (SCOPE_ID) REFERENCES IDN_OAUTH2_SCOPE (SCOPE_ID) ON DELETE CASCADE\n" +
            ")\n" +
            "/\n" +
            "CREATE TABLE IDN_SCIM_GROUP (\n" +
            "\t    ID INTEGER,\n" +
            "\t    TENANT_ID INTEGER NOT NULL,\n" +
            "\t    ROLE_NAME VARCHAR2(255) NOT NULL,\n" +
            "            ATTR_NAME VARCHAR2(1024) NOT NULL,\n" +
            "\t    ATTR_VALUE VARCHAR2(1024),\n" +
            "            PRIMARY KEY (ID))\n" +
            "/\n" +
            "CREATE SEQUENCE IDN_SCIM_GROUP_SEQUENCE START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER IDN_SCIM_GROUP_TRIGGER\n" +
            "\t\t    BEFORE INSERT\n" +
            "            ON IDN_SCIM_GROUP\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "            BEGIN\n" +
            "                SELECT IDN_SCIM_GROUP_SEQUENCE.nextval INTO :NEW.ID FROM dual;\n" +
            "            END;\n" +
            "/\n" +
            "CREATE TABLE IDN_SCIM_PROVIDER (\n" +
            "            CONSUMER_ID VARCHAR(255) NOT NULL,\n" +
            "            PROVIDER_ID VARCHAR(255) NOT NULL,\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            USER_PASSWORD VARCHAR(255) NOT NULL,\n" +
            "            USER_URL VARCHAR(1024) NOT NULL,\n" +
            "\t    GROUP_URL VARCHAR(1024),\n" +
            "\t    BULK_URL VARCHAR(1024),\n" +
            "            PRIMARY KEY (CONSUMER_ID,PROVIDER_ID))\n" +
            "/\n" +
            "CREATE TABLE IDN_OPENID_REMEMBER_ME (\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            TENANT_ID INTEGER DEFAULT 0,\n" +
            "            COOKIE_VALUE VARCHAR(1024),\n" +
            "            CREATED_TIME TIMESTAMP,\n" +
            "            PRIMARY KEY (USER_NAME, TENANT_ID))\n" +
            "/\n" +
            "CREATE TABLE IDN_OPENID_ASSOCIATIONS (\n" +
            "\t    HANDLE VARCHAR(255) NOT NULL,\n" +
            "            ASSOC_TYPE VARCHAR(255) NOT NULL,\n" +
            "            EXPIRE_IN TIMESTAMP NOT NULL,\n" +
            "            MAC_KEY VARCHAR(255) NOT NULL,\n" +
            "            ASSOC_STORE VARCHAR(128) DEFAULT 'SHARED',\n" +
            "            PRIMARY KEY (HANDLE))\n" +
            "/\n" +
            "CREATE TABLE IDN_STS_STORE (\n" +
            "            ID INTEGER,\n" +
            "            TOKEN_ID VARCHAR(255) NOT NULL,\n" +
            "            TOKEN_CONTENT BLOB NOT NULL,\n" +
            "            CREATE_DATE TIMESTAMP NOT NULL,\n" +
            "            EXPIRE_DATE TIMESTAMP NOT NULL,\n" +
            "            STATE INTEGER DEFAULT 0,\n" +
            "            PRIMARY KEY (ID))\n" +
            "/\n" +
            "CREATE SEQUENCE IDN_STS_STORE_SEQUENCE START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER IDN_STS_STORE_TRIGGER\n" +
            "\t\t    BEFORE INSERT\n" +
            "            ON IDN_STS_STORE\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "            BEGIN\n" +
            "                SELECT IDN_STS_STORE_SEQUENCE.nextval INTO :NEW.ID FROM dual;\n" +
            "            END;\n" +
            "/\n" +
            "CREATE TABLE IDN_IDENTITY_USER_DATA (\n" +
            "            TENANT_ID INTEGER DEFAULT -1234,\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            DATA_KEY VARCHAR(255) NOT NULL,\n" +
            "            DATA_VALUE VARCHAR(255) NOT NULL,\n" +
            "            PRIMARY KEY (TENANT_ID, USER_NAME, DATA_KEY))\n" +
            "/\n" +
            "CREATE TABLE IDN_IDENTITY_META_DATA (\n" +
            "            USER_NAME VARCHAR(255) NOT NULL,\n" +
            "            TENANT_ID INTEGER DEFAULT -1234,\n" +
            "            METADATA_TYPE VARCHAR(255) NOT NULL,\n" +
            "            METADATA VARCHAR(255) NOT NULL,\n" +
            "            VALID VARCHAR(255) NOT NULL,\n" +
            "            PRIMARY KEY (TENANT_ID, USER_NAME, METADATA_TYPE,METADATA))\n" +
            "/\n" +
            "-- End of IDN Tables --\n" +
            "\n" +
            "\n" +
            "-- Start of IDN-APPLICATION-MGT Tables--\n" +
            "\n" +
            "CREATE TABLE SP_APP (\n" +
            "            ID INTEGER,\n" +
            "            TENANT_ID INTEGER NOT NULL,\n" +
            "\t    APP_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    USER_STORE VARCHAR (255) NOT NULL,\n" +
            "            USERNAME VARCHAR (255) NOT NULL ,\n" +
            "            DESCRIPTION VARCHAR (1024),\n" +
            "\t    ROLE_CLAIM VARCHAR (512),\n" +
            "            AUTH_TYPE VARCHAR (255) NOT NULL,\n" +
            "\t    PROVISIONING_USERSTORE_DOMAIN VARCHAR (512),\n" +
            "\t    IS_LOCAL_CLAIM_DIALECT CHAR(1) DEFAULT '1',\n" +
            "            IS_SEND_LOCAL_SUBJECT_ID CHAR(1) DEFAULT '0',\n" +
            "            IS_SEND_AUTH_LIST_OF_IDPS CHAR(1) DEFAULT '0',\n" +
            "            SUBJECT_CLAIM_URI VARCHAR (512),\n" +
            "            IS_SAAS_APP CHAR(1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID))\n" +
            "/\n" +
            "CREATE SEQUENCE SP_APP_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER SP_APP_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON SP_APP\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT SP_APP_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "CREATE UNIQUE INDEX APPLICATION_NAME_CONSTRAINT ON SP_APP(APP_NAME, TENANT_ID)\n" +
            "/\n" +
            "ALTER TABLE SP_APP ADD CONSTRAINT APPLICATION_NAME_CONSTRAINT UNIQUE (APP_NAME, TENANT_ID) USING INDEX APPLICATION_NAME_CONSTRAINT\n" +
            "/\n" +
            "CREATE TABLE SP_INBOUND_AUTH (\n" +
            "            ID INTEGER,\n" +
            "\t    TENANT_ID INTEGER NOT NULL,\n" +
            "\t    INBOUND_AUTH_KEY VARCHAR (255) NOT NULL,\n" +
            "            INBOUND_AUTH_TYPE VARCHAR (255) NOT NULL,\n" +
            "            PROP_NAME VARCHAR (255),\n" +
            "            PROP_VALUE VARCHAR (1024) ,\n" +
            "\t    APP_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID))\n" +
            "/\n" +
            "CREATE SEQUENCE SP_INBOUND_AUTH_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER SP_INBOUND_AUTH_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON SP_INBOUND_AUTH\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT SP_INBOUND_AUTH_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "ALTER TABLE SP_INBOUND_AUTH ADD CONSTRAINT APPLICATION_ID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE\n" +
            "/\n" +
            "CREATE TABLE SP_AUTH_STEP (\n" +
            "            ID INTEGER,\n" +
            "            TENANT_ID INTEGER NOT NULL,\n" +
            "\t    STEP_ORDER INTEGER DEFAULT 1,\n" +
            "            APP_ID INTEGER NOT NULL ,\n" +
            "            IS_SUBJECT_STEP CHAR(1) DEFAULT '0',\n" +
            "            IS_ATTRIBUTE_STEP CHAR(1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID))\n" +
            "/\n" +
            "CREATE SEQUENCE SP_AUTH_STEP_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER SP_AUTH_STEP_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON SP_AUTH_STEP\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT SP_AUTH_STEP_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "ALTER TABLE SP_AUTH_STEP ADD CONSTRAINT APPLICATION_ID_CONSTRAINT_STEP FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE\n" +
            "/\n" +
            "CREATE TABLE SP_FEDERATED_IDP (\n" +
            "            ID INTEGER NOT NULL,\n" +
            "            TENANT_ID INTEGER NOT NULL,\n" +
            "            AUTHENTICATOR_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID, AUTHENTICATOR_ID))\n" +
            "/\n" +
            "ALTER TABLE SP_FEDERATED_IDP ADD CONSTRAINT STEP_ID_CONSTRAINT FOREIGN KEY (ID) REFERENCES SP_AUTH_STEP (ID) ON DELETE CASCADE\n" +
            "/\n" +
            "CREATE TABLE SP_CLAIM_MAPPING (\n" +
            "\t    ID INTEGER,\n" +
            "\t    TENANT_ID INTEGER NOT NULL,\n" +
            "\t    IDP_CLAIM VARCHAR (512) NOT NULL ,\n" +
            "            SP_CLAIM VARCHAR (512) NOT NULL ,\n" +
            "\t    APP_ID INTEGER NOT NULL,\n" +
            "\t    IS_REQUESTED VARCHAR(128) DEFAULT '0',\n" +
            "            DEFAULT_VALUE VARCHAR(255),\n" +
            "            PRIMARY KEY (ID))\n" +
            "/\n" +
            "CREATE SEQUENCE SP_CLAIM_MAPPING_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER SP_CLAIM_MAPPING_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON SP_CLAIM_MAPPING\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT SP_CLAIM_MAPPING_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "ALTER TABLE SP_CLAIM_MAPPING ADD CONSTRAINT CLAIMID_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE\n" +
            "/\n" +
            "CREATE TABLE SP_ROLE_MAPPING (\n" +
            "\t    ID INTEGER,\n" +
            "\t    TENANT_ID INTEGER NOT NULL,\n" +
            "\t    IDP_ROLE VARCHAR (255) NOT NULL ,\n" +
            "            SP_ROLE VARCHAR (255) NOT NULL ,\n" +
            "\t    APP_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID))\n" +
            "/\n" +
            "CREATE SEQUENCE SP_ROLE_MAPPING_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER SP_ROLE_MAPPING_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON SP_ROLE_MAPPING\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT SP_ROLE_MAPPING_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "ALTER TABLE SP_ROLE_MAPPING ADD CONSTRAINT ROLEID_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE\n" +
            "/\n" +
            "CREATE TABLE SP_REQ_PATH_AUTHENTICATOR (\n" +
            "\t    ID INTEGER,\n" +
            "\t    TENANT_ID INTEGER NOT NULL,\n" +
            "\t    AUTHENTICATOR_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    APP_ID INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (ID))\n" +
            "/\n" +
            "CREATE SEQUENCE SP_REQ_PATH_AUTH_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER SP_REQ_PATH_AUTH_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON SP_REQ_PATH_AUTHENTICATOR\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT SP_REQ_PATH_AUTH_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "ALTER TABLE SP_REQ_PATH_AUTHENTICATOR ADD CONSTRAINT REQ_AUTH_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE\n" +
            "/\n" +
            "CREATE TABLE SP_PROVISIONING_CONNECTOR (\n" +
            "\t    ID INTEGER,\n" +
            "\t    TENANT_ID INTEGER NOT NULL,\n" +
            "            IDP_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    CONNECTOR_NAME VARCHAR (255) NOT NULL ,\n" +
            "\t    APP_ID INTEGER NOT NULL,\n" +
            "\t    IS_JIT_ENABLED CHAR(1) DEFAULT '0',\n" +
            "            BLOCKING CHAR(1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID))\n" +
            "/\n" +
            "CREATE SEQUENCE SP_PROV_CONNECTOR_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER SP_PROV_CONNECTOR_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON SP_PROVISIONING_CONNECTOR\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT SP_PROV_CONNECTOR_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "ALTER TABLE SP_PROVISIONING_CONNECTOR ADD CONSTRAINT PRO_CONNECTOR_APPID_CONSTRAINT FOREIGN KEY (APP_ID) REFERENCES SP_APP (ID) ON DELETE CASCADE\n" +
            "/\n" +
            "CREATE TABLE IDP (\n" +
            "            ID INTEGER,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            NAME VARCHAR(254) NOT NULL,\n" +
            "            IS_ENABLED CHAR(1) DEFAULT '1',\n" +
            "            IS_PRIMARY CHAR(1) DEFAULT '0',\n" +
            "            HOME_REALM_ID VARCHAR(254),\n" +
            "            IMAGE BLOB,\n" +
            "            CERTIFICATE BLOB,\n" +
            "            ALIAS VARCHAR(254),\n" +
            "            INBOUND_PROV_ENABLED CHAR (1) DEFAULT '0',\n" +
            "            INBOUND_PROV_USER_STORE_ID VARCHAR(254),\n" +
            "            USER_CLAIM_URI VARCHAR(254),\n" +
            "            ROLE_CLAIM_URI VARCHAR(254),\n" +
            "            DESCRIPTION VARCHAR (1024),\n" +
            "            DEFAULT_AUTHENTICATOR_NAME VARCHAR(254),\n" +
            "            DEFAULT_PRO_CONNECTOR_NAME VARCHAR(254),\n" +
            "            PROVISIONING_ROLE VARCHAR(128),\n" +
            "            IS_FEDERATION_HUB CHAR(1) DEFAULT '0',\n" +
            "            IS_LOCAL_CLAIM_DIALECT CHAR(1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            DISPLAY_NAME VARCHAR(254),\n" +
            "            UNIQUE (TENANT_ID, NAME))\n" +
            "/\n" +
            "CREATE SEQUENCE IDP_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER IDP_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON IDP\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT IDP_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "INSERT INTO IDP (TENANT_ID, NAME, HOME_REALM_ID) VALUES (-1234, 'LOCAL', 'localhost')\n" +
            "/\n" +
            "CREATE TABLE IDP_ROLE (\n" +
            "            ID INTEGER,\n" +
            "            IDP_ID INTEGER,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            ROLE VARCHAR(254),\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (IDP_ID, ROLE),\n" +
            "            FOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE)\n" +
            "/\n" +
            "CREATE SEQUENCE IDP_ROLE_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER IDP_ROLE_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON IDP_ROLE\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT IDP_ROLE_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "CREATE TABLE IDP_ROLE_MAPPING (\n" +
            "            ID INTEGER,\n" +
            "            IDP_ROLE_ID INTEGER,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            USER_STORE_ID VARCHAR (253),\n" +
            "            LOCAL_ROLE VARCHAR(253),\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (IDP_ROLE_ID, TENANT_ID, USER_STORE_ID, LOCAL_ROLE),\n" +
            "            FOREIGN KEY (IDP_ROLE_ID) REFERENCES IDP_ROLE(ID) ON DELETE CASCADE)\n" +
            "/\n" +
            "CREATE SEQUENCE IDP_ROLE_MAPPING_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER IDP_ROLE_MAPPING_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON IDP_ROLE_MAPPING\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT IDP_ROLE_MAPPING_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "CREATE TABLE IDP_CLAIM (\n" +
            "            ID INTEGER,\n" +
            "            IDP_ID INTEGER,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            CLAIM VARCHAR(254),\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (IDP_ID, CLAIM),\n" +
            "            FOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE)\n" +
            "/\n" +
            "CREATE TABLE IDP_CLAIM_MAPPING (\n" +
            "            ID INTEGER,\n" +
            "            IDP_CLAIM_ID INTEGER,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            LOCAL_CLAIM VARCHAR(253),\n" +
            "            DEFAULT_VALUE VARCHAR(255),\n" +
            "            IS_REQUESTED VARCHAR(128) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (IDP_CLAIM_ID, TENANT_ID, LOCAL_CLAIM),\n" +
            "            FOREIGN KEY (IDP_CLAIM_ID) REFERENCES IDP_CLAIM(ID) ON DELETE CASCADE)\n" +
            "/\n" +
            "CREATE SEQUENCE IDP_CLAIM_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER IDP_CLAIM_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON IDP_CLAIM\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT IDP_CLAIM_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "CREATE SEQUENCE IDP_CLAIM_MAPPING_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER IDP_CLAIM_MAPPING_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON IDP_CLAIM_MAPPING\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT IDP_CLAIM_MAPPING_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "CREATE TABLE IDP_AUTHENTICATOR (\n" +
            "            ID INTEGER,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            IDP_ID INTEGER,\n" +
            "            NAME VARCHAR(255) NOT NULL,\n" +
            "            IS_ENABLED CHAR (1) DEFAULT '1',\n" +
            "            DISPLAY_NAME VARCHAR(255),\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, IDP_ID, NAME),\n" +
            "            FOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE)\n" +
            "/\n" +
            "CREATE SEQUENCE IDP_AUTHENTICATOR_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER IDP_AUTHENTICATOR_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON IDP_AUTHENTICATOR\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT IDP_AUTHENTICATOR_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "INSERT INTO IDP_AUTHENTICATOR (TENANT_ID, IDP_ID, NAME) VALUES (-1234, 1, 'saml2sso')\n" +
            "/\n" +
            "CREATE TABLE IDP_AUTHENTICATOR_PROPERTY (\n" +
            "            ID INTEGER,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            AUTHENTICATOR_ID INTEGER,\n" +
            "            PROPERTY_KEY VARCHAR(255) NOT NULL,\n" +
            "            PROPERTY_VALUE VARCHAR(2047),\n" +
            "            IS_SECRET CHAR (1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, AUTHENTICATOR_ID, PROPERTY_KEY),\n" +
            "            FOREIGN KEY (AUTHENTICATOR_ID) REFERENCES IDP_AUTHENTICATOR(ID) ON DELETE CASCADE)\n" +
            "/\n" +
            "CREATE SEQUENCE IDP_AUTHENTICATOR_PROP_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER IDP_AUTHENTICATOR_PROP_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON IDP_AUTHENTICATOR_PROPERTY\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT IDP_AUTHENTICATOR_PROP_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "CREATE TABLE IDP_PROVISIONING_CONFIG (\n" +
            "            ID INTEGER,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            IDP_ID INTEGER,\n" +
            "            PROVISIONING_CONNECTOR_TYPE VARCHAR(255) NOT NULL,\n" +
            "            IS_ENABLED CHAR (1) DEFAULT '0',\n" +
            "            IS_BLOCKING CHAR (1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, IDP_ID, PROVISIONING_CONNECTOR_TYPE),\n" +
            "            FOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE)\n" +
            "/\n" +
            "CREATE SEQUENCE IDP_PROVISIONING_CONFIG_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER IDP_PROVISIONING_CONFIG_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON IDP_PROVISIONING_CONFIG\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT IDP_PROVISIONING_CONFIG_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "CREATE TABLE IDP_PROV_CONFIG_PROPERTY (\n" +
            "            ID INTEGER,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            PROVISIONING_CONFIG_ID INTEGER,\n" +
            "            PROPERTY_KEY VARCHAR(255) NOT NULL,\n" +
            "            PROPERTY_VALUE VARCHAR(2048),\n" +
            "            PROPERTY_BLOB_VALUE BLOB,\n" +
            "            PROPERTY_TYPE CHAR(32) NOT NULL,\n" +
            "            IS_SECRET CHAR (1) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, PROVISIONING_CONFIG_ID, PROPERTY_KEY),\n" +
            "            FOREIGN KEY (PROVISIONING_CONFIG_ID) REFERENCES IDP_PROVISIONING_CONFIG(ID) ON DELETE CASCADE)\n" +
            "/\n" +
            "CREATE SEQUENCE IDP_PROV_CONFIG_PROP_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER IDP_PROV_CONFIG_PROP_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON IDP_PROV_CONFIG_PROPERTY\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT IDP_PROV_CONFIG_PROP_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "CREATE TABLE IDP_PROVISIONING_ENTITY (\n" +
            "            ID INTEGER,\n" +
            "            PROVISIONING_CONFIG_ID INTEGER,\n" +
            "            ENTITY_TYPE VARCHAR(255) NOT NULL,\n" +
            "            ENTITY_LOCAL_USERSTORE VARCHAR(255) NOT NULL,\n" +
            "            ENTITY_NAME VARCHAR(255) NOT NULL,\n" +
            "            ENTITY_VALUE VARCHAR(255),\n" +
            "            TENANT_ID INTEGER,\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (ENTITY_TYPE, TENANT_ID, ENTITY_LOCAL_USERSTORE, ENTITY_NAME),\n" +
            "            UNIQUE (PROVISIONING_CONFIG_ID, ENTITY_TYPE, ENTITY_VALUE),\n" +
            "            FOREIGN KEY (PROVISIONING_CONFIG_ID) REFERENCES IDP_PROVISIONING_CONFIG(ID) ON DELETE CASCADE)\n" +
            "/\n" +
            "CREATE SEQUENCE IDP_PROV_ENTITY_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER IDP_PROV_ENTITY_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON IDP_PROVISIONING_ENTITY\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT IDP_PROV_ENTITY_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "CREATE TABLE IDP_LOCAL_CLAIM (\n" +
            "            ID INTEGER,\n" +
            "            TENANT_ID INTEGER,\n" +
            "            IDP_ID INTEGER,\n" +
            "            CLAIM_URI VARCHAR(255) NOT NULL,\n" +
            "            DEFAULT_VALUE VARCHAR(255),\n" +
            "            IS_REQUESTED VARCHAR(128) DEFAULT '0',\n" +
            "            PRIMARY KEY (ID),\n" +
            "            UNIQUE (TENANT_ID, IDP_ID, CLAIM_URI),\n" +
            "            FOREIGN KEY (IDP_ID) REFERENCES IDP(ID) ON DELETE CASCADE)\n" +
            "/\n" +
            "CREATE SEQUENCE IDP_LOCAL_CLAIM_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER IDP_LOCAL_CLAIM_TRIG\n" +
            "            BEFORE INSERT\n" +
            "            ON IDP_LOCAL_CLAIM\n" +
            "            REFERENCING NEW AS NEW\n" +
            "            FOR EACH ROW\n" +
            "               BEGIN\n" +
            "                   SELECT IDP_LOCAL_CLAIM_SEQ.nextval INTO :NEW.ID FROM dual;\n" +
            "               END;\n" +
            "/\n" +
            "\n" +
            "-- End of IDN-APPLICATION-MGT Tables--\n" +
            "\n" +
            "ALTER TABLE AM_APPLICATION_KEY_MAPPING DROP PRIMARY KEY CASCADE\n" +
            "/\n" +
            "ALTER TABLE AM_APPLICATION_KEY_MAPPING ADD (STATE  VARCHAR2(30 BYTE) DEFAULT 'COMPLETED' NOT NULL)\n" +
            "/\n" +
            "ALTER TABLE AM_APPLICATION_KEY_MAPPING ADD PRIMARY KEY (APPLICATION_ID, KEY_TYPE)\n" +
            "/\n" +
            "CREATE TABLE AM_APPLICATION_REGISTRATION (\n" +
            "            REG_ID INTEGER ,\n" +
            "            SUBSCRIBER_ID INTEGER,\n" +
            "            WF_REF VARCHAR2(255) NOT NULL,\n" +
            "            APP_ID INTEGER,\n" +
            "            TOKEN_TYPE VARCHAR2(30),\n" +
            "            ALLOWED_DOMAINS VARCHAR2(256),\n" +
            "            VALIDITY_PERIOD NUMBER(19),\n" +
            "            UNIQUE (SUBSCRIBER_ID,APP_ID,TOKEN_TYPE),\n" +
            "            FOREIGN KEY(SUBSCRIBER_ID) REFERENCES AM_SUBSCRIBER(SUBSCRIBER_ID),\n" +
            "            FOREIGN KEY(APP_ID) REFERENCES AM_APPLICATION(APPLICATION_ID),\n" +
            "            PRIMARY KEY (REG_ID)\n" +
            ")\n" +
            "/\n" +
            "CREATE SEQUENCE AM_APP_REGISTRATION_SEQUENCE START WITH 1 INCREMENT BY 1\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER AM_APP_REGISTRATION_TRIGGER\n" +
            "      BEFORE INSERT\n" +
            "  ON AM_APPLICATION_REGISTRATION\n" +
            "  REFERENCING NEW AS NEW\n" +
            "  FOR EACH ROW\n" +
            "BEGIN\n" +
            "  SELECT AM_APP_REGISTRATION_SEQUENCE.nextval INTO :NEW.REG_ID FROM dual;\n" +
            "  END;\n" +
            "/\n" +
            "CREATE TABLE AM_API_SCOPES (\n" +
            "            API_ID  INTEGER NOT NULL,\n" +
            "            SCOPE_ID  INTEGER NOT NULL,\n" +
            "            FOREIGN KEY (API_ID) REFERENCES AM_API (API_ID) ON DELETE CASCADE,\n" +
            "            FOREIGN KEY (SCOPE_ID) REFERENCES IDN_OAUTH2_SCOPE (SCOPE_ID) ON DELETE CASCADE\n" +
            ")\n" +
            "/\n" +
            "CREATE TABLE AM_API_DEFAULT_VERSION (\n" +
            "            DEFAULT_VERSION_ID NUMBER, \n" +
            "            API_NAME VARCHAR(256) NOT NULL ,\n" +
            "            API_PROVIDER VARCHAR(256) NOT NULL , \n" +
            "            DEFAULT_API_VERSION VARCHAR(30) , \n" +
            "            PUBLISHED_DEFAULT_API_VERSION VARCHAR(30) ,\n" +
            "            PRIMARY KEY (DEFAULT_VERSION_ID)\n" +
            ")\n" +
            "/\n" +
            "CREATE SEQUENCE AM_API_DEFAULT_VERSION_SEQ START WITH 1 INCREMENT BY 1 NOCACHE\n" +
            "/\n" +
            "CREATE OR REPLACE TRIGGER AM_API_DEFAULT_VERSION_TRG\n" +
            "                    BEFORE INSERT\n" +
            "                    ON AM_API_DEFAULT_VERSION\n" +
            "                    REFERENCING NEW AS NEW\n" +
            "                    FOR EACH ROW\n" +
            "                    BEGIN\n" +
            "                    SELECT AM_API_DEFAULT_VERSION_SEQ.nextval INTO :NEW.DEFAULT_VERSION_ID FROM dual;\n" +
            "                    END;\n" +
            "/\n" +
            "CREATE OR REPLACE FUNCTION DROP_ALL_SCHEMA_OBJECTS RETURN NUMBER AS\n" +
            "PRAGMA AUTONOMOUS_TRANSACTION;\n" +
            "cursor c_get_objects is\n" +
            "  select object_type,'\"'||object_name||'\"'||decode(object_type,'TABLE' ,' cascade constraints',null) obj_name\n" +
            "  from user_objects\n" +
            "  where object_type in ('TABLE','VIEW','PACKAGE','SEQUENCE','SYNONYM', 'MATERIALIZED VIEW')\n" +
            "  order by object_type;\n" +
            "cursor c_get_objects_type is\n" +
            "  select object_type, '\"'||object_name||'\"' obj_name\n" +
            "  from user_objects\n" +
            "  where object_type in ('TYPE');\n" +
            "BEGIN\n" +
            "  begin\n" +
            "  for object_rec in c_get_objects loop\n" +
            "  execute immediate ('drop '||object_rec.object_type||' ' ||object_rec.obj_name);\n" +
            "  end loop;\n" +
            "  for object_rec in c_get_objects_type loop\n" +
            "  begin\n" +
            "  execute immediate ('drop '||object_rec.object_type||' ' ||object_rec.obj_name);\n" +
            "  end;\n" +
            "  end loop;\n" +
            "  end;\n" +
            "  RETURN 0;\n" +
            "END DROP_ALL_SCHEMA_OBJECTS;\n" +
            "/\n" +
            "ALTER TABLE IDN_OAUTH2_ACCESS_TOKEN MODIFY(TOKEN_SCOPE VARCHAR2(2048 BYTE))\n" +
            "/\n" +
            "DECLARE \n" +
            "statement VARCHAR2(2000);\n" +
            "constr_name VARCHAR2(30);\n" +
            "BEGIN\n" +
            "  SELECT CONSTRAINT_NAME INTO constr_name FROM USER_CONS_COLUMNS WHERE table_name  = 'IDN_OAUTH1A_ACCESS_TOKEN' AND column_name = 'CONSUMER_KEY';\n" +
            "   statement := 'ALTER TABLE IDN_OAUTH1A_ACCESS_TOKEN DROP CONSTRAINT '|| constr_name;\n" +
            "   EXECUTE IMMEDIATE(statement); \n" +
            "END;\n" +
            "/\n" +
            "ALTER TABLE IDN_OAUTH1A_ACCESS_TOKEN ADD FOREIGN KEY (CONSUMER_KEY) REFERENCES IDN_OAUTH_CONSUMER_APPS (CONSUMER_KEY) ON DELETE CASCADE\n" +
            "/\n" +
            "DECLARE \n" +
            "statement VARCHAR2(2000);\n" +
            "constr_name VARCHAR2(30);\n" +
            "BEGIN\n" +
            "  SELECT CONSTRAINT_NAME INTO constr_name FROM USER_CONS_COLUMNS WHERE table_name  = 'IDN_OAUTH1A_REQUEST_TOKEN' AND column_name = 'CONSUMER_KEY';\n" +
            "   statement := 'ALTER TABLE IDN_OAUTH1A_REQUEST_TOKEN DROP CONSTRAINT '|| constr_name;\n" +
            "   EXECUTE IMMEDIATE(statement); \n" +
            "END;\n" +
            "/\n" +
            "ALTER TABLE IDN_OAUTH1A_REQUEST_TOKEN ADD FOREIGN KEY (CONSUMER_KEY) REFERENCES IDN_OAUTH_CONSUMER_APPS (CONSUMER_KEY) ON DELETE CASCADE\n" +
            "/\n" +
            "DECLARE \n" +
            "statement VARCHAR2(2000);\n" +
            "constr_name VARCHAR2(30);\n" +
            "BEGIN\n" +
            "  SELECT CONSTRAINT_NAME INTO constr_name FROM USER_CONS_COLUMNS WHERE table_name  = 'IDN_OAUTH2_AUTHORIZATION_CODE' AND column_name = 'CONSUMER_KEY';\n" +
            "   statement := 'ALTER TABLE IDN_OAUTH2_AUTHORIZATION_CODE DROP CONSTRAINT '|| constr_name;\n" +
            "   EXECUTE IMMEDIATE(statement); \n" +
            "END;\n" +
            "/\n" +
            "ALTER TABLE IDN_OAUTH2_AUTHORIZATION_CODE ADD FOREIGN KEY (CONSUMER_KEY) REFERENCES IDN_OAUTH_CONSUMER_APPS (CONSUMER_KEY) ON DELETE CASCADE\n" +
            "/\n" +
            "\n";


}
