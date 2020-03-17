package com.giserway.restapi.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/** 自定义Sex校验类 */
                                                /** 自定义Sex注解 */
public class SexValid implements ConstraintValidator<Sex, String> {

    private Set<String> sexEnum = new HashSet<>(2);

    /** 初始化通过的值 */
    @Override
    public void initialize(Sex sex) {
        for (String i : sex.sexEnum()){
            sexEnum.add(i);        /** 初始化校验值 */
        }
    }

    /** 校验方法（逻辑）
        @param: value
        @param: context
        @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return sexEnum.contains(value);
    }
}
