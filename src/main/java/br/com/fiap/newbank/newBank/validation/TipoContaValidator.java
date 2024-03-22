package br.com.fiap.newbank.newBank.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoContaValidator implements ConstraintValidator<TipoConta,String>{
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        return value.equals("Corrente") || value.equals("Poupança") || value.equals("Salario");
    }
    
}
