package com.nbcj.travelshare.domain;

public class Role {

    // 用户角色

    private Integer rid;
    private String rname; // 角色名称

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
