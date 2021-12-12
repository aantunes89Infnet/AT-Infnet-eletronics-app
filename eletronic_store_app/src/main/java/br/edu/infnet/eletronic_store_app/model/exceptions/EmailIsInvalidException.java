package br.edu.infnet.eletronic_store_app.model.exceptions;

public class EmailIsInvalidException extends Exception {
    private static final long serialVersionUID = 1L;

    public EmailIsInvalidException(String message) {
        super(message);
    }
}
