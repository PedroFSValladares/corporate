package br.edu.infnet.pedrovalladaresapi.domain.models.frequencia;

import java.time.LocalDate;
import java.time.LocalTime;

public class DiaUtil {
    private LocalDate data;
    private LocalTime entrada;
    private LocalTime saida;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalTime entrada) {
        this.entrada = entrada;
    }

    public LocalTime getSaida() {
        return saida;
    }

    public void setSaida(LocalTime saida) {
        this.saida = saida;
    }
}
