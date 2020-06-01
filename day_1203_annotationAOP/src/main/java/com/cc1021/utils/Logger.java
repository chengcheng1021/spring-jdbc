package com.cc1021.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 *  用于记录日志的工具类，它里面提供了公共的代码
 */
@Component("logger")
@Aspect//表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(* com.cc1021.service.impl.*.*(..))")
    private void ptl(){}
//    /**
//     *  前置通知
//     */
//    @Before("ptl()")
//    public void beforePrintLog(){
//        System.out.println("前置通知Logger 类中的 beforePrintLog 方法开始记录日志了。。。");
//    }
//
//    /**
//     *  后置通知
//     */
//    @AfterReturning("ptl()")
//    public void afterReturningPrintLog(){
//        System.out.println("后置通知Logger 类中的 afterReturningPrintLog 方法开始记录日志了。。。");
//    }
//
//    /**
//     *  异常通知
//     */
//    @AfterThrowing("ptl()")
//    public void afterThrowingPrintLog(){
//        System.out.println("异常通知Logger 类中的 afterThrowingPrintLog 方法开始记录日志了。。。");
//    }
//
//    /**
//     *  最终通知
//     */
//    @After("ptl()")
//    public void afterPrintLog(){
//        System.out.println("最终通知Logger 类中的 afterPrintLog 方法开始记录日志了。。。");
//    }

    /**
     *  环绕通知
     *  问题：
     *      当我们配置了环绕通知后，切入点方法没有执行，而通知方法执行了。
     *  分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们代码中没有。
     *  解决：
     *      Spring 框架为我们实现了一个接口，ProceedingJoinPoint。该接口有一个方法 proceed()，此方法就相当于明确调用切入点方法
     *      该接口可以作为环绕通知的方法参数，在程序执行时，Spring 框架会为我们提供该接口的实现类供我们使用。
     *
     *  Spring 中的环绕通知：
     *      它是 Spring 框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */
    @Around("ptl()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需的参数

            System.out.println("Logger 类中的 aroundPrintLog 方法开始记录日志了。。。前置");

            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）

            System.out.println("Logger 类中的 aroundPrintLog 方法开始记录日志了。。。后置");

            return rtValue;
        } catch (Throwable t) {
            System.out.println("Logger 类中的 aroundPrintLog 方法开始记录日志了。。。异常");

            throw new RuntimeException(t);
        } finally {
            System.out.println("Logger 类中的 aroundPrintLog 方法开始记录日志了。。。最终");
        }
    }
}
