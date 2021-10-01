package com.caiodev.FreightCalculation.controller.exception;

import com.caiodev.FreightCalculation.exceptions.AddressNotFoundException;
import com.caiodev.FreightCalculation.exceptions.FreightNotFoundException;
import com.caiodev.FreightCalculation.exceptions.InvalidFormatZipCodeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(FreightNotFoundException.class)
    public ResponseEntity<StandardError> freightNotFound(FreightNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<StandardError> addressNotFound(AddressNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    @ExceptionHandler(InvalidFormatZipCodeException.class)
    public ResponseEntity<StandardError> invalidFormatZipCode(InvalidFormatZipCodeException e, HttpServletRequest request){
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(),"Cep Inválido",System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e,HttpServletRequest request){

        ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(),"Erro de validação",System.currentTimeMillis());
        for(FieldError x : e.getBindingResult().getFieldErrors()){
            err.addError(x.getField(),x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }


}
