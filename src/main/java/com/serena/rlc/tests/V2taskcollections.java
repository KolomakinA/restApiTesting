package com.serena.rlc.tests;

import com.serena.rlc.common.ConfigurationProperties;
import com.serena.rlc.common.Utils;
import com.serena.rlc.common.http.Del;
import com.serena.rlc.common.http.Get;
import com.serena.rlc.common.http.Post;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
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
    public String getTaskCollections() throws  IOException{
        String resURI = "rlc/rest/v2/taskcollections/";
        String url = prop.getRlcURL()+ resURI;
        Get httpGet = new Get(url);
        return httpGet.httpGet();
        //JSONObject js = new JSONObject(response);;
//        if (js.getJSONArray("localReturn").length() == 0){
//            System.out.println("RLC does not have any task collections created");
//        }
//        else{
//            JSONArray jsa = new JSONArray(js.getJSONArray("localReturn"));
//            return jsa;
//        }
        //return response;
    }

    @Test
    public String postTaskCollection(String tc_name) throws IOException{// String env_id, String env_name
        Utils utils = new Utils();
        String file = utils.readFile("resources\\jsonTemplates\\postTaskCollection.json");//read a json template
        file = file.replace("%TC_NAME%", tc_name);

        String resURI = "rlc/rest/v2/taskcollections/";//making an URL
        String url = prop.getRlcURL()+ resURI;

        Post httpPost = new Post(url,file);//executing POST

        JSONObject jso = new JSONObject(file);
        JSONObject jsoC = new JSONObject(jso.getJSONObject("localReturn"));
        if (jsoC.get("id") == null){
            System.out.println("null");
        }
        else System.out.println(jsoC.get("id"));

        return httpPost.httpPost();
    }
}

