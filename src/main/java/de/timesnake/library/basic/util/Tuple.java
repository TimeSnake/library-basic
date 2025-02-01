/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class Tuple<A, B> implements Serializable {

  private A a;
  private B b;

  public Tuple(A a, B b) {
    this.a = a;
    this.b = b;
  }

  public Tuple(Map.Entry<A, B> entry) {
    this.a = entry.getKey();
    this.b = entry.getValue();
  }

  public A getA() {
    return a;
  }

  public void setA(A a) {
    this.a = a;
  }

  public B getB() {
    return b;
  }

  public void setB(B b) {
    this.b = b;
  }

  public Tuple<A, B> applyOnA(Consumer<A> consumer) {
    consumer.accept(this.a);
    return this;
  }

  public Tuple<A, B> applyOnB(Consumer<B> consumer) {
    consumer.accept(this.b);
    return this;
  }

  public Tuple<A, B> apply(Consumer<A> consumerA, Consumer<B> consumerB) {
    consumerA.accept(this.a);
    consumerB.accept(this.b);
    return this;
  }

  public <C, D> Tuple<C, D> map(Function<A, C> mapperA, Function<B, D> mapperB) {
    return new Tuple<>(mapperA.apply(this.a), mapperB.apply(this.b));
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Tuple<?, ?>)) {
      return false;
    }
    if (this == obj) {
      return true;
    }
    return Objects.equals(this.getA(), ((Tuple<?, ?>) obj).getA()) && Objects.equals(this.getB(),
        ((Tuple<?, ?>) obj).getB());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.a, this.b);
  }

  @Override
  public String toString() {
    return "Tuple{" +
        "a=" + a +
        ", b=" + b +
        '}';
  }
}
