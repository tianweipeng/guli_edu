package com.atguigu.servicebase.exceptionHandler;

import com.atguigu.commonutils.ExceptionToFile;
import com.atguigu.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全局异常");
    }

    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e){
        //e.printStackTrace();
        //输出到日志
        log.error(ExceptionToFile.getMessage(e));
        //log.error("aaa");
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
