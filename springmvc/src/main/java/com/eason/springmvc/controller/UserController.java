package com.eason.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by feng yingsheng on 10/1/2017.
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @RequestMapping(value = "/{userId}")
    public String getUserInfo(@PathVariable String userId, HttpServletRequest request) {
        log.error("controller now is working, userId=" + userId);
        request.getSession().setAttribute("userId", userId);
        return "index";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadGet() {
        log.info("--------1---------------");
        return "index";
    }

    @RequestMapping(value = "/error")
    public String getErrorExample() throws Exception {
        int i=0;
        if(i == 0) {
            throw new Exception("this is an error test.");
        }
        return "index";
    }
}
