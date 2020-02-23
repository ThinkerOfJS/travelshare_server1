package com.nbcj.travelshare.mapper;

import com.nbcj.travelshare.domain.GetTravelsByTpid;
import com.nbcj.travelshare.domain.Travels;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TravelsMapper {
    List<GetTravelsByTpid> getFeatureTravelsById(Integer id);
    List<Travels> findTravelsByUserId(Integer uid); // 通过用户Id查找游记
    List<Travels> findTravelsByTypeId(Integer tpid);// 根据分类Id筛选游记
    List<Travels> findCollectionTravels(Integer uid); //

}
