package com.serena.rlc.common;

import org.json.JSONObject;

/**
 * Created by olazarenko on 09-Feb-17.
 */
public class CompareTest {
    private JSONObject obj;
    String sTF;


    public CompareTest(JSONObject obj, String sTF) {
        this.obj=obj;
        this.sTF=sTF;
    }
    public boolean findStringInJson () {
        String st = obj.toString();
        if (st.contains(sTF)){
            return true;
        }
        else {
            return false;
        }
    }
}
