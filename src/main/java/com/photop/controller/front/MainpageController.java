package com.photop.controller.front;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bjwangxingchen on 2017/11/21.
 */
@RestController
public class MainpageController {

    @RequestMapping(value = "/test")
    public String test(){
        return "hehe";
    }

}
