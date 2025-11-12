package br.edu.infnet.pedrovalladaresapi.domain.DTOs.funcionario;

import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Endereco;
import br.edu.infnet.pedrovalladaresapi.domain.models.transporte.Viagem;
import br.edu.infnet.pedrovalladaresapi.validation.annotations.ValidCpf;
import br.edu.infnet.pedrovalladaresapi.validation.annotations.ViagemValida;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class IncluirFuncionarioDTO {
    @NotEmpty(message = "O campo nome deve ser informado.")
    private String Nome;
    //@Convert(converter = CpfConverter.class)
    @NotNull(message = "O campo CPF deve ser informado.")
    @ValidCpf
    private String CPF;
    @NotEmpty(message = "O campo e-mail deve ser informado.")
    @Email(message = "O e-mail informado não é válido.")
    private String Email;
    @NotEmpty(message = "O campo telefone deve ser informado.")
    @Size(min = 10, max = 11, message = "O Numero de telefone informado é inválido.")
    private String Telefone;
    @NotNull(message = "O campo cargo deve ser informado.")
    private Integer CargoId;
    @ViagemValida
    private List<Viagem> viagens;
    @NotNull(message = "O Endereço deve ser informado.")
    private Endereco endereco;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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

    public int getCargoId() {
        return CargoId;
    }

    public void setCargoId(int cargoId) {
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
}
