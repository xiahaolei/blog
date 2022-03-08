package com.xiahl.blog.aspect;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

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
    public void doBefore(JoinPoint point) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
        Object[] args = point.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        log.info("Request : {}", requestLog);
    }


    @Before("log()")
    public void doAfter() {
    }


    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result) {
        log.info("Result {}", result);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    private class RequestLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
    }
}
