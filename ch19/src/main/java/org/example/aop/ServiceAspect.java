package org.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class ServiceAspect {
    /**
     * 切入点表达式
     */
    @Pointcut("execution(* org.example.User.*(..))")
    public void pointcut() {
    }

    /**
     * 自定义前置通知，可以给一个参数
     * 这个参数为连接点
     * 通过这个连接点可以拦截目标方法的参数等信息
     *
     * @param jp
     */
    // 设置切入点
    @Before("pointcut()")
    public void before(JoinPoint jp) {
        log.info("自定义前置通知,参数" + jp.getArgs());
//        jp.getArgs()[0] = "修改参数";
    }

    /**
     * 后置通知
     *
     * @param jp          连接点
     * @param returnValue 目标方法的返回值
     */
    @AfterReturning(value="pointcut()",returning = "returnValue")
    public void afterReturning(JoinPoint jp, Object returnValue) {
        log.info("后置通知,参数" + jp.getArgs());
        log.info("返回值" + returnValue);
    }

    /**
     * 环绕通知
     *
     * @param jp 连接点，继承自 JoinPoint 接口
     * @return
     */
    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        log.info("环绕");
        return jp.proceed();
    }

    /**
     * 异常通知，当目标方法产生异常时会执行
     * 后置通知或者(方法执行后执行的通知)都不会生效
     * 除了最终通知
     *
     * @param jp
     * @param e
     */
    @AfterThrowing(value = "pointcut()",throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        log.info("异常" + e.getMessage());
    }

    /**
     * 最终通知，不管有没有异常产生，都会执行
     *
     * @param jp
     */
    @After("pointcut()")
    public void after(JoinPoint jp) {
        log.info("最终通知");
    }
}
