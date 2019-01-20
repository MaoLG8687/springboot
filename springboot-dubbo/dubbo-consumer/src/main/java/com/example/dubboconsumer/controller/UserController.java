package com.example.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference  //将生产者注册到Dubbo映射到该对象上, 这里完成了服务之间的调用
    private UserService userService;

    @RequestMapping("/getUserById")
    public Object getUserById (int id){
       return userService.getUserById(id);
    }
}
