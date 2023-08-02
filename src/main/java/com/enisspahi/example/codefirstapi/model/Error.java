package com.enisspahi.example.codefirstapi.model;

public record Error(ErrorCode code, String message) {

    public enum ErrorCode { UNEXPECTED, NOT_FOUND }
}

