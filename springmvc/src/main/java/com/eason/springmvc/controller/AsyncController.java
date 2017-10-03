package com.eason.springmvc.controller;

import com.eason.springmvc.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by feng yingsheng on 10/3/2017.
 */
@RestController
@RequestMapping("/")
public class AsyncController {

    @Autowired
    private PushService pushService;

    @RequestMapping(value = "/defer", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public DeferredResult<String> deferredCall(HttpServletResponse response) {
        DeferredResult<String> res = pushService.getAsyncUpdate();
        return res;
    }
}
