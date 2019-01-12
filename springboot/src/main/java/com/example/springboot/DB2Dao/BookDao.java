package com.example.springboot.DB2Dao;

import com.example.springboot.pojo.Book;

import java.util.List;

public interface BookDao {

    List<Book> selectAllBook();
}
