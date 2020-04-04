package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.Scenicspot;
import com.nbcj.travelshare.mapper.ScenicspotMapper;

import javax.annotation.Resource;
import java.util.List;

public class ScenicspotServiceImpl implements ScenicspotService{
    @Resource
    ScenicspotMapper scenicspotMapper;

    // 获取热门景区
    @Override
    public List<Scenicspot> getHotScenicspot(Integer start, Integer end) {
        return scenicspotMapper.getHotScenicspot(start, end);
    }

    @Override
    public Scenicspot getScenicspot(Integer sid) {
        return null;
    }


}
