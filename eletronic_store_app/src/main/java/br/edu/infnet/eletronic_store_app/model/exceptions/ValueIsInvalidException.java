package br.edu.infnet.eletronic_store_app.model.exceptions;

public class ValueIsInvalidException extends Exception{
    private static final long serialVersionUID = 1L;

    public ValueIsInvalidException(String message) {
        super(message);
    }
}


