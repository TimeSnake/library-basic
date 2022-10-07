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

package de.timesnake.library.basic.util.statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Stat<Value> {

    protected final StatType<Value> type;
    protected Map<StatPeriod, Value> valueByPeriod = new ConcurrentHashMap<>();

    public Stat(StatType<Value> type) {
        this.type = type;
    }

    public Stat(StatType<Value> type, Value value) {
        this.type = type;
        for (StatPeriod period : StatPeriod.values()) {
            this.valueByPeriod.put(period, value != null ? value : this.type.getDefaultValue());
        }
    }

    public Stat(StatType<Value> type, Map<StatPeriod, Value> values) {
        this.type = type;
        values.forEach((period, value) ->
                this.valueByPeriod.put(period, value != null ? value : this.type.getDefaultValue()));
    }

    public StatType<Value> getType() {
        return type;
    }

    public void set(StatPeriod period, Value value) {
        this.valueByPeriod.put(period, value != null ? value : this.type.getDefaultValue());
    }

    public Value get(StatPeriod period) {
        return this.valueByPeriod.getOrDefault(period, type.getDefaultValue());
    }

    public Map<StatPeriod, Value> getAll() {
        Map<StatPeriod, Value> values = new HashMap<>();
        this.valueByPeriod.forEach((key, value) -> values.put(key, value != null ? value :
                this.type.getDefaultValue()));
        return values;
    }

    public void setAll(Value value) {
        for (StatPeriod period : StatPeriod.values()) {
            this.set(period, value);
        }
    }

    public Value increase(StatPeriod period, Value value) {
        if (value == null) return this.valueByPeriod.get(period);
        return this.valueByPeriod.compute(period, (p, v) -> this.type.add(v, value));
    }

    public Value higher(StatPeriod period, Value value) {
        if (value == null) return this.valueByPeriod.get(period);
        return this.valueByPeriod.compute(period, (p, v) -> this.type.compare(v, value) >= 0 ? v : value);
    }

    public Map<StatPeriod, Value> increaseAll(Value value) {
        if (value == null) return this.valueByPeriod;
        Map<StatPeriod, Value> values = new HashMap<>();
        for (StatPeriod period : StatPeriod.values()) {
            values.put(period, this.increase(period, value));
        }
        return values;
    }

    public Map<StatPeriod, Value> higherAll(Value value) {
        if (value == null) return this.valueByPeriod;
        Map<StatPeriod, Value> values = new HashMap<>();
        for (StatPeriod period : StatPeriod.values()) {
            values.put(period, this.higher(period, value));
        }
        return values;
    }
}
