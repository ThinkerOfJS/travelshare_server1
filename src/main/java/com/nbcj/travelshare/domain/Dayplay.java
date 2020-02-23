package com.nbcj.travelshare.domain;

import java.util.List;

public class Dayplay {

    // 三日游

    private Integer did; // 三日游板块 id
    private String name; // 三日游名称
    private String introduction; // 三日游简介
    private List<Scenicspot> scenicspots; // 三日游的景区

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<Scenicspot> getScenicspots() {
        return scenicspots;
    }

    public void setScenicspots(List<Scenicspot> scenicspots) {
        this.scenicspots = scenicspots;
    }
}
