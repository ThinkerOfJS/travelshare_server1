package com.nbcj.travelshare.mapper;

public interface CollectionMapper {
    void collectTravels(Integer tid, Integer uid); //收藏游记
    Integer isCollect(Integer tid, Integer uid); // 判断游记是否收藏，若游记收藏则返回1，否则返回0
    void collectCancel(Integer tid, Integer uid); // 取消收藏
}
