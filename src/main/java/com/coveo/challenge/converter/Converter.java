package com.coveo.challenge.converter;

public interface Converter<X, Y> {

    X convertToX(Y value);

    Y convertToY(X value);
}
