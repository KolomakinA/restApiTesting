package com.serena.rlc.tests;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by akolomakin and olazarenko on 07.02.2017.
 */
public class TestRunner {
    public static void main(String args[]) throws Exception{
        V2taskcollections rp = new V2taskcollections();
        Execution execObject = new Execution();
        IntegrationEntity duObject = new IntegrationEntity();
        String mockProviderName="M";

        String provInstUUID = execObject.findProviders(mockProviderName);//get execition provider instance UUID
        String duProvInstUUID = duObject.findDUProvidersAndreturnUUID(mockProviderName);//get DU provider instance UUID
        System.out.println(provInstUUID);

//Succeded Task Collection
        String tcID = rp.postTaskCollection("My super TC 1");//Creating a task collection
        rp.getTaskCollections(tcID);//Getting list of task collections
        rp.addTasktoTCid(tcID,provInstUUID,"Rest task Name");
        rp.addDUsToTC(tcID, duProvInstUUID);
        rp.getDUsforTC(tcID);
        rp.createRunforTaskClooection(tcID);
        rp.receiveNumberofTCRUN();
        rp.srartTCRun(tcID);
        rp.checkRunExecution(tcID);

//Failed Task Collection
        V2taskcollections rpFail = new V2taskcollections();
        String tcID2 = rpFail.postTaskCollection("TC dva");
        rpFail.getTaskCollections(tcID2);
        String taskID = rpFail.addTaskWithParm(tcID2, provInstUUID,"Task With Parm");
        rpFail.addDUsToTC(tcID2,provInstUUID);
        String duID = rpFail.getDUsforTC(tcID2);
        rpFail.relateDU(tcID2, taskID,duID);
        rpFail.createRunforTaskClooection(tcID2);
        rpFail.srartTCRun(tcID2);
        rpFail.checkRunExecution(tcID2);
    }
}

