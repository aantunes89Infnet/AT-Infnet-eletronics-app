package br.edu.infnet.eletronic_store_app.model.exceptions;

public class ChipsQuantityIsInvalidException extends Exception {
    private static final long serialVersionUID = 1L;

    public ChipsQuantityIsInvalidException(String message) {
        super(message);
    }
}

