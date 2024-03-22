package br.com.fiap.newbank.newBank.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(FIELD)
@Constraint(validatedBy = TipoContaValidator.class)
@Retention(RUNTIME)
public @interface TipoConta {
    String message() default "Tipo invalido. Tipo deve ser Corrente, Poupança ou Salário";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    
}
