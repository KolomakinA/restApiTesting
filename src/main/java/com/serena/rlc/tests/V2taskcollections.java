package com.serena.rlc.tests;

import com.serena.rlc.common.ConfigurationProperties;
import com.serena.rlc.common.Utils;
import com.serena.rlc.common.http.Del;
import com.serena.rlc.common.http.Get;
import com.serena.rlc.common.http.Post;
import com.serena.rlc.common.http.Put;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;

import java.io.File;
import java.io.IOException;

/**
 * Created by akolomakin on 07.02.2017.
 */
public class V2taskcollections {
    int nubmerRun;
    ConfigurationProperties prop;

    public V2taskcollections() {
        this.prop = new ConfigurationProperties();
        prop.setRlcURL("http://stl-qa-oalmt3/");
        prop.setSbmUserName("admin");
        prop.setSbmUserPass("");
        prop.setCreatedTCId("");


    }

//actually we cannot delete task collections directly - otherwise we get sql constrain violation
    public void deleteTaskCollection(String tcId) throws IOException {
        String resURI = "rlc/rest/v2/taskcollections/" + tcId;
        String url = prop.getRlcURL()+ resURI;
        Del delete= new Del(url);
        String response = delete.httpDel();
        System.out.println(response);
    }

     //Get list of task collections
//    public String getTaskCollections() throws  IOException{
//        String resURI = "rlc/rest/v2/taskcollections/";
//        String url = prop.getRlcURL()+ resURI;
//        Get httpGet = new Get(url);
//        return httpGet.httpGet();
//
//    }

    //get particular task collection
    public String getTaskCollections(String tcid) throws  IOException {
        String resURI = "rlc/rest/v2/taskcollections/" + tcid;
        String url = prop.getRlcURL() + resURI;
        Get httpGet = new Get(url);
        System.out.println(url + httpGet.httpGet());
        return httpGet.httpGet();

    }


    //Create task collection with a specified name
    public String postTaskCollection(String tc_name) throws IOException{// String env_id, String env_name
        Utils utils = new Utils();
        String file = utils.readFile("resources\\jsonTemplates\\postTaskCollection.json");//read a json template
        file = file.replace("%TC_NAME%", tc_name);//put task collection name in to template

        String resURI = "rlc/rest/v2/taskcollections/";//making an URL
        String url = prop.getRlcURL()+ resURI;

        Post httpPost = new Post(url,file);//executing POST
        String postResult = httpPost.httpPost();

        JSONObject jso = new JSONObject(postResult);
        System.out.println("postTaskCollection" + jso);
        prop.setCreatedTCId(jso.getJSONObject("localReturn").get("id").toString());//updating global variable and returning the task collection ID
        return jso.getJSONObject("localReturn").get("id").toString();

    }

    public String addTasktoTCid(String tcID, String provInstUUID, String taskName) throws IOException {
        String resURI = "rlc/rest/v2/taskcollections/" + tcID + "/tasks";//making an URL
        String url = prop.getRlcURL()+ resURI;

        Utils utils = new Utils();
        String file = utils.readFile("resources\\jsonTemplates\\createTaskForMockProvider.json");//read a json template
        file = file.replace("%Prov_Inst_UUID%", provInstUUID);
        file = file.replace("%Env_ID%", prop.getMockEnvironmentId());
        file = file.replace("%Task_Title%", taskName);
        Post httpPost = new Post(url,file);//executing POST
        String postResult = httpPost.httpPost();
        return postResult;

    }

    public String createRunforTaskClooection(String tcID) throws IOException{
        // POST http://stl-qa-oalmt3/rlc/rest/v2/taskcollections/100089/executions?
        // {"environment": {"environment_id": "1012:1"	}}

        String urlTemp = "rlc/rest/v2/taskcollections/" + tcID + "/executions";
        String url = prop.getRlcURL()+ urlTemp;

        Utils utils = new Utils();

        String prop = "{\"environment\":{\"environment_id\":\"1012:1\"\t}}";
        Post run = new Post(url,prop);
        try {
            String postResult = run.httpPost();
            System.out.println("res" + postResult);

            JSONObject jsonRun = new JSONObject(postResult);

            nubmerRun = Integer.parseInt(jsonRun.getJSONObject("localReturn").get("id").toString());
            System.out.println("nubmerRun "+ nubmerRun);
            return postResult;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public int receiveNumberofTCRUN(){
        return nubmerRun;
    }

    public void srartTCRun(String tcId) throws IOException{
        //PUT: http://stl-qa-oalmt3/rlc/rest/v2/taskcollections/100089/executions/20/start?
        String resURI = "rlc/rest/v2/taskcollections/" + tcId + "/executions/" + nubmerRun +"/start";
        String url = prop.getRlcURL()+ resURI;

        Put srartRun = new Put(url,"");
        srartRun.httpPut();
        System.out.println("START");
            }

    public boolean checkRunExecution(String tcId) throws Exception {
        //http://stl-qa-oalmt3/rlc/rest/v2/taskcollections/100089/executions/20/
        String resURI = "rlc/rest/v2/taskcollections/" + tcId + "/executions/" + nubmerRun;
        String url = prop.getRlcURL()+ resURI;
        Thread.sleep(10000);
        Get statusRun = new Get(url);
        String obStat = statusRun.httpGet();
        System.out.println(url);

        System.out.println(obStat);
        if (obStat.contains("SUCCEED")){
            System.out.println("TC run is Completed");
        } else System.out.println("TC run is RUNING");;

        return true;
    }

}

