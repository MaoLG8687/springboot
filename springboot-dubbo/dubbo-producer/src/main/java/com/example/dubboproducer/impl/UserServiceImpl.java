package com.example.dubboproducer.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.dubboproducer.dao.UserDao;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Service //这里是dubbo的注解, 将接口暴露在外, 可以供调用, 这里就是放在了注册中心
//@org.springframework.stereotype.Service   spring自己的注解, 为了区分, 使用了@Component
@Component //让spring扫描该类, 用spring的 @Service也行
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.selectUserById(id);
    }
}
