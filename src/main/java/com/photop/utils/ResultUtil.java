package com.photop.utils;


import com.photop.dao.Result;
import com.photop.enums.ResultEnum;

/**
 * 响应统一封装
 * Created by bjwangxingchen on 2017/11/29.
 */
public class ResultUtil {

    private static Integer SUCCESS = 0;
    private static String SUCCESS_msg = "成功";
    public static Result success(Object object){
        return new Result(SUCCESS,SUCCESS_msg,object);
    }
    public static Result success(){
        return success(null);
    }

    public static Result error (Integer code , String msg){
        return new Result(code,msg,null);
    }
    public static Result error (ResultEnum resultEnum){
        return new Result(resultEnum.getCode(),resultEnum.getMsg(),null);
    }

}
