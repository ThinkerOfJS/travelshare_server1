package com.nbcj.travelshare.domain;

public class Attracions {

    // 景点实体类

    private Integer aid;
    private String title; // 景点标题
    private String introduction; // 景点介绍
    private String imgurl; // 景点图片地址
    //private Integer sid;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
