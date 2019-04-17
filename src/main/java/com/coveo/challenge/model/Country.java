package com.coveo.challenge.model;

import lombok.Getter;

@Getter
public enum Country {

    CA("CA", "Canada"),
    US("US", "United States");

    private final String code;
    private final String fullName;

    Country(String code, String fullName) {
        this.code = code;
        this.fullName = fullName;
    }
}
