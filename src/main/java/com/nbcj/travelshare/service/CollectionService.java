package com.nbcj.travelshare.service;

public interface CollectionService {
    void collectTravels(Integer tid, Integer uid); //收藏游记
    Boolean isCollect(Integer tid, Integer uid); // 判断游记是否收藏，若游记收藏则返回1，否则返回0
    void collectCancel(Integer tid, Integer uid); // 取消收藏
}
