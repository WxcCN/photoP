package com.photop.aspect;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bjwangxingchen on 2017/11/29.
 */
@Aspect
@Component
public class HttpAspect {

   private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class) ;

    @Pointcut("execution (public * com.photop.controller.admin.*.*(..))")
    public void login(){
    }

   @Before("login()")
   public void doBefore(JoinPoint joinPoint){
       ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       HttpServletRequest request = attributes.getRequest();
       logger.info("url={}",request.getRequestURI());
       logger.info("method={}",request.getRemoteAddr());
       logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
       logger.info("arg{}",joinPoint.getArgs());
       System.out.println("??");
   }
}
