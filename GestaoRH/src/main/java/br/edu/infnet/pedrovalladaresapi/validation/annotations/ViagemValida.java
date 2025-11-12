package br.edu.infnet.pedrovalladaresapi.validation.annotations;

import br.edu.infnet.pedrovalladaresapi.validation.validators.CpfValidator;
import br.edu.infnet.pedrovalladaresapi.validation.validators.ViagemValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ViagemValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ViagemValida {
    String message() default "Deve haver ao menos uma viagem de ida e de volta.";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
