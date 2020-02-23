package com.nbcj.travelshare.domain;

import java.util.Date;


public class Travels {

    // 游记
    private Integer tid;
    private String title; // 游记标题
    private String content; // 游记内容
    private Date date; // 游记日期
    private Integer viewcount; // 游记浏览量
    private String pics; // 游记图片
    private Integer tpid;  // 游记分类
    private Integer uid; // 发表用户的 id

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getViewcount() {
        return viewcount;
    }

    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Travels{" +
                "tid=" + tid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", viewcount=" + viewcount +
                ", pics='" + pics + '\'' +
                ", tpid=" + tpid +
                ", uid=" + uid +
                '}';
    }
}
