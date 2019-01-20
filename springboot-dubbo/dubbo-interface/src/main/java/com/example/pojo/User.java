package com.example.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 */
@Data
public class User implements Serializable{

    private Integer id;

    private String name;

    private Integer age;


}
