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

    public String findProviders () throws IOException {//only execution providers are returned somehow
        String resURI = "rlc/rest/execution/findProviders";
        String url = prop.getRlcURL() + resURI;
        Get getResource = new Get(url, prop);
        String response = getResource.httpGet();
        return response;
    }
}
