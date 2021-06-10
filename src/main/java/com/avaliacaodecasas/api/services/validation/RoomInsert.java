package com.avaliacaodecasas.api.services.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RoomInsertValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RoomInsert {

    String message() default "Erro de validacao";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
