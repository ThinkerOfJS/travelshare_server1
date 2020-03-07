package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.GetTravelsByTpid;
import com.nbcj.travelshare.domain.Travels;
import com.nbcj.travelshare.mapper.TravelsMapper;
import com.nbcj.travelshare.mapper.TravelsTypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        return travelsTypeMapper.getTravelsByTpid(tpid, start, end);
    }
}
