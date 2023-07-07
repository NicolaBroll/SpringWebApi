package com.company.webapi.ditta.exceptions;

import com.company.webapi.config.exceptions.NotFoundException;

public class DittaNotFoundException extends NotFoundException {

    public DittaNotFoundException(int id) {
        super(String.format("Ditta with Id %d not found", id));
    }
}