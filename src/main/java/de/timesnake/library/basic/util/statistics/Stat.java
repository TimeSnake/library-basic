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
