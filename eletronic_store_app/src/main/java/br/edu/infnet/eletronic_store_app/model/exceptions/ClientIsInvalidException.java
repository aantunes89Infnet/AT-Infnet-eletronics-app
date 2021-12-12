package br.edu.infnet.eletronic_store_app.model.exceptions;

public class ClientIsInvalidException extends Exception {
    private static final long serialVersionUID = 1L;

    public ClientIsInvalidException(String message) {
        super(message);
    }
}
