package com.example.springboot.service.impl;

import com.example.springboot.DB1Dao.UserDao;
import com.example.springboot.DB2Dao.BookDao;
import com.example.springboot.pojo.Book;
import com.example.springboot.pojo.User;
import com.example.springboot.service.BookService;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getAllBook() {
        return bookDao.selectAllBook();
    }
}
