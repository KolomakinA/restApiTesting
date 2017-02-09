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
        prop.setCreatedTCId("");
    }

//    @Test//actually we cannot delete task collections directly - otherwise we get sql constrain violation
//    public void deleteTaskCollection(String tcId) throws IOException {
//        String resURI = "rlc/rest/v2/taskcollections/" + tcId;
//        String url = prop.getRlcURL()+ resURI;
//        Del delete= new Del(url);
//        String response = delete.httpDel();
//        System.out.println(response);
//    }

    @Test //Get list of task collections
    public String getTaskCollections() throws  IOException{
        String resURI = "rlc/rest/v2/taskcollections/";
        String url = prop.getRlcURL()+ resURI;
        Get httpGet = new Get(url);
        return httpGet.httpGet();
    }

    @Test//get particular task collection
    public String getTaskCollections(String tcid) throws  IOException {
        String resURI = "rlc/rest/v2/taskcollections/" + tcid;
        String url = prop.getRlcURL() + resURI;
        Get httpGet = new Get(url);
        return httpGet.httpGet();
    }

    @Test//Create task collection with a specified name
    public String postTaskCollection(String tc_name) throws IOException{// String env_id, String env_name
        Utils utils = new Utils();
        String file = utils.readFile("resources\\jsonTemplates\\postTaskCollection.json");//read a json template
        file = file.replace("%TC_NAME%", tc_name);

        String resURI = "rlc/rest/v2/taskcollections/";//making an URL
        String url = prop.getRlcURL()+ resURI;

        Post httpPost = new Post(url,file);//executing POST
        String postResult = httpPost.httpPost();
        //System.out.println(postResult);

       JSONObject jso = new JSONObject(postResult);
       //System.out.println(jso.toString());

        //System.out.println("id_" + (jso.getJSONObject("localReturn")).get("id"));
        prop.setCreatedTCId(jso.getJSONObject("localReturn").get("id").toString());
        return jso.getJSONObject("localReturn").get("id").toString();

    }

    @org.junit.Test
    public void createTaskForATC(){
        String resURI = "rlc/rest/v2/taskcollections/" + prop.getCreatedTCId() + "/tasks";//making an URL
        String url = prop.getRlcURL()+ resURI;


    }
}

