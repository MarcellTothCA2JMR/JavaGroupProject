package hu.projekt.hap.application.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = HealthInsuranceNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HealthInsuranceNumberConstraint {

    String message() default "Érvénytelen TAJ-szám!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}