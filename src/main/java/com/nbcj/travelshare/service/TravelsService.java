package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.GetTravelsByTpid;
import java.util.List;

public interface TravelsService {
    List<GetTravelsByTpid> findFeaturedTravels(Integer id);

}
