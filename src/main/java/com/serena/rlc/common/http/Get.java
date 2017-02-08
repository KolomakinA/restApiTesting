package com.serena.rlc.common.http;

import com.serena.rlc.common.ConfigurationProperties;
import com.serena.rlc.common.Utils;
import org.apache.http.client.fluent.Request;
import java.io.IOException;

/**
 * Created by akolomakin on 30.01.2017.
 */
public class Get {
    public String httpGet (String url, ConfigurationProperties cp) throws IOException {
        return Request.Get(url).addHeader("Authorization", "Basic YWRtaW46").execute().returnContent().toString();
    }
}
