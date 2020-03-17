package com.giserway.restapi.dto;

/**
 * 自定义返回状态码
 * */

public enum ResponseStatusCode {

    SUCCESS("0000","请求成功"),
    FAIL("0001","请求失败"),
    CUSTOMEXCEPTION("9999","请求异常"),
    PARAMETER_ERROR("0002","参数不合法");

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResponseStatusCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
