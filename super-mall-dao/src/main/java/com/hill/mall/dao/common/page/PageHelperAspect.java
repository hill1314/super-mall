package com.hill.mall.dao.common.page;

import com.github.pagehelper.PageHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * PageHelperAspect
 *
 * @Author huleilei9
 * @Date 2022/10/29
 **/
@Component
@Aspect
public class PageHelperAspect {

    @Pointcut("@annotation(com.hill.mall.dao.common.page.ExtPageHelper)")
    public void ServiceImpl() {
    }

    @SuppressWarnings("unchecked")
    @Around("ServiceImpl()")
    public PageDataResult doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 初始化参数
        int page = 0;
        int pageSize = 0;

        // 获得当前访问的class
        Class<?> className = joinPoint.getTarget().getClass();
        // 获得访问的方法名
        String methodName = joinPoint.getSignature().getName();
        // 得到方法的参数的类型
        Class<?>[] argClass = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();

        // 得到方法的参数的类型
        String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        // 获取参数 page 和 pageSize
        Object[] args = joinPoint.getArgs();
        int i = 0;
        for (String pName : parameterNames) {
            if (pName.equals("pageNum")) {
                page = (int) args[i];
            }
            if (pName.equals("pageSize")) {
                pageSize = (int) args[i];
            }
            i++;
        }
        // 设置分页
        PageHelper.startPage(page, pageSize);
        PageDataResult result = null;
        try {
            result = (PageDataResult) joinPoint.proceed();
        } catch (Exception e) {
            throw new RuntimeException("返回类型不为List", e);
        }
        return result;
    }
}
