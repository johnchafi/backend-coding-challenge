package com.coveo.challenge.calculator.strategy.similarity;

public interface SimilarityStrategy<T> {

    double similarity(T searchValue, T value);
}
