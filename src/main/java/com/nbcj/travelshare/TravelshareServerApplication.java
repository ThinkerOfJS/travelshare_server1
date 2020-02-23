package com.nbcj.travelshare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.nbcj.travelshare.mapper")  //批量扫描 mapper 文件
public class TravelshareServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelshareServerApplication.class, args);
    }

}
