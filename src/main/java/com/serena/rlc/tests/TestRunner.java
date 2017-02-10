package com.serena.rlc.tests;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by akolomakin on 27.01.2017.
 */
public class TestRunner {
    public static void main(String args[]) throws Exception{
        Plugin p = new Plugin();
        V2taskcollections rp = new V2taskcollections();
        Execution execObject = new Execution();
        IntegrationEntity duObject = new IntegrationEntity();

        String mockProviderName="M";
        String provInstUUID = execObject.findProviders(mockProviderName);//get execition provider instance UUID
        String duProvInstUUID = duObject.findDUProvidersAndreturnUUID(mockProviderName);//get DU provider instance UUID


        String tcID = rp.postTaskCollection("My super TC 1");//Creating a task collection
        System.out.println("tcid =" + tcID);
        String jsonFromGetTC = rp.getTaskCollections(tcID);//Getting list of task collections

//        if (jsonFromGetTC.contains(tcID)){//the list should contain a ID of our task collection
//            //creating a task for the task collection, using TC id, provider instance UUID and a task name
//            rp.addTasktoTCid(tcID, provInstUUID,"Rest task Name");
//            System.out.println("Task created");
//        }else {
//            System.out.println("We were not able to find TaskCollectionID in the list of existing TaskCollection");
//            System.exit(1);
//        }

        rp.addTasktoTCid(tcID,provInstUUID,"Rest task Name");
        //Create Task POST: http://stl-qa-oalmt3/rlc/rest/v2/taskcollections/100089/tasks?

        //CreateRunforTaskClooection  POST http://stl-qa-oalmt3/rlc/rest/v2/taskcollections/100089/executions?
        // {"environment": {"environment_id": "1012:1"	}}
        rp.createRunforTaskClooection(tcID);

        //Receive number of the Run
        rp.receiveNumberofTCRUN();

        //Start TaskCollectionRun PUT: http://stl-qa-oalmt3/rlc/rest/v2/taskcollections/100089/executions/20/start?
        rp.srartTCRun(tcID);

        //Check Taskcollection Run status GET:  http://stl-qa-oalmt3/rlc/rest/v2/taskcollections/100089/executions/20/
        rp.checkRunExecution(tcID);

//Failed Task Collection
        V2taskcollections rpFail = new V2taskcollections();
        String tcID2 = rpFail.postTaskCollection("_");
        rpFail.getTaskCollections(tcID2);
        rpFail.addTaskWithParm(tcID2, provInstUUID,"Task With Parm");
        rpFail.addDUsToTC(tcID2, duProvInstUUID);
        String id = getDUsforTC(tcID2);
        rpFail.relateDU(tcID2,id);
        rpFail.createRunforTaskClooection(tcID2);
        rpFail.srartTCRun(tcID2);
        rpFail.checkRunExecution(tcID2);



    }
}

