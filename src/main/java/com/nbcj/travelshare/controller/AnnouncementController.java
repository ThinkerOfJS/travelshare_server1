package com.nbcj.travelshare.controller;

import com.nbcj.travelshare.mapper.AnnouncementMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.List;


@Controller
public class AnnouncementController {

   @Resource
    AnnouncementMapper announcementMapper;

    // 首页获取精选游记
    @ResponseBody
    @GetMapping("/announcement/list")
    public List getConcentration() {

        return announcementMapper.getAnnouncement();
    }
}
