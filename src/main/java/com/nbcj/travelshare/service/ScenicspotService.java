package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.Scenicspot;

import java.util.List;

public interface ScenicspotService {
    // 获取热门景区
    List<Scenicspot> getHotScenicspot(Integer start, Integer end);
    Scenicspot getScenicspot(Integer sid);
}
