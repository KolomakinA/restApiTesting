package com.serena.rlc.tests;

import com.serena.rlc.common.ConfigurationProperties;
import com.serena.rlc.common.http.Get;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Created by akolomakin and olazarenko on 07.02.2017.
 */
public class Plugin {

    public String findPluginIdentifiers(ConfigurationProperties prop) throws IOException {
        String resURI = "rlc/rest/plugin/findPluginIdentifiers";
        String url = prop.getRlcURL()+ resURI; //setting an URL
        Get getResource = new Get(url, prop);
        String response = getResource.httpGet().toString();
        return response;
    }

    public String findPugins (ConfigurationProperties prop) throws IOException {
        String resURI = "rlc/rest/plugin/findPlugins";
        String url = prop.getRlcURL()+ resURI;
        Get getResource = new Get(url, prop);
        String response = getResource.httpGet();
        return response;

    }
}

