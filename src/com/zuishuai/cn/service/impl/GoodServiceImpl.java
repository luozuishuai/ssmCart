package com.zuishuai.cn.service.impl;

import com.zuishuai.cn.entity.Good;
import com.zuishuai.cn.mapper.GoodMapper;
import com.zuishuai.cn.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 13:33
 */
@Service
@Transactional
public class GoodServiceImpl implements GoodService{

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public List<Good> findAll() {
        return goodMapper.findAll();
    }
}
