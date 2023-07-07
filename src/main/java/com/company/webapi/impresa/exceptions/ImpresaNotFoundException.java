package com.company.webapi.impresa.exceptions;

import com.company.webapi.config.exceptions.NotFoundException;

public class ImpresaNotFoundException extends NotFoundException {

    public ImpresaNotFoundException(int id) {
        super(String.format("Impresa with Id %d not found", id));
    }
}