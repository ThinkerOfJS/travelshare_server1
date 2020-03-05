package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.Announcement;
import com.nbcj.travelshare.mapper.AnnouncementMapper;

import javax.annotation.Resource;
import java.util.List;

public class AnnouncementServiceImpl implements AnnouncementService{

    @Resource
    AnnouncementMapper announcementMapper;
    // 获取公告信息
    @Override
    public List<Announcement> getAnnouncement() {
        return announcementMapper.getAnnouncement();
    }
}
