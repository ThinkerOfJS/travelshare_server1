package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.GetTravelsByTpid;
import com.nbcj.travelshare.domain.Travels;

import java.util.List;

public interface TravelsService {
    List<GetTravelsByTpid> findFeaturedTravels(Integer id);
    void addTravels(Travels travels);
    Travels getTravelsDetail(Integer tid);
    List<Travels> searchByTitle(String title);
    List<Travels> getTravelsByTpid(Integer tpid, Integer start, Integer end); // 根据分类ID获取游记
}
