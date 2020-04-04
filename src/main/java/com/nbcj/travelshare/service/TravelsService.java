package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.GetTravelsByTpid;
import com.nbcj.travelshare.domain.Travels;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface TravelsService {
    List<GetTravelsByTpid> findFeaturedTravels(Integer id);
    void addTravels(Travels travels);
    Map<String, String> saveTravels(MultipartFile[] file, Travels Travels);
    Travels getTravelsDetail(Integer tid);
    List<Travels> searchByTitle(String title);
    List<Travels> getTravelsByTpid(Integer tpid, Integer start, Integer end); // 根据分类ID获取游记
}
