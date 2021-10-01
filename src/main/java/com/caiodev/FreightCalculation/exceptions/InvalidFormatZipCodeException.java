package com.caiodev.FreightCalculation.exceptions;

public class InvalidFormatZipCodeException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public InvalidFormatZipCodeException(String msg){
        super(msg);
    }

}
