package com.serena.rlc.tests;
import com.serena.rlc.common.ConfigurationProperties;

/**
 * Created by akolomakin on 27.01.2017.
 */
public class TestRunner {
    public static void main(String args[]) throws Exception{
        Plugin p = new Plugin();
        p.findPluginIdentifiers();
        p.findPugins();
    }
}

