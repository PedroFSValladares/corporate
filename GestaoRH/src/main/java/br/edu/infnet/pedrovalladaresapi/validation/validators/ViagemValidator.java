package br.edu.infnet.pedrovalladaresapi.validation.validators;

import br.edu.infnet.pedrovalladaresapi.domain.enuns.TipoViagem;
import br.edu.infnet.pedrovalladaresapi.domain.models.transporte.Viagem;
import br.edu.infnet.pedrovalladaresapi.validation.annotations.ViagemValida;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class ViagemValidator implements ConstraintValidator<ViagemValida, List<Viagem>> {
    @Override
    public boolean isValid(List<Viagem> viagens, ConstraintValidatorContext constraintValidatorContext) {
        if(!viagens.isEmpty())
            return viagens.stream().anyMatch(v -> v.getTipoViagem() == TipoViagem.ida) && viagens.stream().anyMatch(v -> v.getTipoViagem() == TipoViagem.volta);
        return true;
    }
}
