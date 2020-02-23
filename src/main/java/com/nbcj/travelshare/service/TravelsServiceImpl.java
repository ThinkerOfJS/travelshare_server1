package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.GetTravelsByTpid;
import com.nbcj.travelshare.mapper.TravelsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TravelsServiceImpl implements TravelsService {

    @Resource
    TravelsMapper travelsMapper;

    @Override
    public List<GetTravelsByTpid> findFeaturedTravels(Integer id) {
        return travelsMapper.getFeatureTravelsById(id);
    }
}
