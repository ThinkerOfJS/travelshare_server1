package com.nbcj.travelshare.controller;

import com.nbcj.travelshare.domain.Travels;
import com.nbcj.travelshare.mapper.TravelsMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TravelsController {
    @Resource
    TravelsMapper travelsMapper;

    // 获取游记详情
    //@ResponseBody
    //@GetMapping("/travels/detail")
    //public Travels getCollection(@RequestParam Integer tid) {
    //    //Travels travels;
    //    //travels = ;
    //    //return travels;
    //}
}
