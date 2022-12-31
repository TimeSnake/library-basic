/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.basic.util;

import java.util.Collection;
import java.util.List;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.function.Function;

public class RandomCollection<E> {

    private final NavigableMap<Double, E> map = new TreeMap<>();
    private final Random random;
    private double total = 0;

    public RandomCollection() {
        this(new Random());
    }

    public RandomCollection(Random random) {
        this.random = random;
    }

    public RandomCollection<E> add(double weight, E result) {
        if (weight <= 0) {
            return this;
        }
        total += weight;
        map.put(total, result);
        return this;
    }

    @SafeVarargs
    public final RandomCollection<E> addAll(Tuple<Double, E>... elements) {
        return this.addAll(List.of(elements));
    }

    public RandomCollection<E> addAll(Collection<Tuple<Double, E>> elements) {
        elements.forEach(e -> this.add(e.getA(), e.getB()));
        return this;
    }

    public RandomCollection<E> addAll(Collection<E> elements, Function<E, Double> weightExtractor) {
        elements.forEach(e -> this.add(weightExtractor.apply(e), e));
        return this;
    }

    public E next() {
        return map.higherEntry(this.random.nextDouble(this.total)).getValue();
    }

    public int size() {
        return this.map.size();
    }

    public double total() {
        return this.total;
    }
}
