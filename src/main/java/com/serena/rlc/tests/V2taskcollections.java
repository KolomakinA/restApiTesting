package com.serena.rlc.tests;

import com.serena.rlc.common.ConfigurationProperties;
import com.serena.rlc.common.http.Del;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by akolomakin on 07.02.2017.
 */
public class V2taskcollections {
    ConfigurationProperties prop;

    public V2taskcollections() {
        this.prop = new ConfigurationProperties();
        prop.setRlcURL("http://stl-qa-oalmt3/");
        prop.setSbmUserName("admin");
        prop.setSbmUserPass("");
    }

    @Test
    public void getTaskCollections () throws IOException {
        String resURI = "rlc/rest/plugin/findPluginIdentifiers";
        String url = prop.getRlcURL()+ resURI; //setting an URL
    }

    @Test
    public void createTaskCollecion () throws  IOException {

    }

    @org.junit.Test
    public void deleteTaskCollection(String tcId) throws IOException {
        String resURI = "rlc/rest/v2/taskcollections/" + tcId;
        String url = prop.getRlcURL()+ resURI;
        Del delete = new Del(url);
    }

}
