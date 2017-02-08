package com.serena.rlc.common;

/**
 * Created by akolomakin on 27.01.2017.
 */
public class ConfigurationProperties {
    public String rlcURL;
    public String sbmUserName;
    public String sbmUserPass;

    public ConfigurationProperties(){
        rlcURL="http://stl-qa-oalmt3/";
        sbmUserName="Admin";
        sbmUserPass="";
    }

    public String getRlcURL() { return rlcURL; }

    public void setRlcURL(String rlcURL) {
        this.rlcURL = rlcURL;
    }

    public String getSbmUserName() {
        return sbmUserName;
    }

    public void setSbmUserName(String sbmUserName) {
        this.sbmUserName = sbmUserName;
    }

    public String getSbmUserPass() {
        return sbmUserPass;
    }

    public void setSbmUserPass(String sbmUserPass) { this.sbmUserPass = sbmUserPass; }
}
