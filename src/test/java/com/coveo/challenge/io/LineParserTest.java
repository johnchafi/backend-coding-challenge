package com.coveo.challenge.io;


import com.coveo.challenge.converter.AdminCodeConverter;
import com.coveo.challenge.converter.CountryConverter;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class LineParserTest {

    private final static String LINE = "5882142\tActon Vale\tActon Vale\t\t45.65007\t-72.56582\tP\tPPL\tCA\t\t10\t16\t\t\t5135\t\t90\tAmerica/Montreal\t2008-04-11";

    @Autowired
    private CountryConverter countryConverter;

    @Autowired
    private AdminCodeConverter adminCodeConverter;

}