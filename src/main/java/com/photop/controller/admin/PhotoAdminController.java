package com.photop.controller.admin;

import com.photop.dao.Photo;
import com.photop.dao.repositoty.PhotoRepositorym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bjwangxingchen on 2017/11/29.
 */

@RestController
public class PhotoAdminController {

    @Autowired
    private PhotoRepositorym photoRepositorym;
    //插入一个照片集
    @PostMapping(value = "/manage/photo")
    public String photoAdd(@RequestParam(value = "name", required = false) String name,
                           @RequestParam("url") String url) {
        Photo photo = new Photo();
        photo.setUrls(url);
        photo.setTitle(name);
        photo = photoRepositorym.save(photo);
        if (null != photo)
            return "success: id=" + photo.getId();
        else return "hehe";
    }

    //删除
    @DeleteMapping(value = "/manage/photo/{id}")
    public String photoDel(@PathVariable("id") Integer id) {
        try {
            photoRepositorym.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }


    //更新
    @PutMapping(value = "/manage/photo/{id}")
    public String photoUpdat(@PathVariable("id") Integer id,
                             @RequestParam(value = "name", required = false) String name,
                             @RequestParam("url") String url) {
        Photo photo = new Photo();
        photo.setId(id);
        photo.setUrls(url);
        photo.setTitle(name);
        photo = photoRepositorym.save(photo);
        if (null != photo)
            return "success: id=" + photo.getId();
        else return "hehe";
    }
}
