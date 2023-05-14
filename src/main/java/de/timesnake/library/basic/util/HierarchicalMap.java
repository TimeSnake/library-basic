/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.NotNull;

public class HierarchicalMap<K1, K2, V> implements Iterable<V> {

    private final HashMap<K1, Map<K2, V>> map = new HashMap<>();

    public void put(K1 key1, K2 key2, V value) {
        this.map.computeIfAbsent(key1, k -> new HashMap<>()).put(key2, value);
    }

    public V remove(K1 key1, K2 key2) {
        AtomicReference<V> value = new AtomicReference<>();
        this.map.computeIfPresent(key1, (k, v) -> {
            value.set(v.remove(key2));
            return !v.isEmpty() ? v : null;
        });
        return value.get();
    }

    public Map<K2, V> get(K1 key) {
        return this.map.get(key);
    }

    public V get(K1 key1, K2 key2) {
        return this.map.getOrDefault(key1, Map.of()).get(key2);
    }

    public Collection<V> getValues(K1 key) {
        return this.map.get(key).values();
    }

    public boolean containsKey(K1 key) {
        return this.map.containsKey(key);
    }

    public boolean containsKey(K1 key1, K2 key2) {
        return this.map.getOrDefault(key1, new HashMap<>()).containsKey(key2);
    }

    public Collection<V> values() {
        return this.map.values().stream()
                .flatMap(k2VMap -> k2VMap.values().stream())
                .toList();
    }

    public int size() {
        return this.map.size();
    }

    @NotNull
    @Override
    public Iterator<V> iterator() {
        return this.values().iterator();
    }
}
