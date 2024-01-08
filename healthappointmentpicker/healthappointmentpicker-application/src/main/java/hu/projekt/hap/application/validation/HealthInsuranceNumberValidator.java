package hu.projekt.hap.application.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HealthInsuranceNumberValidator implements ConstraintValidator<HealthInsuranceNumberConstraint, String> {

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext ctx) {
        return contactField != null &&
                contactField.matches("(\\d{3}) (\\d{3}) (\\d{3})");
    }
}
