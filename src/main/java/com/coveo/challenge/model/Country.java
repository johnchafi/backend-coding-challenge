package com.coveo.challenge.model;

public enum Country {

    CA("Canada"),
    US("United States");

    private String fullName;

    Country(String fullName) {
        this.fullName = fullName;
    }
}
