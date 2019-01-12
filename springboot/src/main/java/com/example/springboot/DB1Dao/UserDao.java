package com.example.springboot.DB1Dao;


import com.example.springboot.pojo.User;

import java.util.List;

public interface UserDao{

    List<User> selectAllUser();
}
