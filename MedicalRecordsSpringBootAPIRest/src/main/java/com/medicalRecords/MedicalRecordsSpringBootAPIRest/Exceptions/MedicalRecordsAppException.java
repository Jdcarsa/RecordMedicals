package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Exceptions;

import org.springframework.http.HttpStatus;

public class MedicalRecordsAppException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private HttpStatus status;
    private String message;

    public MedicalRecordsAppException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public MedicalRecordsAppException(HttpStatus status, String message , String message2) {
        super();
        this.status = status;
        this.message = message;
        this.message = message2;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
