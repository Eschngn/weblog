package com.swc.weblog.common.aspect;

import java.lang.annotation.*;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/19 10:58
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationLog {
    /**
     * API 功能描述
     *
     * @return
     */
    String description() default "";
}
