package br.edu.infnet.pedrovalladaresapi.exceptions;

public class EmailInvalidoException extends RuntimeException {
    public EmailInvalidoException(String message) {
        super(message);
    }
}
