package com.nbcj.travelshare.domain;

import java.util.List;

public class TravelsType {

    // 游记分类
    private Integer tpid;
    private String tpname;
    private List travels;

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public String getTpname() {
        return tpname;
    }

    public void setTpname(String tpname) {
        this.tpname = tpname;
    }

    public List getTravels() {
        return travels;
    }

    public void setTravels(List travels) {
        this.travels = travels;
    }

    @Override
    public String toString() {
        return "TravelsType{" +
                "tpid=" + tpid +
                ", tpname='" + tpname + '\'' +
                ", travels=" + travels +
                '}';
    }
}
