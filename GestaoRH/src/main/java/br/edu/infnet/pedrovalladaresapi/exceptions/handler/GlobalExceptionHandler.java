package br.edu.infnet.pedrovalladaresapi.exceptions.handler;

import br.edu.infnet.pedrovalladaresapi.requests.RequestResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLDataException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RequestResponse> handleException(Exception e){
        return RequestResponse.getByCode(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro inesperado no servidor: " + e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RequestResponse> handleMethodNotValidException(MethodArgumentNotValidException e){
        Map<String, String> mapa = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach((erro) -> {
            var nomeDoCampo = ((FieldError) erro).getField();
            var mensagem = erro.getDefaultMessage();
            mapa.put(nomeDoCampo, mensagem);
        });
        
        return RequestResponse.getByCode(HttpStatus.BAD_REQUEST, mapa);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<RequestResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        return RequestResponse.getByCode(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RequestResponse> handleConstraintViolationException(ConstraintViolationException e){
        var violation = e.getConstraintViolations();
        var violations = violation.stream().map(ConstraintViolation::getMessage).toList();
        return RequestResponse.getByCode(HttpStatus.BAD_REQUEST, violations);
    }
}
