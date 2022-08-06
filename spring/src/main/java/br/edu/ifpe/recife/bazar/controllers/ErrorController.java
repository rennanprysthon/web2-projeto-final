package br.edu.ifpe.recife.bazar.controllers;

import br.edu.ifpe.recife.bazar.exceptions.EntityNotFound;
import br.edu.ifpe.recife.bazar.exceptions.TempoMinimoNaoAtingidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = {EntityNotFound.class})
    public ResponseEntity<HashMap<String, String>> entidadeNaoEncontrada(EntityNotFound entityNotFound) {
        HashMap<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", entityNotFound.getMessage());
        errorResponse.put("timestamp", String.valueOf(new Date().getTime()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(value = {TempoMinimoNaoAtingidoException.class})
    public ResponseEntity<HashMap<String, String>> tempoMinimoNaoAtingidoException(TempoMinimoNaoAtingidoException entityNotFound) {
        HashMap<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", entityNotFound.getMessage());
        errorResponse.put("timestamp", String.valueOf(new Date().getTime()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
