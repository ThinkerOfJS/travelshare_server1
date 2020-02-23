package com.nbcj.travelshare.domain;

import java.util.List;

public class Scenicspot {

    // 景区

    private Integer sid;
    private String title; // 景区标题
    private Integer viewcount; // 景区浏览量
    private String address; // 景区地址
    private String imgurl; // 景区图片地址
    private Integer playtime; // 三日游板块的每个景区游玩时长
    private Integer did; // 三日游分类外键
    private List<Attracions> attracions; // 景区内的景点
    private List<Ticket> tickets; // 景区门票

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getViewcount() {
        return viewcount;
    }

    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Integer getPlaytime() {
        return playtime;
    }

    public void setPlaytime(Integer playtime) {
        this.playtime = playtime;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public List<Attracions> getAttracions() {
        return attracions;
    }

    public void setAttracions(List<Attracions> attracions) {
        this.attracions = attracions;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
