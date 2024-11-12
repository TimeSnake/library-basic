/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.BiFunction;

public class MultiKeyMap<K1, K2, V> implements Iterable<V> {

  private final Map<K1, V> valuesByK1 = new HashMap<>();
  private final Map<K2, V> valuesByK2 = new HashMap<>();

  public void put(K1 key1, K2 key2, V value) {
    this.valuesByK1.put(key1, value);
    this.valuesByK2.put(key2, value);
  }

  public V remove(K1 key1, K2 key2) {
    this.valuesByK2.remove(key2);
    return this.valuesByK1.remove(key1);
  }

  public V get1(K1 key) {
    return this.valuesByK1.get(key);
  }

  public V get2(K2 key) {
    return this.valuesByK2.get(key);
  }

  public boolean containsKey1(K1 key) {
    return this.valuesByK1.containsKey(key);
  }

  public boolean containsKey2(K2 key) {
    return this.valuesByK2.containsKey(key);
  }

  public V compueIfAbsent(K1 key1, K2 key2, BiFunction<K1, K2, V> mappingFunction) {
    V value = mappingFunction.apply(key1, key2);
    this.valuesByK2.computeIfAbsent(key2, k -> value);
    this.valuesByK1.computeIfAbsent(key1, k -> value);
    return value;
  }

  public Collection<V> values() {
    return this.valuesByK1.values();
  }

  public int size() {
    return this.valuesByK1.size();
  }

  public Map<K1, V> getMap1() {
    return this.valuesByK1;
  }

  public Map<K2, V> getMap2() {
    return this.valuesByK2;
  }

  public Set<Map.Entry<K1, V>> entrySet1() {
    return this.valuesByK1.entrySet();
  }

  public Set<Map.Entry<K2, V>> entrySet2() {
    return this.valuesByK2.entrySet();
  }

  @NotNull
  @Override
  public Iterator<V> iterator() {
    return this.valuesByK1.values().stream().iterator();
  }
}
