package com.serena.rlc.common.http;

import com.serena.rlc.common.ConfigurationProperties;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

/**
 * Created by akolomakin on 08.02.2017.
 */
public class Put {
    public String httpPut(String url, ConfigurationProperties confPropObject, String jsonBody) throws IOException {
        return Request.Put(url).addHeader("Authorization", "Basic YWRtaW46").addHeader("Content-Type","application/json").
                bodyString(jsonBody, APPLICATION_JSON).execute().returnContent().toString();
    }
}
