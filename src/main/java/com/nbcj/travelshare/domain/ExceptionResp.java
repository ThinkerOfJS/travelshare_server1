package com.nbcj.travelshare.domain;

public class ExceptionResp {
    private String msg; // 响应的信息
    private Integer code; // 响应信息的状态码，0：登录成功，1：用户不存在，2：密码错误

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
