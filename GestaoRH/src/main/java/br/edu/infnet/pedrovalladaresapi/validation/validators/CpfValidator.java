package br.edu.infnet.pedrovalladaresapi.validation.validators;

import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Pessoa;
import br.edu.infnet.pedrovalladaresapi.validation.annotations.ValidCpf;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<ValidCpf, String>{
    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
        if(cpf == null)
            return false;
        else if(cpf.isEmpty())
            return false;

        return Pessoa.cpfValido(cpf);
    }
}
