package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.GetTravelsByTpid;
import com.nbcj.travelshare.domain.Travels;
import com.nbcj.travelshare.mapper.TravelsMapper;
import com.nbcj.travelshare.mapper.TravelsTypeMapper;
import com.nbcj.travelshare.util.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TravelsServiceImpl implements TravelsService {

    @Resource
    TravelsMapper travelsMapper;

    @Resource
    TravelsTypeMapper travelsTypeMapper;

    @Override
    public List<GetTravelsByTpid> findFeaturedTravels(Integer id) {
        return travelsMapper.getFeatureTravelsById(id);
    }

    // 添加游记
    @Override
    public void addTravels(Travels travels) {
        Map<String, Object> travelsMap = new HashMap<>();
        travelsMap.put("title", travels.getTitle());
        travelsMap.put("content", travels.getContent());
        travelsMap.put("pics", travels.getPics());
        travelsMap.put("place", travels.getPlace());
        travelsMap.put("tpid", travels.getTpid());
        travelsMap.put("uid", travels.getUid());

        travelsMapper.addTravels(travelsMap);
    }

    // 获取游记详情
    @Override
    public Travels getTravelsDetail(Integer tid) {
        Integer viewcount = travelsMapper.getViewcountByTid(tid);
        travelsMapper.addViewcount(tid, viewcount + 1);
        //Travels travels = travelsMapper.findTravelsByTid(tid);
        //Date date = travels.getDate();
        //String newDate =
        return travelsMapper.findTravelsByTid(tid);
    }

    // 根据游记标题搜索游记
    @Override
    public List<Travels> searchByTitle(String title) {
        return travelsMapper.searchTravelsByTitle(title);
    }

    // 根据游记分类Id获取，分类下的游记
    @Override
    public List<Travels> getTravelsByTpid(Integer tpid, Integer start, Integer end) {
        if (tpid == 0) {
            return travelsMapper.getTravelsList(start, end);
        } else {
            return travelsMapper.getTravelsByTpid(tpid, start, end);
        }
    }

    // 游记图片上传
    @Value("${absoluteImgPath}")
    String absoluteImgPath;

    @Value("${sonImgPath}")
    String sonImgPath;
    public Map<String, String> saveTravels(MultipartFile[] file, Travels travels) {
        Map<String,String> map = new HashMap<>();
        String path="";

        for (int i = 0; i < file.length; i++) {
            if (file[i].isEmpty()) {
                map.put("code", "500");
                map.put("msg", "添加失败");
                System.out.println("图片不能为空");
                return map;
            }

            String originalFilename = file[i].getOriginalFilename();
            //随机生成文件名
            String fileName = RandomUtils.random() + originalFilename;
            File dest = new File(absoluteImgPath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            String travelsPicture = sonImgPath + fileName;
            //System.out.println("改变后的图片路径"+travelsPicture + "------图片父路径" + absoluteImgPath);
            try {
                file[i].transferTo(dest);
                path += travelsPicture+",";
            } catch (Exception e) {
                map.put("ERROR", e.getMessage());
                return  map;
            }
        }

        try {
            // 将文件存入到travels实例中并将存储到数据库中
            travels.setPics(path);
            //System.out.println("图片路径--------------"+path);
            addTravels(travels);
            //System.out.println("将游记信息添加进数据库--------------"+travels);
            map.put("OK", "200");
            return map;
        }
        catch (Exception e){
            map.put("ERROR",  e.getMessage());
            return map;
        }
    }
}
