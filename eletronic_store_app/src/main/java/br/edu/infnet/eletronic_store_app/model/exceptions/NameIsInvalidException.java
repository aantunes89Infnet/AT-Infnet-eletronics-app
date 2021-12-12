package br.edu.infnet.eletronic_store_app.model.exceptions;

public class NameIsInvalidException extends Exception{
    private static final long serialVersionUID = 1L;

    public NameIsInvalidException(String message) {
        super(message);
    }
}

