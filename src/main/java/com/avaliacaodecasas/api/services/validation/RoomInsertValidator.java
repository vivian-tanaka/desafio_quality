package com.avaliacaodecasas.api.services.validation;

import com.avaliacaodecasas.api.entities.Comodo;
import com.avaliacaodecasas.api.resources.exception.FieldMessage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoomInsertValidator implements ConstraintValidator<RoomInsert, Comodo> {
    @Override
    public void initialize(RoomInsert constraintAnnotation) {

    }

    @Override
    public boolean isValid(Comodo comodo, ConstraintValidatorContext constraintValidatorContext) {
        if(comodo.getRoom_name().strip() != "" && !Character.isUpperCase(comodo.getRoom_name().charAt(0))){
            FieldMessage error = new FieldMessage("room_name","O nome do cômodo deve começar com uma letra maiúscula.");

            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate(error.getMessage())
                    .addPropertyNode(error.getFieldName())
                    .addConstraintViolation();

            return false;
        }

        return true;
    }
}
