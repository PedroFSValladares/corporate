package br.edu.infnet.pedrovalladaresapi.domain.DTOs.funcionario;

import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Endereco;
import br.edu.infnet.pedrovalladaresapi.domain.models.transporte.Viagem;
import br.edu.infnet.pedrovalladaresapi.validation.annotations.ViagemValida;
import jakarta.validation.constraints.*;

import java.util.List;

public class AlterarFuncionarioDTO {
    @NotEmpty(message = "O campo nome deve ser informado.")
    private String Nome;
    @NotEmpty(message = "O campo e-mail deve ser informado.")
    @Email(message = "O e-mail informado não é válido.")
    private String Email;
    @NotEmpty(message = "O campo telefone deve ser informado.")
    @Size(min = 10, max = 11, message = "O Numero de telefone informado é inválido.")
    private String Telefone;
    @NotNull(message = "O campo cargo deve ser informado.")
    private Integer CargoId;
    @NotNull(message = "O endereço deve ser informado.")
    private Endereco endereco;
    @ViagemValida
    private List<Viagem> viagens;
    private Boolean ativo;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public Integer getCargoId() {
        return CargoId;
    }

    public void setCargoId(Integer cargoId) {
        CargoId = cargoId;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
