package com.nbcj.travelshare.mapper;

import com.nbcj.travelshare.domain.Scenicspot;

import java.util.List;

public interface ScenicspotMapper {

    // 获取热门景区
    List<Scenicspot> getHotScenicspot();

}
