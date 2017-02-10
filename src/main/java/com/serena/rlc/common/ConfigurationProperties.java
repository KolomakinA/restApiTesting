package com.serena.rlc.common;

/**
 * Created by akolomakin and olazarenko on 07.02.2017.
 */
public class ConfigurationProperties {
    private String rlcURL;
    private String sbmUserName;
    private String sbmUserPass;
    private String createdTCId;
    private String mockEnvironmentId;
    public ConfigurationProperties(){
        this.rlcURL="http://stl-qa-oalmt3/";
        this.sbmUserName="admin:";
        this.sbmUserPass="";
        this.createdTCId="";
        this.mockEnvironmentId="9999:9";
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

    public String getCreatedTCId() {
        return createdTCId;
    }

    public void setCreatedTCId(String createdTCId) {
        this.createdTCId = createdTCId;
    }

    public String getMockEnvironmentId() {
        return mockEnvironmentId;
    }

    public void setMockEnvironmentId(String mockEnvironmentId) {
        this.mockEnvironmentId = mockEnvironmentId;
    }
}