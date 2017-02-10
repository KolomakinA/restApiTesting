package com.serena.rlc.common.http;

import com.serena.rlc.common.ConfigurationProperties;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

/**
 * Created by akolomakin and olazarenko on 07.02.2017.
 */
public class Post {
    private String url;
    private ConfigurationProperties confPropObject;
    private String jsonBody;

    public Post(String url, String jsonBody) {
        this.url=url;
        this.jsonBody=jsonBody;
    }

    public Post(String url, String jsonBody, ConfigurationProperties confPropObject) {
        this.url = url;
        this.confPropObject = confPropObject;
        this.jsonBody = jsonBody;
    }

    public String httpPost() throws IOException {
        try {
            return Request.Post(url).addHeader("Authorization", "Basic YWRtaW46").addHeader("Content-Type","application/json").
                    bodyString(jsonBody, APPLICATION_JSON).execute().returnContent().toString();
        }
        catch (org.apache.http.client.HttpResponseException e){
            return "Http code " + e.getStatusCode() + " : " + e.getMessage();
        }
    }
}
