package com.svs.exceptions;

public class ProjectExceptionResponse {

    private String fullName;

    public ProjectExceptionResponse(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
