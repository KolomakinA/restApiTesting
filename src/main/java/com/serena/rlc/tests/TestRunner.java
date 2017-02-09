package com.serena.rlc.tests;
import com.serena.rlc.common.ConfigurationProperties;

/**
 * Created by akolomakin on 27.01.2017.
 */
public class TestRunner {
    public static void main(String args[]) throws Exception{
//        Plugin p = new Plugin();
        V2taskcollections rp = new V2taskcollections();

        //Printing out returned JSON's for now
//        p.findPluginIdentifiers();
//        p.findPugins();

        //System.out.println(rp.getTaskCollections().toString());


        String tcID = rp.postTaskCollection("My super TC 1");
//        System.out.println(tcID);
        String jsonFromGetTC = rp.getTaskCollections();
        if (jsonFromGetTC.contains(tcID)){
            rp.createTaskForATC(tcID);
        }else {
            System.out.println("We were not able to find TaskCollectionID in the list of existing TaskCollection");
            System.exit(1);
        }
    }
}

