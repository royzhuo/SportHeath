package com.beStrong.entity;

/**
 * @author roy.zhuo
 */
public class FinalResult {

    public static final String SUCCESS_CODE = "200";
    public static final String NOTFind_CODE = "404";
    public static final String error_CODE = "500";
    public static final String CODE_NAME = "code";
    public static final String INFO_NAME = "info";

    private String code;
    private String code_Name;
    private String info;
    private Object result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode_Name() {
        return code_Name;
    }

    public void setCode_Name(String code_Name) {
        this.code_Name = code_Name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
