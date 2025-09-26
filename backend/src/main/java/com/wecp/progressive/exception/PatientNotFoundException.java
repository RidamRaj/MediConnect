package com.wecp.progressive.exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        super(message);
    }
}