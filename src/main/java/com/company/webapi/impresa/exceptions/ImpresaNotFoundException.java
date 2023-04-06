package com.company.webapi.impresa.exceptions;

public class ImpresaNotFoundException extends RuntimeException {

    public ImpresaNotFoundException(int id) {
        super(String.format("Impresa with Id %d not found", id));
    }
}