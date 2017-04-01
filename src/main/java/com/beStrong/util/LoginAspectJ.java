package com.beStrong.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by roy on 2017/3/24.
 */
@Order(1)
@Aspect
@Component
public class LoginAspectJ {

    @Before("execution(* com.beStrong.controller.UserLoginController.*(..))")
    public void validateAgs(JoinPoint joinPoint){
        System.out.println("Aop");
        System.out.println("方法名:"+joinPoint.getSignature().getName()+"参数:"+ joinPoint.getArgs());
    }
}
