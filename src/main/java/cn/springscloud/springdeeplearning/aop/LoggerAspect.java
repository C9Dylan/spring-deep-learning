package cn.springscloud.springdeeplearning.aop;

import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Kim QQ.Cong on 2019-09-04 / 11:22
 *
 * @author: CongQingquan
 * @Description: 切面类
 */
@Aspect
public class LoggerAspect {

    /**
     * 例： execution (* com.sample.service..*. *(..))
     *
     * 整个表达式可以分为五个部分：
     *
     * 1、execution():：表达式主体。
     *
     * 2、第一个*号：表示返回类型， *号表示所有的类型。
     *
     * 3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service包、子孙包下所有类的方法。
     *
     * 4、第二个*号：表示类名，*号表示所有的类。
     *
     * 5、*(..)：最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
     */

    @Pointcut("execution(public Integer cn.springscloud.springdeeplearning.aop.bean.MathCalculator.*(..))")
    public void commonPointcut(){}

    /**
     * 特别注意: JoinPoint一定要放在形参的第一位, 否则会抛出异常
     */

//    @Before("commonPointcut()")
    public void beforeMethod(JoinPoint joinPoint) {
        printJoinPoint(joinPoint, "before");
    }

//    @After("commonPointcut()")
    public void afterMethod(JoinPoint joinPoint) {
        printJoinPoint(joinPoint, "after");
    }

    /**
     * 特别注意:
     *      @AfterReturning: 如果returning注解值映射的参数的参数类型与实际执行函数返回的类型不一致, 则不会执行该增强函数
     */
    @AfterReturning(value = "commonPointcut()", returning = "retVal")
    public void afterReturningMethod(JoinPoint joinPoint, Object retVal) {
        System.out.println("logger aspect after returning method execute, return value: " + retVal);
    }

    @AfterThrowing(value = "commonPointcut()", throwing = "exception")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable exception) {
        System.out.println("logger aspect after throwing method execute, throw exception: " + exception);
    }

    @Around("commonPointcut()")
    public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("logger aspect around method begin.");
        Object proceedResult = proceedingJoinPoint.proceed();
        System.out.println("proceed result is: " + proceedResult);
        System.out.println("logger aspect around method end.");
    }

    private void printJoinPoint(JoinPoint joinPoint, String type) {
        // 1. 方法签名
        Signature signature = joinPoint.getSignature();
        // 2. 方法参数
        Object[] methodArgs = joinPoint.getArgs();
        // 3. 代理类
        Object aThis = joinPoint.getThis();
        System.out.println(type + ": method name: " + signature.getName() + ", argument is: " + ArrayUtils.toString(methodArgs));
    }

    /**
     * 总结:
     *      1. 执行顺序
     *          1) 正常: before -> after -> after returning
     *          2) 异常: before -> after -> after throwing
     *
     *      2. 使用搭配:
     *          1) @Before - @After - @AfterReturning - @AfterThrowing
     *          2) @Around - @AfterReturning - @AfterThrowing
     */
}