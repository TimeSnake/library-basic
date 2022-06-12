package de.timesnake.library.basic.util.statistics;

public final class StringStat extends StatType<String> {

    public static final String NAME = "string";

    public StringStat(String name, String displayName, String defaultValue, Integer displayIndex,
                      Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                      Integer globalDisplayLineIndex) {
        super(name, displayName, displayIndex, displayLineIndex, globalDisplay, globalDisplayIndex,
                globalDisplayLineIndex);
        super.setDefaultValue(defaultValue);
    }

    @Override
    public String valueOf(String s) {
        return s;
    }

    @Override
    public String valueToString(String s) {
        return s;
    }

    @Override
    public String valueToDisplay(String s) {
        return s;
    }

    @Override
    public String getType() {
        return NAME;
    }

    @Override
    public String add(String s, String add) {
        return s + add;
    }

    @Override
    public int compare(String x, String y) {
        if (y == null && x == null) return -1;
        if (y == null) return -1;
        if (x == null) return 1;
        return x.compareTo(y);
    }
}
