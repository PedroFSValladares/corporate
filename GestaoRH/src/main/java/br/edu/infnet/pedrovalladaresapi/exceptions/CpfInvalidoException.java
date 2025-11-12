package br.edu.infnet.pedrovalladaresapi.exceptions;

public class CpfInvalidoException extends RuntimeException{
    public CpfInvalidoException(String mensagem){
        super(mensagem);
    }
}
