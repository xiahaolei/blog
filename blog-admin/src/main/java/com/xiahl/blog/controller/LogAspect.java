package com.xiahl.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/3/3 1:10
 * @Desc
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.xiahl.blog.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore() {
        log.info("------------------------doBefore----------------");
    }


    @Before("log()")
    public void doAfter() {
        log.info("------------------------doAfter---------------");
    }


    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result){
        log.info("Result {}" ,result);
    }
}
