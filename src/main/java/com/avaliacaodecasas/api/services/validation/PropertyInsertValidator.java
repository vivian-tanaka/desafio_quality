package com.avaliacaodecasas.api.services.validation;

import com.avaliacaodecasas.api.entities.Propriedade;
import com.avaliacaodecasas.api.resources.exception.FieldMessage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PropertyInsertValidator implements ConstraintValidator<PropertyInsert, Propriedade> {

    @Override
    public void initialize(PropertyInsert constraintAnnotation) {

    }

    @Override
    public boolean isValid(Propriedade propriedade, ConstraintValidatorContext constraintValidatorContext) {
        if(propriedade.getProp_name().strip() != "" && !Character.isUpperCase(propriedade.getProp_name().charAt(0))){
            FieldMessage error = new FieldMessage("prop_name","O nome da propriedade deve começar com uma letra maiúscula.");

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
