package com.photop.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 照片集类
 *
 * @auther Nova wangxingchen
 * @create 17/11/27
 */
@Entity
public class Photo {
    @Id
    @GeneratedValue
    private Integer id;
    private String urls;
    //照片集名字
    private String title = "unnamed";
    //浏览数
//    @Column(columnDefinition = "I")
    private Integer viewNum = 0;

    public Photo() {
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }


    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }
}
