package com.serena.rlc.tests;

import com.serena.rlc.common.ConfigurationProperties;
import com.serena.rlc.common.http.Get;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Created by akolomakin on 27.01.2017.
 */
public class Plugin {
    ConfigurationProperties prop;

     public Plugin() {
         this.prop = new ConfigurationProperties();
         prop.setRlcURL("http://stl-qa-oalmt3/");
         prop.setSbmUserName("admin");
         prop.setSbmUserPass("");
     }

    @Test
    public void findPluginIdentifiers() throws IOException {
        String expectedJson = "[{\"name\":\"rlc-provider-sda\",\"version\":\"2.0\",\"displayName\":\"Micro Focus Deployment Automation\",\"description\":\"Plugin for Micro Focus Deployment Automation\",\"info\":\"See <a href=\\\"http://helpstage.serena.com/doc_center/rlc/pluginsathens/rlc_sda_plugin_qref.pdf\\\">Plugin's Quick Reference (from stage, change before releasing!)</a> for details\"},{\"name\":\"rlc-provider-dim\",\"version\":\"2.0\",\"displayName\":\"Dimensions CM\",\"description\":\"Plugin for Dimensions CM systems\",\"info\":\"See <a href=\\\"http://helpstage.serena.com/doc_center/rlc/pluginsathens/rlc_dimcm_plugin_qref.pdf\\\">Plugin's Quick Reference (from stage, change before releasing!)</a> for details\"},{\"name\":\"rlc-provider-sbm\",\"version\":\"2.0\",\"displayName\":\"Micro Focus Solutions Business Manager (SBM)\",\"description\":\"Plugin for Micro Focus Solutions Business Manager (SBM)\",\"info\":\"See <a href=\\\"http://helpstage.serena.com/doc_center/rlc/pluginsathens/rlc_sbm_plugin_qref.pdf\\\">Plugin's Quick Reference (from stage, change before releasing!)</a> for details\"},{\"name\":\"rlc-provider-jenkins\",\"version\":\"2.0\",\"displayName\":\"Jenkins\",\"description\":\"Plugin for Jenkins systems\",\"info\":\"See <a href=\\\"http://helpstage.serena.com/doc_center/rlc/pluginsathens/rlc_jenkins_plugin_qref.pdf\\\">Plugin's Quick Reference (from stage, change before releasing!)</a> for details\"},{\"name\":\"rlc-provider-rally\",\"version\":\"1.0\",\"displayName\":\"CA Agile Central (Rally)\",\"description\":\"Plugin for CA Agile Central (Rally)\",\"info\":\"No info\"},{\"name\":\"rlc-provider-octopus\",\"version\":\"1.0\",\"displayName\":\"Octopus\",\"description\":\"Plugin for Octopus\",\"info\":\"No Info\"},{\"name\":\"rlc-provider-servicenow\",\"version\":\"2.0\",\"displayName\":\"ServiceNow\",\"description\":\"Plugin for ServiceNow\",\"info\":\"See <a href=\\\"http://helpstage.serena.com/doc_center/rlc/pluginsathens/rlc_snow_plugin_qref.pdf\\\">Plugin's Quick Reference (from stage, change before releasing!)</a> for details\"},{\"name\":\"rlc-provider-jira\",\"version\":\"2.0\",\"displayName\":\"Attlassian Jira\",\"description\":\"Plugin for Attlassian Jira\",\"info\":\"See <a href=\\\"http://helpstage.serena.com/doc_center/rlc/pluginsathens/rlc_jira_plugin_qref.pdf\\\">Plugin's Quick Reference (from stage, change before releasing!)</a> for details\"},{\"name\":\"rlc-provider-zmf\",\"version\":\"3.0\",\"displayName\":\"ZMF\",\"description\":\"Plugin for ZMF\",\"info\":\"See <a href=\\\"http://helpstage.serena.com/doc_center/rlc/pluginsathens/rlc_zmf_plugin_qref.pdf\\\">Plugin's Quick Reference (from stage, change before releasing!)</a> for details\"},{\"name\":\"rlc-provider-nolio\",\"version\":\"2.0\",\"displayName\":\"CA Release Automation (Nolio)\",\"description\":\"Plugin for CA Release Automation (Nolio)\",\"info\":\"See <a href=\\\"http://helpstage.serena.com/doc_center/rlc/pluginsathens/rlc_nolio_plugin_qref.pdf\\\">Plugin's Quick Reference (from stage, change before releasing!)</a> for details\"}]";
        String resURI = "rlc/rest/plugin/findPluginIdentifiers";
        String url = prop.getRlcURL()+ resURI; //setting an URL
        Get getResource = new Get();
        String response = getResource.httpGet(url, prop).toString();
        System.out.println(response);
    }

    @Test
    public void findPugins () throws IOException {
        String resURI = "rlc/rest/plugin/findPlugins";
        String url = prop.getRlcURL()+ resURI;
        Get getResource = new Get();
        Object response = getResource.httpGet(url, prop);
        System.out.println(response);
    }

//    public void httpGetTest() {
//
//        new Request.Get("http://targethost/homepage")
//                .execute().returnContent();
//        Request.Post("http://localhost:" + port + "/").bodyForm(
//                Form.form().add("key", "value").add("list", "1").add("list", "2").build()
//        ).execute().returnResponse();
//
//    }
}

