/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import java.util.*;
import java.util.function.Function;

public class WeightedRandomCollection<E> {

  private final NavigableMap<Double, E> map = new TreeMap<>();
  private final Random random;
  private double total = 0;

  public WeightedRandomCollection() {
    this(new Random());
  }

  public WeightedRandomCollection(Random random) {
    this.random = random;
  }

  public WeightedRandomCollection<E> add(double weight, E result) {
    if (weight <= 0) {
      return this;
    }
    total += weight;
    map.put(total, result);
    return this;
  }

  @SafeVarargs
  public final WeightedRandomCollection<E> addAll(Tuple<Double, E>... elements) {
    return this.addAll(List.of(elements));
  }

  public WeightedRandomCollection<E> addAll(Collection<Tuple<Double, E>> elements) {
    elements.forEach(e -> this.add(e.getA(), e.getB()));
    return this;
  }

  public WeightedRandomCollection<E> addAll(Collection<E> elements, Function<E, Double> weightExtractor) {
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
