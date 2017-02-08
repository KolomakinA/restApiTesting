package com.serena.rlc.tests;
import com.serena.rlc.common.ConfigurationProperties;

/**
 * Created by akolomakin on 27.01.2017.
 */
public class TestRunner {
    public static void main(String args[]) throws Exception{
        Plugin p = new Plugin();
        V2taskcollections rp = new V2taskcollections();

        //Printing out returned JSON's for now
        p.findPluginIdentifiers();
        p.findPugins();

        rp.deleteTaskCollection("100000");
    }
}

