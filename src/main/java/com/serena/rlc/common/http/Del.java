package com.serena.rlc.common.http;

import com.serena.rlc.common.ConfigurationProperties;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

/**
 * Created by akolomakin on 08.02.2017.
 */
public class Del {
    private String url;
    private ConfigurationProperties configPropertiesObject;

    public Del(String url) {
        this.url=url;
    }
    public Del(String url, ConfigurationProperties configPropertiesObject) {
        this.url=url;
        this.configPropertiesObject=configPropertiesObject;
    }

    public void httpDel() throws IOException {
        Request.Delete(url).addHeader("Authorization", "Basic YWRtaW46").execute();
    }
}
