package com.nbcj.travelshare.service;

public interface CollectionService {
    void collectTravels(Integer tid, Integer uid); //收藏游记
    Boolean isCollect(Integer tid, Integer uid); // 判断游记是否收藏，若游记收藏则返回true，否则返回false
    void collectCancel(Integer tid, Integer uid); // 取消收藏
    Integer collection(Integer tid, Integer uid); // 直接添加游记，若游记已收藏则取消收藏，若没收藏则收藏游记
}
