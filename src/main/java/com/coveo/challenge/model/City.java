package com.coveo.challenge.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class City {

    private String name;

    private String[] alternateNames;

    private Point coordinates;

    private Country country;

    private AdminCode adminCode;

    public String getFullName() {
        String regionName = adminCode != null ? adminCode.getFullName() : " ";
        String countryName = country != null ? country.getFullName() : " ";
        return name + ", " + regionName + ", " + countryName;
    }

}
