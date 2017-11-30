package com.photop.controller.front;

import com.photop.dao.Photo;
import com.photop.dao.repositoty.PhotoRepositorym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bjwangxingchen on 2017/11/21.
 */
@RestController
//@RequestMapping(value = "/front")
public class MainpageController {

    @Autowired
    private PhotoRepositorym photoRepositorym;

    @RequestMapping(value = "/test")
    public String test() {
        return "hehe";
    }

    //获取最热列表
    @GetMapping(value = "/hotPhotos")
    public List<Photo> photoList() {
        List<Photo> photoList = photoRepositorym.findAll();
        if (null != photoList)
            return photoList;
        else return null;
    }
    //获取最新列表
    @GetMapping(value = "/newPhotos")
    public List<Photo> newphotoList() {
        List<Photo> photoList = photoRepositorym.findAll();
        if (null != photoList)
            return photoList;
        else return null;
    }

    //查询一个照片集
    @GetMapping(value = "/photo/{id}")
    public Photo photoGet(@PathVariable("id") Integer id) {
        return photoRepositorym.findOne(id);
    }




}
