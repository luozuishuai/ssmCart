package com.zuishuai.cn.service;

import com.zuishuai.cn.entity.Good;
import com.zuishuai.cn.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 13:32
 */
public interface GoodService {

    List<Good> findAll();
}
