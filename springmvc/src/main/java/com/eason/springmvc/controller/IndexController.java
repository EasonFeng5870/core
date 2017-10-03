package com.eason.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by feng yingsheng on 10/1/2017.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/index")
    public String hello() {
        return "index";
    }

    @RequestMapping("/toUpload")
    public String toUpload() {
        return "upload";
    }
}
