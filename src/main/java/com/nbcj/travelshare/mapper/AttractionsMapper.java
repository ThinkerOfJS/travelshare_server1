package com.nbcj.travelshare.mapper;

import com.nbcj.travelshare.domain.Attractions;

import java.util.List;

public interface AttractionsMapper {
    List<Attractions> getAttractionsBySid(Integer sid);
}
