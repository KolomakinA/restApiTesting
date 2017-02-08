package com.serena.rlc.common.http;

import com.serena.rlc.common.ConfigurationProperties;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

/**
 * Created by akolomakin on 08.02.2017.
 */
public class Put {
    private String url;
    private String jsonBody;
    private ConfigurationProperties confPropObject;

    public Put(String url, String jsonBody) {
        this.url = url;
        this.jsonBody = jsonBody;
    }

    public Put(String url, String jsonBody, ConfigurationProperties confPropObject) {
        this.url = url;
        this.jsonBody = jsonBody;
        this.confPropObject = confPropObject;
    }

    public String httpPut() throws IOException {
        return Request.Put(url).addHeader("Authorization", "Basic YWRtaW46").addHeader("Content-Type","application/json").
                bodyString(jsonBody, APPLICATION_JSON).execute().returnContent().toString();
    }
}
