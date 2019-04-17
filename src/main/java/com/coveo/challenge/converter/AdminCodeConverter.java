package com.coveo.challenge.converter;

import com.coveo.challenge.model.AdminCode;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static org.apache.commons.lang3.StringUtils.equalsAny;

@Component
public class AdminCodeConverter implements Converter<String, AdminCode> {
    @Override
    public String convertToX(AdminCode value) {
        return value.getFullName();
    }

    @Override
    public AdminCode convertToY(String value) {
        return Arrays.stream(AdminCode.values())
                .filter(v -> equalsAny(value, v.getCode(), v.getFullName()))
                .findAny().orElse(null);
    }
}
