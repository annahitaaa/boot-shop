package com.annahita.bootshop.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ImageValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidImage {
    String message() default "Invalid image: Only JPEG or PNG allowed, max size 5MB";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    boolean optional() default false;
}
