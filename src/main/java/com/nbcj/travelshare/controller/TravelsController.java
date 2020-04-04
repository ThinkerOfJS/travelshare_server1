package com.nbcj.travelshare.controller;

import com.nbcj.travelshare.domain.Comment;
import com.nbcj.travelshare.domain.ExceptionResp;
import com.nbcj.travelshare.domain.Travels;
import com.nbcj.travelshare.mapper.CommentMapper;
import com.nbcj.travelshare.mapper.TravelsMapper;
import com.nbcj.travelshare.service.CollectionServiceImpl;
import com.nbcj.travelshare.service.TravelsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class TravelsController {

    Logger logger;

    @Resource
    TravelsMapper travelsMapper;

    @Resource
    TravelsServiceImpl travelsService;

    @Resource
    CommentMapper commentMapper;

    @Resource
    CollectionServiceImpl collectionService;

    ExceptionResp exceptionResp = new ExceptionResp();

     // 获取游记详情
    @ResponseBody
    @GetMapping("/travels/detail")
    public Travels getCollection(@RequestParam Integer tid) {
        Travels travels;
        travels = travelsService.getTravelsDetail(tid);
        return travels;
    }

    // 添加游记
    @ResponseBody
    @PostMapping("/travels/add")
    public Map addTravels(@RequestParam(value = "file",required = false) MultipartFile[] file, Travels travels){
        //Map<String, String> map = new HashMap<>();
        travels.setDate(new Date());
        travels.setViewcount(0);
        return travelsService.saveTravels(file,travels);
    }

    // 首页获取精选游记
    @ResponseBody
    @GetMapping("/travels/concentration")
    public List getConcentration() {
        List travels ;
        travels = travelsMapper.getConcentrationTravels();
        return travels;
    }

    // 首页获取精选游记
    @ResponseBody
    @PostMapping("/travels/travelstype")
    public List getTravelsByTp(@RequestBody Map<String, Integer> param) {
        Integer tpid = param.get("tpid");
        Integer start = param.get("start");
        Integer end = param.get("end");

        return travelsService.getTravelsByTpid(tpid, start, end);
    }

    // 获取游记评论
    @ResponseBody
    @PostMapping("/travels/getcomment")
    public List getTravelsComment(@RequestBody Map<String, Integer> param) {
        Integer tid = param.get("tid");
        Integer start = param.get("start");
        Integer end = param.get("end");

        return commentMapper.getComment(tid, start, end);
    }

    // 添加评论
    @ResponseBody
    @PostMapping("/travels/addcomment")
    public ExceptionResp addComment(@RequestBody Comment comment) {
        String content = comment.getContent();
        String nickName = comment.getNickname();
        Integer tid = comment.getTid();
        Integer uid = comment.getUid();
        commentMapper.addComment(content, nickName, uid, tid);
        exceptionResp.setMsg("发表成功！");
        return exceptionResp;
    }

    // 收藏游记
    @ResponseBody
    @PostMapping("/travels/addcollection")
    public ExceptionResp addCollection(@RequestBody Map<String, Integer> map) {
        Integer tid = map.get("tid");
        Integer uid = map.get("uid");
        Integer flag = collectionService.collection(tid, uid);
        if (flag == 1) {
            exceptionResp.setMsg("取消收藏！");
        } else {
            exceptionResp.setMsg("收藏成功！");
        }
        return exceptionResp;
    }

    // 获取个人动态
    @ResponseBody
    @PostMapping("/travels/usertravels")
    public List getUserTravels(@RequestBody Map<String, Integer> param) {
        Integer uid = param.get("uid");
        Integer start = param.get("start");
        Integer end = param.get("end");

        return travelsMapper.findTravelsByUserId(uid, start, end);
    }

    // 获取个人收藏
    @ResponseBody
    @PostMapping("/travels/usercollection")
    public List getUserCollection(@RequestBody Map<String, Integer> param) {
        Integer uid = param.get("uid");
        Integer start = param.get("start");
        Integer end = param.get("end");

        return travelsMapper.findCollectionTravels(uid, start, end);
    }

    // 游记搜索游记
    @ResponseBody
    @GetMapping("/travels/search")
    public List getTravelsByTitle(@RequestParam String title) {

        return travelsService.searchByTitle(title);
    }

}
