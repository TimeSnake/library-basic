package de.timesnake.library.basic.util.statistics;

public interface Statisticable {
    <Value> Value getStat(Stat<Value> type);

    <Value> void setStat(Stat<Value> type, Value value);

    <Value> Value increaseStat(Stat<Value> type, Value value);
}
