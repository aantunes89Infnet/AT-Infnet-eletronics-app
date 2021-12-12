package br.edu.infnet.eletronic_store_app.model.exceptions;

public class QuantityIsInvalidException extends Exception {
    private static final long serialVersionUID = 1L;

    public QuantityIsInvalidException(String message) {
        super(message);
    }
}
