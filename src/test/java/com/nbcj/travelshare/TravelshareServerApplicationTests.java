package com.nbcj.travelshare;

import com.nbcj.travelshare.mapper.TravelsMapper;
import com.nbcj.travelshare.mapper.TravelsTypeMapper;
import com.nbcj.travelshare.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TravelshareServerApplicationTests {

    @Resource
    UserMapper userMapper;
    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    TravelsMapper travelsMapper;


    @Test
    void contextLoads() {
        Integer flag = userMapper.countUser("2");
        logger.info("用户存在：1--用户不存在：0" + String.valueOf(flag));
    }

    //@Test
    //void test001(){
    //    System.out.println(travelsMapper.getFeatureTravelsById(5));
    //}
    //
    //@Test
    //void test002(){
    //    System.out.println(userMapper.getTravelsByUserId(1));
    //}

    @Resource
    TravelsTypeMapper travelsTypeMapper;

    @Test
    void test003(){
        System.out.println(travelsTypeMapper.getTravelsByTpid(5));
    }

    @Test
    void test004(){
        System.out.println(userMapper.getCollectionTravelsByUserId(1));
    }
}
