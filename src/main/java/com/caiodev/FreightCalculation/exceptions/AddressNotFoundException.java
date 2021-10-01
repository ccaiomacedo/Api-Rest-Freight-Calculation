package com.caiodev.FreightCalculation.exceptions;

public class AddressNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public AddressNotFoundException(String msg){
        super(msg);
    }
}
