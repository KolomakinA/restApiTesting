package com.serena.rlc.common.http;

import com.serena.rlc.common.ConfigurationProperties;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

/**
 * Created by akolomakin on 08.02.2017.
 */
public class Del {
    public void httpDel(String url, ConfigurationProperties configPropertiesObject) throws IOException {
        Request.Delete(url).addHeader("Authorization", "Basic YWRtaW46").execute();
    }
}
