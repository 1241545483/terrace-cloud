package com.synapse.reading.web.valid.group;

import java.lang.annotation.*;

/**
 * Created by wangyifan on 17-9-16.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Dict {
    /**
     * 关联的字段name
     *
     * @return
     */
    String value() default "";
}
