package com.chuan.handlerinterceptor.springbootinterceptor.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface UserAuthenticate {

    /**
     * 是否需要校验访问权限 默认不校验
     *
     * @return
     */
    boolean permission() default false;
}
