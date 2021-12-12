package br.edu.infnet.eletronic_store_app.model.exceptions;

public class ProductListIsInvalidException extends Exception {
    private static final long serialVersionUID = 1L;

    public ProductListIsInvalidException(String message) {
        super(message);
    }
}
