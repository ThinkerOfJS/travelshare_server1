package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.User;
import com.nbcj.travelshare.mapper.UserMapper;
import com.nbcj.travelshare.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User findUserById(Integer uid) {
        return userMapper.findUserById(uid);
    }

    @Override
    public User findUserByPhone(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    // 注册用户，调用 countUser 判断用户存不存在
    @Override
    public Boolean registerUser(String username, String password) {
        if (userMapper.countUser(username) == 0) {
            // 用户不存在，插入用户信息，返回 true
            userMapper.insertUser(username, password);
            return true;
        } else {
            // 用户存在，返回 false
            return false;
        }
    }

    // 用户修改密码的方法
    @Override
    public Boolean updateUser(String username, String password) {
        if (userMapper.countUser(username) == 0) {
            // 用户不存在
            return false;
        } else {
            // 用户存在
            userMapper.updateUser(username, password);
            return true;
        }
    }

    // 游记图片上传
    @Value("${absoluteImgPath}")
    String absoluteImgPath;

    @Value("${sonImgPath}")
    String sonImgPath;
    @Override
    public Map<String, String> changeUserInfo(MultipartFile[] file, User user) {
        Map<String,String> map = new HashMap<>();
        String path="";

        for (int i = 0; i < file.length; i++) {
            if (file[i].isEmpty()) {
                map.put("code", "500");
                map.put("msg", "添加失败");
                System.out.println("图片不能为空");
                return map;
            }

            String originalFilename = file[i].getOriginalFilename();
            //随机生成文件名
            String fileName = RandomUtils.random() + originalFilename;
            File dest = new File(absoluteImgPath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            String travelsPicture = sonImgPath + fileName;
            //System.out.println("改变后的图片路径"+travelsPicture + "------图片父路径" + absoluteImgPath);
            try {
                file[i].transferTo(dest);
                path += travelsPicture+",";
            } catch (Exception e) {
                map.put("ERROR", e.getMessage());
                return  map;
            }
        }

        try {
            // 将文件存入到travels实例中并将存储到数据库中
            user.setAvatarsrc(path);
            //System.out.println("图片路径--------------"+path);
            saveUser(user);
            //System.out.println("将游记信息添加进数据库--------------"+travels);
            map.put("OK", "200");
            return map;
        }
        catch (Exception e){
            map.put("ERROR",  e.getMessage());
            return map;
        }
    }

    @Override
    public void saveUser(User user) {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("uid", user.getUid());
        userMap.put("nickname", user.getNickname());
        userMap.put("introduction", user.getIntroduction());
        userMap.put("phone", user.getPhone());
        userMap.put("email", user.getEmail());
        userMap.put("avatarsrc", user.getAvatarsrc());
        userMapper.changeUser(userMap);
    }

    // 获取用户发表游记
    @Override
    public List getTravelsByUserId(Integer uid) {
        return userMapper.getTravelsByUserId(uid);
    }



}
