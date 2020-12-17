package com.zuishuai.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 0:03
 */
@Controller
public class TestController {

    @GetMapping("doTest")
    public String testDemo(){
        return "test";
    }
}
