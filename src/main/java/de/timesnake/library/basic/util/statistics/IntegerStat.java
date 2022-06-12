package de.timesnake.library.basic.util.statistics;

public final class IntegerStat extends StatType<Integer> {

    public static final String NAME = "integer";

    public IntegerStat(String name, String displayName, Integer defaultValue, Integer displayIndex,
                       Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                       Integer globalDisplayLineIndex) {
        super(name, displayName, defaultValue, displayIndex, displayLineIndex, globalDisplay, globalDisplayIndex,
                globalDisplayLineIndex);
    }

    public IntegerStat(String name, String displayName, String defaultValue, Integer displayIndex,
                       Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                       Integer globalDisplayLineIndex) {
        super(name, displayName, defaultValue, displayIndex, displayLineIndex, globalDisplay,
                globalDisplayIndex, globalDisplayLineIndex);
    }

    @Override
    public String getType() {
        return NAME;
    }

    @Override
    public Integer add(Integer value, Integer add) {
        return value + add;
    }

    @Override
    public Integer valueOf(String s) {
        return s != null ? Integer.valueOf(s) : null;
    }

    @Override
    public int compare(Integer x, Integer y) {
        if (y == null && x == null) return -1;
        if (y == null) return -1;
        if (x == null) return 1;
        return Integer.compare(x, y);
    }

    @Override
    public String valueToString(Integer i) {
        return String.valueOf(i);
    }

    @Override
    public String valueToDisplay(Integer i) {
        return String.valueOf(i);
    }

}
