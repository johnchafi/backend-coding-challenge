package com.coveo.challenge.io;


import com.coveo.challenge.converter.AdminCodeConverter;
import com.coveo.challenge.converter.CountryConverter;
import com.coveo.challenge.model.AdminCode;
import com.coveo.challenge.model.City;
import com.coveo.challenge.model.Country;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LineParserTest {

    private final static String LINE_WITHOUT_ALT_NAMES = "5882142\tActon Vale\tActon Vale\t\t45.65007\t-72.56582\tP\tPPL\tCA\t\t10\t16\t\t\t5135\t\t90\tAmerica/Montreal\t2008-04-11";
    private final static String LINE_WITH_ALT_NAMES = "5884083\tAlma\tAlma\tAl'ma,Alma,YTF,alma,alma, kbk,alma, kybk,Алма,Альма,آلما,آلما، کبک,ألما، كيبك\t48.55009\t-71.6491\tP\tPPL\tCA\t\t10\t02\t\t\t29526\t\t90\tAmerica/Montreal\t2010-01-29";

    @InjectMocks
    private LineParser underTest;

    @Mock
    private CountryConverter countryConverter;

    @Mock
    private AdminCodeConverter adminCodeConverter;

    @Test
    public void whenParse_givenLineWithoutAltNames_thenShouldReturnExpectedCity() {
        when(countryConverter.convertToY(anyString())).thenReturn(Country.CA);
        when(adminCodeConverter.convertToY(anyString())).thenReturn(AdminCode.BRITISH_COLUMBIA);

        City actual = underTest.parse(LINE_WITHOUT_ALT_NAMES);

        assertThat(actual).isNotNull();
        assertThat(actual.getName()).isEqualTo("Acton Vale");
        assertThat(Arrays.isNullOrEmpty(actual.getAlternateNames())).isTrue();
        assertThat(actual.getCoordinates().getLatitude()).isEqualTo(45.65007);
        assertThat(actual.getCoordinates().getLongitude()).isEqualTo(-72.56582);
        assertThat(actual.getCountry()).isEqualTo(Country.CA);
        assertThat(actual.getAdminCode()).isEqualTo(AdminCode.BRITISH_COLUMBIA);
    }

    @Test
    public void whenParse_givenLineWithAltNames_thenShouldReturnExpectedCity() {
        when(countryConverter.convertToY(anyString())).thenReturn(Country.US);
        when(adminCodeConverter.convertToY(anyString())).thenReturn(AdminCode.ALASKA);

        City actual = underTest.parse(LINE_WITH_ALT_NAMES);

        assertThat(actual).isNotNull();
        assertThat(actual.getName()).isEqualTo("Alma");
        assertThat(Arrays.isNullOrEmpty(actual.getAlternateNames())).isFalse();
        assertThat(actual.getAlternateNames().length).isEqualTo(13);
        assertThat(actual.getCoordinates().getLatitude()).isEqualTo(48.55009);
        assertThat(actual.getCoordinates().getLongitude()).isEqualTo(-71.6491);
        assertThat(actual.getCountry()).isEqualTo(Country.US);
        assertThat(actual.getAdminCode()).isEqualTo(AdminCode.ALASKA);
    }

}