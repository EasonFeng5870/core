package com.eason.springmvc.controller;

import com.eason.springmvc.domain.SimpleMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by feng yingsheng on 10/4/2017.
 */
@Controller
public class ConverterController {

    @RequestMapping(value = "/convert", produces = {"application/x-wisely"})
    public @ResponseBody SimpleMessage convert(@RequestBody SimpleMessage simpleMessage) {
        return simpleMessage;
    }
}
