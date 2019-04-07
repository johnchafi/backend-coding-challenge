package com.coveo.challenge.model;

public enum Province {

    ALBERTA("01","Alberta"),
    BRITISH_COLUMBIA("02","British Columbia"),
    MANITOBA("03", "Manitoba"),
    NEW_BRUNSWICK("04","New Brunswick"),
    NEWFOUNDLAND_AND_LABRADOR("05","Newfoundland and Labrador"),
    NORTHWEST_TERRITORIES("13","Northwest Territories"),
    NOVA_SCOTIA("07","Nova Scotia"),
    NUNAVUT("14","Nunavut"),
    ONTARIO("08","Ontario"),
    PRINCE_EDWARD_ISLAND("09","Prince Edward Island"),
    QUEBEC("10","Quebec"),
    SASKATCHEWAN("11","Saskatchewan"),
    YUKON("12","Yukon");

    private String code;
    private String fullName;

    Province(String code, String fullName) {
        this.fullName = fullName;
    }

}
