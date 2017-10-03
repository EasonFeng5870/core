package com.eason.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * request demo:
 *
 *      http://localhost:8080/springmvc/toUpload
 *
 * Created by feng yingsheng on 10/3/2017.
 */
@Controller
@Slf4j
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = "multipart/form-data;charset=UTF-8")
    public String upload(@RequestParam("file") CommonsMultipartFile file) {
        log.info("----------------------------------");
        try{
            log.info(file.getFileItem().getName());
            return "index";
        }
        catch (Exception e) {
            log.error(e.getMessage());
            return "error";
        }
    }
}
