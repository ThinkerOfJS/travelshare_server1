package com.nbcj.travelshare.mapper;

import com.nbcj.travelshare.domain.GetTravelsByTpid;
import com.nbcj.travelshare.domain.Travels;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TravelsMapper {
    List<GetTravelsByTpid> getFeatureTravelsById(Integer id);
    List<Travels> findTravelsByUserId(Integer uid, Integer start, Integer end); // 通过用户Id查找游记
    List<Travels> findTravelsByTypeId(Integer tpid);// 根据分类Id筛选游记
    List<Travels> findCollectionTravels(Integer uid, Integer start, Integer end); // 查找用户收藏过的游记
    Travels findTravelsByTid(Integer tid); // 游记详情
    Integer getViewcountByTid(Integer tid); // 首先获取游记的当前浏览量
    void addViewcount(Integer tid, Integer viewcount); // 用户每次浏览都会增加浏览量
    List<Travels> searchTravelsByTitle(String title); // 根据游记标题搜索游记
    void addTravels(Map travelsMap); // 添加游记
    List<Travels> getConcentrationTravels(); // 首页获取精选游记
    List<Travels> getTravelsByTpid(Integer tpid, Integer start, Integer end); // 根据分类Id分页加载游记
    List<Travels> getTravelsList(Integer start, Integer end); // 当分类为推荐时，直接展示游记列表
}
