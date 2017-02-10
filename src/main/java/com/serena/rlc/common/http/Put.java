package com.serena.rlc.common.http;

import com.serena.rlc.common.ConfigurationProperties;
import com.serena.rlc.common.Utils;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

/**
 * Created by akolomakin and olazarenko on 07.02.2017.
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
        Utils utils = new Utils();
        String creds = utils.base64Encode(confPropObject.getSbmUserName());
        if(utils.base64Encode(confPropObject.getSbmUserPass()) != null){
            creds=creds+utils.base64Encode(confPropObject.getSbmUserPass());
        }

        try {
            return Request.Put(url).addHeader("Authorization", "Basic "+creds).addHeader("Content-Type","application/json").
                    bodyString(jsonBody, APPLICATION_JSON).execute().returnContent().toString();
        }
        catch (org.apache.http.client.HttpResponseException e){
            return "Http code " + e.getStatusCode() + " : " + e.getMessage();
        }
    }
}
