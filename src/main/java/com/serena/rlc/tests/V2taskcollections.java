package com.serena.rlc.tests;

import com.serena.rlc.common.ConfigurationProperties;
import com.serena.rlc.common.http.Del;
import com.serena.rlc.common.http.Get;
import org.json.JSONArray;
import org.json.JSONObject;
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

//    @Test//actually we cannot delete task collections directly - otherwise we get sql constrain violation
//    public void deleteTaskCollection(String tcId) throws IOException {
//        String resURI = "rlc/rest/v2/taskcollections/" + tcId;
//        String url = prop.getRlcURL()+ resURI;
//        Del delete= new Del(url);
//        String response = delete.httpDel();
//        System.out.println(response);
//    }

    @Test
    public JSONObject getTaskCollections() throws  IOException{
        String resURI = "rlc/rest/v2/taskcollections/";
        String url = prop.getRlcURL()+ resURI;
        Get httpGet = new Get(url);
        String response=httpGet.httpGet();
        JSONObject js = new JSONObject(response);;
//        if (js.getJSONArray("localReturn").length() == 0){
//            System.out.println("RLC does not have any task collections created");
//        }
//        else{
//            JSONArray jsa = new JSONArray(js.getJSONArray("localReturn"));
//            return jsa;
//        }
        return js;
    }
}
