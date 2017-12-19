package com.xdl.sys.exception;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/12/19.
 */

/**
 * 定义全局的异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private  static  final String DEFAULT_ERROR_VIEW="error";

    @ExceptionHandler
    public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e){
        ModelAndView mvn=new ModelAndView();
        mvn.addObject("exception",e);
        mvn.addObject("url",request.getRequestURI());
        mvn.setViewName(DEFAULT_ERROR_VIEW);
        return  mvn;
    }

    @ExceptionHandler
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request,Exception e) throws Exception{
        ErrorInfo<String> string=new ErrorInfo<>();
        string.setMessage(e.getMessage());
        string.setCode(ErrorInfo.ERROR);
        string.setData("some data");
        string.setUrl(request.getRequestURL().toString());
        return string;
    }

}
