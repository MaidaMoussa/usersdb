package com.example.AngularBackend.services;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Error Response following the format of RFC 7807 .
 */
@Getter
@AllArgsConstructor
public class ErrorResponse {
    /**
     * URI that provide human-readable documentation for the problem.
     */
    private String type;
    /**
     * A short, human-readable summary of the problem.
     */
    private String title;
    /**
     * The HTTP status code.
     */
    private String status;
    /**
     * A human-readable explanation SPECIFIC to this occurrence of the problem.
     */
    private String detail;
    /**
     * URI reference that identifies the specific occurrence of the problem.
     */
    private String instance;
}
