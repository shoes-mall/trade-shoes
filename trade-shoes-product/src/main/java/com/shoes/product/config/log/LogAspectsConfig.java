package com.shoes.product.config.log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: wx
 * @date: 2020/05/13 16:20
 * @description: 日志配置
 */
@Aspect
@Component
public class LogAspectsConfig {

    private final static Logger logger = LoggerFactory.getLogger(LogAspectsConfig.class);

    private final String POINT_CUT = "execution(public * com.shoes.product.controller.*.*(..))";

    /**
     * 定义切入点
     * 1、execution 表达式主体
     * 2、第1个* 表示返回值类型  *表示所有类型
     * 3、包名  com.*.*.controller下
     * 4、第4个* 类名，com.*.*.controller包下所有类
     * 5、第5个* 方法名，com.*.*.controller包下所有类所有方法
     * 6、(..) 表示方法参数，..表示任何参数
     */
    @Pointcut(POINT_CUT)
    public void pointCut() {
    }

    /**
     * 方法进入前请求
     *
     * @param joinPoint
     */
    @Before(value = "pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("----开始请求-----------");
        logger.info("请求url = {}", request.getRequestURI());
        logger.info("请求的控制器方法method = {}", request.getMethod());
        logger.info("请求的ip = {}", request.getRemoteAddr());
        logger.info("请求类名 = {}", joinPoint.getSignature().getDeclaringTypeName());
        logger.info("请求方法名class_method = {}", joinPoint.getSignature().getName());
        try {
            // 拦截敏感参数，进行脱敏加密处理
            String args = JSONObject.toJSONString(joinPoint.getArgs());
            args = args.replaceAll("password\":\"[0-9a-zA-Z]+\"", "password\":\"******\"");
            logger.info("请求的相关参数 = {}", args);
        } catch (Exception e) {
            logger.info("请求参数异常：{}", e.getMessage());
        }
    }

    /**
     * 后置返回
     * 如果第一个参数为JoinPoint，则第二个参数为返回值的信息
     * 如果第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     * returning：限定了只有目标方法返回值与通知方法参数类型匹配时才能执行后置返回通知，否则不执行，
     * 参数为Object类型将匹配任何目标返回值
     */
    @AfterReturning(value = POINT_CUT, returning = "result")
    public void doAfterReturningAdvice1(JoinPoint joinPoint, Object result) {
        logger.info("第一个后置返回通知的返回值：{}", result);
        try {
            logger.info("返回方法名：{} <=====> 返回参数信息：{}", joinPoint.getSignature().getName(), JSON.toJSONString(result));
        } catch (Exception e) {
            logger.info("返回参数有异常：{}", e.getMessage());
            logger.info("返回参数有异常：{}", e);
        }
    }

    @After(value = POINT_CUT)
    public void doAfterAdvice(JoinPoint joinPoint) {
        logger.info("后置通知执行：{} ", joinPoint);
    }

    /**
     * 后置异常通知
     * 定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     * throwing:限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     * 对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
     *
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = POINT_CUT, throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        logger.info("后置异常通知：{}", joinPoint.getSignature().getName());
        logger.info("后置异常通知：{}", exception.getMessage());
        if (exception instanceof NullPointerException) {
            logger.info("发生了空指针异常，请检查");
        }
    }

    /**
     * 耗时统计
     * 环绕通知：
     * 注意:Spring AOP的环绕通知会影响到AfterThrowing通知的运行,不要同时使用
     * <p>
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = POINT_CUT)
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("@Around环绕通知：{}", joinPoint.getSignature().toString());

        long startTime = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            logger.info("响应时间 distributionTime = {} ms", (endTime - startTime));
            return result;
        } catch (Throwable e) {
            long endTime = System.currentTimeMillis();
            logger.info("响应时间 distributionTime = {} ms", (endTime - startTime));
            throw e;
        }
    }
}
