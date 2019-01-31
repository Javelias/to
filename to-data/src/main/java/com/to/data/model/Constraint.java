package com.to.data.model;

import java.util.function.Function;

public class Constraint<T> {

    private String name;
    private T value;
    private Double weight;

    public Constraint(String name, T value, Double weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    public Constraint(String name, T value, Function<T,Double> calculation) {
        this.name = name;
        this.value = value;
        this.weight = calculation.apply(value);
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    public Double getWeight() {
        return weight;
    }
}
