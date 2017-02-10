package com.serena.rlc.tests;

/**
 * Created by olazarenko on 10-Feb-17.
 */
import org.testng.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testing {
   @BeforeTest
    public void testBefore() throws Exception {
       boolean b = false;
       Assert.assertFalse(b);

   }
  //@AfterTest

    @Test
    public void test1() throws Exception{
        V2taskcollections rpFail = new V2taskcollections();
        Execution execObject = new Execution();
        IntegrationEntity duObject = new IntegrationEntity();
        String mockProviderName = "M";
        String provInstUUID = execObject.findProviders(mockProviderName);
            String tcID2 = rpFail.postTaskCollection("TC dva");
            rpFail.getTaskCollections(tcID2);
            String taskID = rpFail.addTaskWithParm(tcID2, provInstUUID,"Task With Parm");
            rpFail.addDUsToTC(tcID2,provInstUUID);
            String duID = rpFail.getDUsforTC(tcID2);
            rpFail.relateDU(tcID2, taskID,duID);
            rpFail.createRunforTaskClooection(tcID2);
            rpFail.srartTCRun(tcID2);
            String res = rpFail.checkRunExecution(tcID2);

        Assert.assertTrue(rpFail.relateDU(tcID2, taskID,duID));
        Assert.assertEquals(res,"FAILED");
    }

    @Test
    public void test2() throws Exception {
        V2taskcollections rp = new V2taskcollections();
        Execution execObject = new Execution();
        IntegrationEntity duObject = new IntegrationEntity();
        String mockProviderName="M";

        String provInstUUID = execObject.findProviders(mockProviderName);//get execition provider instance UUID
        String duProvInstUUID = duObject.findDUProvidersAndreturnUUID(mockProviderName);//get DU provider instance UUID

//Succeded Task Collection
        String tcID = rp.postTaskCollection("My super TC 1");//Creating a task collection
        rp.getTaskCollections(tcID);//Getting list of task collections
        rp.addTasktoTCid(tcID,provInstUUID,"Rest task Name");
        rp.addDUsToTC(tcID, duProvInstUUID);
        rp.getDUsforTC(tcID);
        rp.createRunforTaskClooection(tcID);
        rp.receiveNumberofTCRUN();
        rp.srartTCRun(tcID);
        String res = rp.checkRunExecution(tcID);
        Assert.assertEquals(res,"SUCCEED");
    }
}
