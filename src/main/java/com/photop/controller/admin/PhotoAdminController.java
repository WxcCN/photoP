package com.photop.controller.admin;

import com.photop.dao.Photo;
import com.photop.dao.repositoty.PhotoRepositorym;
import com.photop.enums.ResultEnum;
import com.photop.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;


/**
 * Created by bjwangxingchen on 2017/11/29.
 */

@RestController
public class PhotoAdminController {


    private static final Logger logger = LoggerFactory.getLogger(PhotoAdminController.class);

    @Autowired
    private PhotoRepositorym photoRepositorym;
    //插入一个照片集
    @PostMapping(value = "/manage/photo")
    public Object photoAdd(@RequestParam(value = "name", required = false) String name,
                           @RequestParam("url") String url) {
        Photo photo = new Photo();
        photo.setTitle(name);
        photo = photoRepositorym.save(photo);
        if (null != photo) {
            return ResultUtil.success(photo);
        } else {
            return ResultUtil.error(ResultEnum.unknown_error);
        }
    }

    //删除
    @DeleteMapping(value = "/manage/photo/{id}")
    public Object photoDel(@PathVariable("id") Integer id) {
        try {
            photoRepositorym.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.success();
    }


    //更新
    @PutMapping(value = "/manage/photo/{id}")
    public Object photoUpdat(@PathVariable("id") Integer id,
                             @RequestParam(value = "name", required = false) String name,
                             @RequestParam("url") String url) {
        Photo photo = new Photo();
        photo.setId(id);
        photo.setTitle(name);
        photo = photoRepositorym.save(photo);
        if (null != photo) {
            return ResultUtil.success(photo);
        } else {
            return ResultUtil.error(ResultEnum.unknown_error);
        }

    }


}
