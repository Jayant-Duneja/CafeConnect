package com.Cockroach.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    protected ResponseEntity<String> createSuccessResponse(String message) {
        return ResponseEntity.ok(message);
    }

    protected ResponseEntity<String> createNotFoundResponse() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    protected ResponseEntity<String> createErrorResponse(String message, HttpStatus status) {
        return ResponseEntity.status(status).body(message);
    }
}
