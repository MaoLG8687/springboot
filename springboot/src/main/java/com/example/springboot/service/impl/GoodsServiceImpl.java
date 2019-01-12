package com.example.springboot.service.impl;

import com.example.springboot.DB2Dao.BookDao;
import com.example.springboot.DB3Dao.GoodsDao;
import com.example.springboot.pojo.Book;
import com.example.springboot.pojo.Goods;
import com.example.springboot.service.BookService;
import com.example.springboot.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.getAllGoods();
    }
}
