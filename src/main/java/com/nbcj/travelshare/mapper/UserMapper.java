package com.nbcj.travelshare.mapper;

import com.nbcj.travelshare.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User findUserById(Integer id);
    User findUserByPhone(String phone);
    User findUserByUsername(@Param(value = "value") String username);

    // 插入用户信息
    void insertUser(String username, String password);

    // 判断用户是否存在，若不存在则返回 0，若存在则返回一个值不为 0 的整型
    Integer countUser(String username);

    void updateUser(String username, String password);

    // 获取用户发表游记
    List getTravelsByUserId(Integer uid);

    // 获取用户收藏游记
    List getCollectionTravelsByUserId(Integer uid);
}
