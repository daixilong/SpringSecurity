package com.xdl.sys.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/12/19.
 */
@Aspect
@Component
public class WebLogAspect {
    private Logger logger=Logger.getLogger(getClass());

    ThreadLocal<Long> startTime=new ThreadLocal<>();

    /**
     * 定义切点
     */
    @Pointcut("execution (public * com.xdl.sys.controller..*.*(..))")
    public void webLog(){};

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws  Throwable{
       ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=servletRequestAttributes.getRequest();
        startTime.set(System.currentTimeMillis());
        logger.info("URL:"+request.getRequestURI().toString());
        logger.info("HTTP_METHOD:"+request.getMethod());
        logger.info("IP:"+request.getRemoteAddr());
        logger.info("CLASS_METHOD:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("ARDGS:"+ Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public  void  doAfterReturning(Object ret)throws  Throwable{
        logger.info("RESPONSE:"+ret);
        logger.info("SPEND TIME:"+(System.currentTimeMillis()-startTime.get()));
    }
}
