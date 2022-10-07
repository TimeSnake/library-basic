/*
 * library-basic.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

package de.timesnake.library.basic.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.BiFunction;

public class MultiKeyMap<K1, K2, V> {

    private final HashMap<K1, V> valuesByK1 = new HashMap<>();
    private final HashMap<K2, V> valuesByK2 = new HashMap<>();

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
}
