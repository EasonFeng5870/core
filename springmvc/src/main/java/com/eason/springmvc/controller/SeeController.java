package com.eason.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * Created by feng yingsheng on 10/3/2017.
 */
@RestController
@RequestMapping("/")
public class SeeController {

    @RequestMapping(value = "/push", produces = "text/event-stream;charset=UTF-8")
    public String push(HttpServletResponse response){
        Random random = new Random();
        try{
            Thread.sleep(5000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("text/event-stream;charset=UTF-8");
        return "data:Testing 1,2,3" + random.nextInt() + "\n\n";

    }

}
