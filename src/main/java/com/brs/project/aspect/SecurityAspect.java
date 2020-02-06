package com.brs.project.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/***
 * Unused
 */

@Aspect
@Component
public class SecurityAspect {
    private String token;

    //@Pointcut(" execution (* com.brs.project.user.controller.UserController.*(..))")
    @Pointcut("execution(* com.brs.project.user.controller.UserController.doGetUserDetailRsApi(*))")
    public void userDoGetUserDetailRsApiPointCut() {}

    @Before("userDoGetUserDetailRsApiPointCut()")
    public void doCheckSession() throws Exception {
        System.out.print("TEST");
    }

    @After("userDoGetUserDetailRsApiPointCut()")
    public void doSession() throws Exception{

    }
}
