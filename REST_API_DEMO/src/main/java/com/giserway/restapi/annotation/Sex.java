package com.giserway.restapi.annotation;

import org.springframework.context.annotation.Configuration;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/** sex自定义注解
 */

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = SexValid.class) /** 指定校验类 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
public @interface Sex {

    String message() default "性别不合法";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    /** 允许值（默认：1-男，2-女）. 若使用方的性别枚举不同，可以通过该字段指定校验通过的值
        @return
     */
    String[] sexEnum() default {"1","2"};

}
