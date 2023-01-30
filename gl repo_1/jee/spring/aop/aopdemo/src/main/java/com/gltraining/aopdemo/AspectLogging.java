package com.gltraining.aopdemo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class AspectLogging {

    @Before("execution(* Calculator.*(..))")
    public void beforeAdvice(JoinPoint point){
        System.out.println("inside before advice");
        Signature signature=point.getSignature();
        String name=signature.getName();
        Object[] args=point.getArgs();
        List<Object> list= Arrays.asList(args);
        System.out.println("inside method "+name+" args="+list);
    }

    @AfterReturning(value = "execution(* Calculator.*(..))" ,returning = "result")
    public void afterReturningAdvice(JoinPoint point, Object result){
        System.out.println("inside afterreturning advice");
        Signature signature=point.getSignature();
        String name=signature.getName();
        Object[] args=point.getArgs();
        List<Object> list= Arrays.asList(args);
        System.out.println("returned successfully method= "+name+" args="+list+" result="+result);

    }




    @AfterThrowing(value = "execution(* Calculator.*(..))",throwing = "ex")
    public void afterThrowingAdvice(JoinPoint point, Exception ex ){
        System.out.println("inside afterThrowingAdvice advice");
        Signature signature=point.getSignature();
        String name=signature.getName();
        Object[] args=point.getArgs();
        List<Object> list= Arrays.asList(args);
        System.out.println("returned successfully method= "+name+" args="+list);
        System.out.println("exception thown is "+ex.getMessage());
        ex.printStackTrace();
    }

/*
    @Around(value = "execution(* Calculator.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint point) throws  Throwable{
        System.out.println("inside around advice");
        Signature signature=point.getSignature();
        String name=signature.getName();
        Object[] args=point.getArgs();
        List<Object> list= Arrays.asList(args);
        System.out.println("before execution= "+name+" args="+list);

        Object result =point.proceed(args);
        System.out.println("result after method executed="+result);
         return result;
    }
*/


}
