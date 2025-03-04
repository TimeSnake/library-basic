/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class RandomList<E> extends ArrayList<E> {

  private static final Random DEFAULT_RANDOM = new Random();

  public static <E> E anyOf(E[] entries) {
    return anyOf(List.of(entries), DEFAULT_RANDOM);
  }

  public static <E> E anyOf(Collection<E> entries) {
    return anyOf(entries, DEFAULT_RANDOM);
  }

  public static <E> E anyOf(Collection<E> entries, Random random) {
    return new RandomList<>(entries, random).getAny();
  }

  @SafeVarargs
  public static <E> RandomList<E> of(E... values) {
    return new RandomList<>(values, DEFAULT_RANDOM);
  }

  @SafeVarargs
  public static <E> RandomList<E> nOf(int n, E... values) {
    RandomList<E> list = new RandomList<>();
    for (int i = 0; i < n; i++) {
      list.add(values[DEFAULT_RANDOM.nextInt(values.length)]);
    }
    return list;
  }

  public static <E> RandomList<E> nOf(int n, List<E> values) {
    RandomList<E> list = new RandomList<>();
    for (int i = 0; i < n; i++) {
      list.add(values.get(DEFAULT_RANDOM.nextInt(values.size())));
    }
    return list;
  }

  private final Random random;

  public RandomList(Collection<E> entries) {
    this(entries, DEFAULT_RANDOM);
  }

  public RandomList(Collection<E> entries, Random random) {
    super(entries);
    this.random = random;
  }

  public RandomList() {
    super();
    this.random = DEFAULT_RANDOM;
  }

  public RandomList(E[] entries, Random random) {
    super(List.of(entries));
    this.random = random;
  }

  public E getAny() {
    return this.get(this.random.nextInt(this.size()));
  }

  public E popAny() {
    return this.remove(this.random.nextInt(this.size()));
  }
}
