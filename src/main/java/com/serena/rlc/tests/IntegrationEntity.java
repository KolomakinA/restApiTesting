package com.serena.rlc.tests;

import com.serena.rlc.common.ConfigurationProperties;
import com.serena.rlc.common.http.Get;

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

    public String findDUProviders () throws IOException {
        String resURI = "rlc/rest/integrationEntity/findProviders?tags=deployment_unit";
        String url = prop.getRlcURL() + resURI;
        Get getResource = new Get(url, prop);
        String response = getResource.httpGet();
        return response;
    }
    public String findRequestProviders () throws IOException {
        String resURI = "rlc/rest/integrationEntity/findProviders?tags=request";
        String url = prop.getRlcURL() + resURI;
        Get getResource = new Get(url, prop);
        String response = getResource.httpGet();
        return response;
    }
}
