package com.example.service;

import com.example.pojo.User;

/**
 * 该地方只定义接口, 一般为公用接口
 * 可以定义许多接口
 */
public interface UserService {

    User getUserById(int id);
}
