package com.hill.mall.dao.common.page;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//整合mybatis分页插件
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface ExtPageHelper {
    int pageSize() default 20;
}
