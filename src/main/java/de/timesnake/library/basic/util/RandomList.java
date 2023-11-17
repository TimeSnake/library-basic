/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

public class RandomList<E> extends LinkedList<E> {

  private static final Random DEFAULT_RANDOM = new Random();

  public static <E> E anyOf(Collection<E> entries) {
    return anyOf(entries, DEFAULT_RANDOM);
  }

  public static <E> E anyOf(Collection<E> entries, Random random) {
    return new RandomList<>(entries, random).getRandom();
  }

  private final Random random;

  public RandomList(Collection<E> entries) {
    this(entries, DEFAULT_RANDOM);
  }

  public RandomList(Collection<E> entries, Random random) {
    super(entries);
    this.random = random;
  }

  public E getRandom() {
    return this.get(this.random.nextInt(this.size()));
  }
}
