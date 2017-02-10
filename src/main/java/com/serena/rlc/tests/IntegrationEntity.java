package com.serena.rlc.tests;

import com.serena.rlc.common.ConfigurationProperties;
import com.serena.rlc.common.http.Get;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by akolomakin on 10.02.2017.
 */
public class IntegrationEntity {
    ConfigurationProperties prop;

    public IntegrationEntity() {
        this.prop = new ConfigurationProperties();
        prop.setRlcURL("http://stl-qa-oalmt3/");
        prop.setSbmUserName("admin");
        prop.setSbmUserPass("");
    }

    public String findDUProvidersAndreturnUUID (String mockProviderName) throws IOException {
        String resURI = "rlc/rest/integrationEntity/findProviders?tags=deployment_unit";
        String url = prop.getRlcURL() + resURI;
        Get getResource = new Get(url, prop);
        String response = getResource.httpGet();

        JSONObject duProviderList = new JSONObject(response);//Getting full list of installed plugins
        JSONArray array = duProviderList.getJSONArray("localReturn");//getting a local return
        String provInstUUID = "";//creating a variable for mock provider instance UUID
        for (int i = 0; i < array.length() ; i++) {
            if (array.getJSONObject(i).get("providerName").equals(mockProviderName)){//finding an array member by its name
                provInstUUID = array.getJSONObject(i).getString("providerUuid");//saving a UUID to the variable
            }
        }
        return provInstUUID;
    }
    public String findRequestProviders () throws IOException {
        String resURI = "rlc/rest/integrationEntity/findProviders?tags=request";
        String url = prop.getRlcURL() + resURI;
        Get getResource = new Get(url, prop);
        String response = getResource.httpGet();
        return response;
    }


}
