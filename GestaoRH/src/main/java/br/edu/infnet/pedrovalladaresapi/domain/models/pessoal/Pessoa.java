package br.edu.infnet.pedrovalladaresapi.domain.models.pessoal;

import br.edu.infnet.pedrovalladaresapi.validation.annotations.ValidCpf;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

    @Id
    @Column(name = "cpf", length = 11, unique = true)
    private String Cpf;
    @Column(name = "email")
    private String Email;
    @Column(name = "nome")
    private String Nome;
    @Column(name = "telefone", length = 11)
    private String Telefone;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cep")
    private Endereco Endereco;


    @Override
    public String toString(){
        return String.format("Nome: %s | CPF: %s | Email: %s | Telefone: %s | %s",
                Nome, Cpf, Email, Telefone, Endereco.toString());
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        this.Cpf = cpf;
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

    public Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(Endereco endereco) {
        Endereco = endereco;
    }

    public static Boolean cpfValido(String cpf){
        int primeiroDigitoVerificador,
                segundoDigitoVerificador;
        String digitosVerificadoresOriginais = cpf.substring(9),
                digitoVerificadorFinal;

        char[] temp = new char[9];

        cpf.getChars(0, 9, temp, 0);
        primeiroDigitoVerificador = calcularDigitoVerificador(temp);

        temp = new char[10];
        cpf.getChars(0, 9, temp, 0);
        temp[9] = Character.forDigit(primeiroDigitoVerificador, 10);

        segundoDigitoVerificador = calcularDigitoVerificador(temp);

        digitoVerificadorFinal = String.valueOf(primeiroDigitoVerificador) + String.valueOf(segundoDigitoVerificador);

        return digitosVerificadoresOriginais.equals(digitoVerificadorFinal);
    }

    private static int calcularDigitoVerificador(char[] caracteres){
        int somatorio = 0,
                digitoVerificador;
        int[] sequencia = new int[caracteres.length];

        for(int i = 0; i < caracteres.length; i++)
            sequencia[i] = Character.getNumericValue(caracteres[i]);


        for(int i = 0,  peso = sequencia.length + 1; i < sequencia.length; i++, peso--){
            somatorio += sequencia[i] * peso;
        }

        int restoPrimeiraDivisao = somatorio % 11;
        digitoVerificador = restoPrimeiraDivisao < 2 ? 0 : 11 - restoPrimeiraDivisao;

        return digitoVerificador;
    }
}
