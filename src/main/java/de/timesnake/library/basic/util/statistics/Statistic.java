/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util.statistics;

import java.util.HashMap;
import java.util.Map;

public class Statistic {

    protected final Map<String, Stat<?>> statsByName = new HashMap<>();

    public <Value> Stat<Value> addStat(StatType<Value> type) {
        return this.addStat(type, type.getDefaultValue());
    }

    public <Value> Stat<Value> addStat(StatType<Value> type, Value value) {
        Stat<Value> stat = new Stat<>(type, value);
        this.statsByName.put(type.getName(), stat);
        return stat;
    }

    public <Value> Stat<Value> addStat(StatType<Value> type, Map<StatPeriod, Value> values) {
        Stat<Value> stat = new Stat<>(type, values);
        this.statsByName.put(type.getName(), stat);
        return stat;
    }

    public <Value> Stat<Value> getStat(StatType<Value> type) {
        if (type == null) return null;
        return (Stat<Value>) this.statsByName.get(type.getName());
    }

}
