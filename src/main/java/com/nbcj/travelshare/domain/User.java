package com.nbcj.travelshare.domain;

import java.util.List;

public class User {

    // 用户类

    private Integer uid; // 用户 id
    private String nickname; // 用户昵称
    private String username; // 用户名
    private String password; // 用户密码
    private String email; // 用户邮箱
    private String phone; // 用户手机号
    private String introduction; // 个性签名
    private String avatarsrc; // 头像资源地址
    private List travels; // 用户发布的游记
    private List ctravels; // 用户收藏的游记

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAvatarsrc() {
        return avatarsrc;
    }

    public void setAvatarsrc(String avatarsrc) {
        this.avatarsrc = avatarsrc;
    }

    public List getTravels() {
        return travels;
    }

    public void setTravels(List travels) {
        this.travels = travels;
    }

    public List getCtravels() {
        return ctravels;
    }

    public void setCtravels(List ctravels) {
        this.ctravels = ctravels;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", introduction='" + introduction + '\'' +
                ", avatarsrc='" + avatarsrc + '\'' +
                ", travels=" + travels +
                ", ctravels=" + ctravels +
                '}';
    }
}
