package com.nbcj.travelshare.domain;

import java.util.List;

public class Collection {

    // 游记收藏实体类
    private User user;
    private List<Travels> travels;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Travels> getTravels() {
        return travels;
    }

    public void setTravels(List<Travels> travels) {
        this.travels = travels;
    }
}
