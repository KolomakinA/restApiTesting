package com.serena.rlc.tests;
import com.serena.rlc.common.ConfigurationProperties;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by akolomakin on 27.01.2017.
 */
public class TestRunner {
    public static void main(String args[]) throws Exception{
        Plugin p = new Plugin();
        V2taskcollections rp = new V2taskcollections();

        JSONObject pluginsList = new JSONObject(p.findPugins());//Getting full list of installed plugins
        JSONArray array = pluginsList.getJSONArray("localReturn");//getting a local return
        String provInstUUID = "";//creating a variable for mock provider instance UUID
        for (int i = 0; i < array.length() ; i++) {
            if (array.getJSONObject(i).get("xmlApplicationContext").equals("serena-provider-mockdummy-1_0.xml")){//finding an array member by its xml file
               provInstUUID = array.getJSONObject(i).getString("uuid");//saving a UUID to the variable
            }
        }

        //System.out.println(rp.getTaskCollections().toString());


        String tcID = rp.postTaskCollection("My super TC 1");//Creating a task collection
        String jsonFromGetTC = rp.getTaskCollections();//Getting list of task collections

        if (jsonFromGetTC.contains(tcID)){//the list should contain a ID of our task collection
            System.out.println();
            rp.createTaskForATC(tcID,provInstUUID,"Rest task");//creating a task for the task collection, using TC id, provider instance UUID and a task name
            System.out.println("The end!");
        }else {
            System.out.println("We were not able to find TaskCollectionID in the list of existing TaskCollection");
            System.exit(1);
        }
    }
}

