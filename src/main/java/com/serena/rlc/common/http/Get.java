package com.serena.rlc.common.http;

import com.serena.rlc.common.ConfigurationProperties;
import com.serena.rlc.common.Utils;
import org.apache.http.client.fluent.Request;
import java.io.IOException;

/**
 * Created by akolomakin on 30.01.2017.
 */
public class Get {
    private String url;
    private ConfigurationProperties configPropertiesObject;

    public Get(String url) {
        this.url=url;
    }

    public Get(String url, ConfigurationProperties configPropertiesObject){
        this.url=url;
        this.configPropertiesObject=configPropertiesObject;
    }

    public String httpGet () throws IOException {
        return Request.Get(url).addHeader("Authorization", "Basic YWRtaW46").execute().returnContent().toString();
    }
}
