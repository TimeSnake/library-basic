package de.timesnake.library.basic.util.statistics;

import de.timesnake.library.basic.util.Tuple;

import java.util.HashMap;
import java.util.Map;

public class Statistic implements Statisticable {

    private final Map<String, Tuple<Stat<?>, Object>> statsByName = new HashMap<>();

    @Override
    public <Value> Value getStat(Stat<Value> type) {
        Tuple<Stat<?>, ?> statTuple = this.statsByName.get(type.getName());
        return statTuple != null ? (Value) statTuple.getB() : type.getDefaultValue();
    }

    @Override
    public <Value> void setStat(Stat<Value> type, Value value) {
        this.statsByName.put(type.getName(), new Tuple<>(type, value));
    }

    @Override
    public <Value> Value increaseStat(Stat<Value> type, Value value) {
        Value result = type.add(this.getStat(type), value);
        this.setStat(type, result);
        return result;
    }

    public <Value> boolean higherStat(Stat<Value> type, Value value) {
        int higher = type.compare(this.getStat(type), value);
        if (higher < 0) {
            this.setStat(type, value);
            return true;
        } else {
            return false;
        }
    }
}
