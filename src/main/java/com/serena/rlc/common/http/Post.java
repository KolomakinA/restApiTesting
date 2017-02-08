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
 * Created by akolomakin on 31.01.2017.
 */
public class Post {
//    private final String USER_AGENT = "Mozilla/5.0";
//    public HttpResponse httpPost(String url) throws IOException {
//
//        HttpClient client = HttpClientBuilder.create().build();
//        HttpPost post = new HttpPost(url);
//
//        // add header
//        post.setHeader("User-Agent", USER_AGENT);
//
//        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//        urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
//        urlParameters.add(new BasicNameValuePair("cn", ""));
//        urlParameters.add(new BasicNameValuePair("locale", ""));
//        urlParameters.add(new BasicNameValuePair("caller", ""));
//        urlParameters.add(new BasicNameValuePair("num", "12345"));
//
//        post.setEntity(new UrlEncodedFormEntity(urlParameters));
//
//        HttpResponse response = client.execute(post);
//        System.out.println("Response Code : "
//                + response.getStatusLine().getStatusCode());
//
//        BufferedReader rd = new BufferedReader(
//                new InputStreamReader(response.getEntity().getContent()));
//
//        StringBuffer result = new StringBuffer();
//        String line = "";
//        while ((line = rd.readLine()) != null) {
//            result.append(line);
//        }
//        return response;
//    }
    public String httpPost(String url, ConfigurationProperties confPropObject, String jsonBody) throws IOException {
        return Request.Post(url).addHeader("Authorization", "Basic YWRtaW46").addHeader("Content-Type","application/json").
                bodyString(jsonBody, APPLICATION_JSON).execute().returnContent().toString();
    }
}
