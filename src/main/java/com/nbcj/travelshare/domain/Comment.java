package com.nbcj.travelshare.domain;

import java.util.Date;

public class Comment {

    // 游记评论的类

    private Integer cmid; // 评论 id
    private Date date; // 评论日期
    private String nickname; // y哦那个胡昵称
    private String content; // 评论内容
    private Travels travels; // 评论的游记

    public Integer getCmid() {
        return cmid;
    }

    public void setCmid(Integer cmid) {
        this.cmid = cmid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Travels getTravels() {
        return travels;
    }

    public void setTravels(Travels travels) {
        this.travels = travels;
    }

}
