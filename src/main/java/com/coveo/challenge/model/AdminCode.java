package com.coveo.challenge.model;

import lombok.Getter;

@Getter
public enum AdminCode {

    // FIXME: configuration in application.yaml ?

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
    YUKON("12","Yukon"),
    ARKANSAS("AR", "Arkansas"),
    WASHINGTON_DC("DC", "Washington, D."),
    DELAWARE("DE", "Delaware"),
    FLORIDA("FL", "Florida"),
    GEORGIA("GA", "Georgia"),
    KANSAS("KS", "Kansas"),
    LOUISIANA("LA", "Louisiana"),
    MARYLAND("MD", "Maryland"),
    MISSOURI("MO", "Missouri"),
    MISSISSIPPI("MS", "Mississippi"),
    NORTH_CAROLIN("ANC", "North Carolina"),
    OKLAHOMA("OK", "Oklahoma"),
    SOUTH_CAROLIN("ASC", "South Carolina"),
    TENNESSEE("TN", "Tennessee"),
    TEXAS("TX", "Texas"),
    WEST_VIRGINIA("WV", "West Virginia"),
    ALABAMA("AL", "Alabama"),
    CONNECTICUT("CT", "Connecticut"),
    IOWA("IA", "Iowa"),
    ILLINOIS("IL", "Illinois"),
    INDIANA("IN", "Indiana"),
    MAINE("ME", "Maine"),
    MICHIGAN("MI", "Michigan"),
    MINNESOTA("MN", "Minnesota"),
    NEBRASKA("NE", "Nebraska"),
    NEW_HAMPSHIRE("NH", "New Hampshire"),
    NEW_JERSEY("NJ", "New Jersey"),
    NEW_YORK("NY", "New York"),
    OHIO("OH", "Ohio"),
    RHODE_ISLAND("RI", "Rhode Island"),
    VERMONT("VT", "Vermont"),
    WISCONSIN("WI", "Wisconsin"),
    CALIFORNIA("CA", "California"),
    COLORADO("CO", "Colorado"),
    NEW_MEXICO("NM", "New Mexico"),
    NEVADA("NV", "Nevada"),
    UTAH("UT", "Utah"),
    ARIZONA("AZ", "Arizona"),
    IDAHO("ID", "Idaho"),
    MONTANA("MT", "Montana"),
    NORTH_DAKOTA("ND", "North Dakota"),
    OREGON("OR", "Oregon"),
    SOUTH_DAKOTA("SD", "South Dakota"),
    WASHINGTON("WA", "Washington"),
    WYOMING("WY", "Wyoming"),
    HAWAII("HI", "Hawaii"),
    ALASKA("AK", "Alaska"),
    KENTUCKY("KY", "Kentucky"),
    MASSACHUSETTS("MA", "Massachusetts"),
    PENNSYLVANIA("PA", "Pennsylvania"),
    VIRGINIA("VA", "Virginia");

    private final String code;
    private final String fullName;

    AdminCode(String code, String fullName) {
        this.code = code;
        this.fullName = fullName;
    }

}
