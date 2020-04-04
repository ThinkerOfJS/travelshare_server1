package com.nbcj.travelshare.service;

import com.nbcj.travelshare.mapper.CollectionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("CollectionServiceImpl")
public class CollectionServiceImpl implements CollectionService{
    @Resource
    CollectionMapper collectionMapper;

    // 收藏游记
    @Override
    public void collectTravels(Integer tid, Integer uid) {
        collectionMapper.collectTravels(tid, uid);
    }

    // 判断游记是否收藏，收藏则返回true，否则返回false
    @Override
    public Boolean isCollect(Integer tid, Integer uid) {
        int flag = collectionMapper.isCollect(tid, uid);
        return flag == 1;
    }


    // 取消收藏
    @Override
    public void collectCancel(Integer tid, Integer uid) {
        collectionMapper.collectCancel(tid, uid);
    }

    @Override
    public Integer collection(Integer tid, Integer uid) {
        Boolean flag = this.isCollect(tid, uid);
        if (flag) {
            this.collectCancel(tid, uid);
            return 1;
        } else {
            this.collectTravels(tid, uid);
            return 2;
        }
    }
}
