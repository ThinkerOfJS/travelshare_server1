package com.nbcj.travelshare.domain;

public class Ticket {

    // 景区门票

    private Integer tid; // 门票id
    private Float tprice; // 门票价格
    private String tname; // 门票名称

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Float getTprice() {
        return tprice;
    }

    public void setTprice(Float tprice) {
        this.tprice = tprice;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
