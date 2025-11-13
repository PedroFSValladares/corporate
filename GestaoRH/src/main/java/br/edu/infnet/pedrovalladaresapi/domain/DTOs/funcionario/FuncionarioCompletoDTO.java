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

public class FuncionarioCompletoDTO {
    private String Nome;
    private String Matricula;
    private String CPF;
    private String Email;
    private String Telefone;
    private Integer CargoId;
    private boolean Ativo;
    private List<Viagem> viagens;
    private Endereco endereco;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
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

    public Integer getCargoId() {
        return CargoId;
    }

    public void setCargoId(Integer cargoId) {
        CargoId = cargoId;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isAtivo() {
        return Ativo;
    }

    public void setAtivo(boolean ativo) {
        Ativo = ativo;
    }
}
