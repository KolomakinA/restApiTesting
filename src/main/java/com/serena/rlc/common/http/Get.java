package com.serena.rlc.common.http;

import com.serena.rlc.common.ConfigurationProperties;
import com.serena.rlc.common.Utils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by akolomakin on 30.01.2017.
 */
public class Get {
    private final String USER_AGENT = "Mozilla/5.0";
    //ConfigurationProperties cp = new ConfigurationProperties();
    Utils utils = new Utils();

    public StringBuffer httpGet(String url, ConfigurationProperties cp) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("User-Agent", USER_AGENT);
        request.addHeader("Authorization", "Basic YWRtaW46");//utils.base64Encode(cp.getSbmUserName())+utils.base64Encode(cp.getSbmUserPass()));//"Basic YWRtaW46");//
        HttpResponse response = client.execute(request);

        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result;
    }
}
