package br.edu.infnet.eletronic_store_app.model.exceptions;

public class BatteryAutonomyIsInvalidException extends Exception {
    private static final long serialVersionUID = 1L;

    public BatteryAutonomyIsInvalidException(String message) {
        super(message);
    }
}

