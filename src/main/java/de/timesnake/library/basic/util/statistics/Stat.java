package de.timesnake.library.basic.util.statistics;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public abstract class Stat<Value> implements Comparator<Value> {

    private final Boolean globalDisplay;

    private final Type<Value> type;
    private final String name;
    private final String displayName;
    private final Value defaultValue;

    private final Integer displayIndex;
    private final Integer displayLineIndex;
    private final Integer globalDisplayIndex;
    private final Integer globalDisplayLineIndex;

    public Stat(Type<Value> type, String name, String displayName, Value defaultValue, Integer displayIndex,
                Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                Integer globalDisplayLineIndex) {
        this.type = type;
        this.name = name;
        this.defaultValue = defaultValue;
        this.displayName = displayName;
        this.displayIndex = displayIndex;
        this.displayLineIndex = displayLineIndex;
        this.globalDisplay = globalDisplay;
        this.globalDisplayIndex = globalDisplayIndex;
        this.globalDisplayLineIndex = globalDisplayLineIndex;
    }

    public Stat(Type<Value> type, String name, String displayName, Value defaultValue) {
        this(type, name, displayName, defaultValue, null, null, null,
                null, null);
    }

    public Boolean getGlobalDisplay() {
        return globalDisplay;
    }

    public Type<Value> getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Value getDefaultValue() {
        return defaultValue;
    }

    public String getDefaultValueAsString() {
        return this.type.valueToString(this.defaultValue);
    }

    public String getDisplayName() {
        return displayName;
    }

    public Integer getDisplayIndex() {
        return displayIndex;
    }

    public Integer getDisplayLineIndex() {
        return displayLineIndex;
    }

    public String getValueAsString(Value value) {
        return this.type.valueToString(value);
    }

    public String getValueAsDisplay(Value value) {
        return this.type.valueToDisplay(value);
    }

    public Integer getGlobalDisplayIndex() {
        return globalDisplayIndex;
    }

    public Integer getGlobalDisplayLineIndex() {
        return globalDisplayLineIndex;
    }

    public static abstract class Type<ValueType> {

        public static final Map<String, Type<?>> TYPES_BY_NAME = new HashMap<>();

        public static void addType(Type<?> type) {
            TYPES_BY_NAME.put(type.getName(), type);
        }

        public static final Type<Integer> INTEGER = new Type<>("integer") {
            @Override
            public Integer valueOf(String s) {
                return s != null ? Integer.parseInt(s) : null;
            }

            @Override
            public String valueToString(Integer i) {
                return String.valueOf(i);
            }

            @Override
            public String valueToDisplay(Integer i) {
                return String.valueOf(i);
            }

            @Override
            public Stat<Integer> asStat(String name, String displayName, Object defaultValue) {
                return new Stat<>(this, name, displayName, ((Integer) defaultValue)) {
                    @Override
                    public Integer add(Integer value, Integer add) {
                        return value + add;
                    }

                    @Override
                    public int compare(Integer x, Integer y) {
                        if (y == null && x == null) return -1;
                        if (y == null) return -1;
                        if (x == null) return 1;
                        return Integer.compare(x, y);
                    }
                };
            }

            @Override
            public Stat<Integer> asStat(String name, String displayName, Object defaultValue, Integer displayIndex,
                                        Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                                        Integer globalDisplayLineIndex) {
                return new Stat<>(this, name, displayName, ((Integer) defaultValue), displayIndex, displayLineIndex,
                        globalDisplay, globalDisplayIndex, globalDisplayLineIndex) {
                    @Override
                    public Integer add(Integer value, Integer add) {
                        return value + add;
                    }

                    @Override
                    public int compare(Integer x, Integer y) {
                        if (y == null && x == null) return -1;
                        if (y == null) return -1;
                        if (x == null) return 1;
                        return Integer.compare(x, y);
                    }
                };
            }
        };

        public static final Type<Double> DOUBLE = new Type<>("double") {
            @Override
            public Double valueOf(String s) {
                return s != null ? Double.parseDouble(s) : null;
            }

            @Override
            public String valueToString(Double d) {
                return String.valueOf(d);
            }

            @Override
            public String valueToDisplay(Double d) {
                return String.valueOf((int) (d * 10000) / 10000d);
            }

            @Override
            public Stat<Double> asStat(String name, String displayName, Object defaultValue) {
                return new Stat<>(this, name, displayName, ((Double) defaultValue)) {
                    @Override
                    public Double add(Double value, Double add) {
                        return value + add;
                    }

                    @Override
                    public int compare(Double x, Double y) {
                        if (y == null && x == null) return -1;
                        if (y == null) return -1;
                        if (x == null) return 1;
                        return Double.compare(x, y);
                    }
                };
            }

            @Override
            public Stat<Double> asStat(String name, String displayName, Object defaultValue, Integer displayIndex,
                                       Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                                       Integer globalDisplayLineIndex) {
                return new Stat<>(this, name, displayName, ((Double) defaultValue), displayIndex, displayLineIndex,
                        globalDisplay, globalDisplayIndex, globalDisplayLineIndex) {
                    @Override
                    public Double add(Double value, Double add) {
                        return value + add;
                    }

                    @Override
                    public int compare(Double x, Double y) {
                        if (y == null && x == null) return -1;
                        if (y == null) return -1;
                        if (x == null) return 1;
                        return Double.compare(x, y);
                    }
                };
            }
        };

        public static final Type<Float> PERCENT = new Type<>("percent") {
            @Override
            public Float valueOf(String s) {
                return s != null ? Float.parseFloat(s) : null;
            }

            @Override
            public String valueToString(Float f) {
                return String.valueOf(f);
            }

            @Override
            public String valueToDisplay(Float f) {
                return ((int) (f * 10000)) / 100d + "%";
            }

            @Override
            public Stat<Float> asStat(String name, String displayName, Object defaultValue) {
                return new Stat<>(this, name, displayName, ((Float) defaultValue)) {
                    @Override
                    public Float add(Float value, Float add) {
                        return value + add;
                    }

                    @Override
                    public int compare(Float x, Float y) {
                        if (y == null && x == null) return -1;
                        if (y == null) return -1;
                        if (x == null) return 1;
                        return Float.compare(x, y);
                    }
                };
            }

            @Override
            public Stat<Float> asStat(String name, String displayName, Object defaultValue, Integer displayIndex,
                                      Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                                      Integer globalDisplayLineIndex) {
                return new Stat<>(this, name, displayName, ((Float) defaultValue), displayIndex, displayLineIndex,
                        globalDisplay, globalDisplayIndex, globalDisplayLineIndex) {
                    @Override
                    public Float add(Float value, Float add) {
                        return value + add;
                    }

                    @Override
                    public int compare(Float x, Float y) {
                        if (y == null && x == null) return -1;
                        if (y == null) return -1;
                        if (x == null) return 1;
                        return Float.compare(x, y);
                    }
                };
            }
        };

        public static final Type<String> STRING = new Type<>("string") {
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
            public Stat<String> asStat(String name, String displayName, Object defaultValue) {
                return new Stat<>(this, name, displayName, ((String) defaultValue)) {
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
                };
            }

            @Override
            public Stat<String> asStat(String name, String displayName, Object defaultValue, Integer displayIndex,
                                       Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                                       Integer globalDisplayLineIndex) {
                return new Stat<>(this, name, displayName, ((String) defaultValue), displayIndex, displayLineIndex,
                        globalDisplay, globalDisplayIndex, globalDisplayLineIndex) {
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
                };
            }
        };

        static {
            Type.addType(INTEGER);
            Type.addType(DOUBLE);
            Type.addType(STRING);
            Type.addType(PERCENT);
        }


        private final String name;

        public Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract ValueType valueOf(String s);

        public abstract String valueToString(ValueType valueType);

        public abstract String valueToDisplay(ValueType valueType);

        public abstract Stat<ValueType> asStat(String name, String displayName, Object defaultValueType);

        public abstract Stat<ValueType> asStat(String name, String displayName, Object defaultValueType,
                                               Integer displayIndex, Integer displayLineIndex, Boolean globalDisplay,
                                               Integer globalDisplayIndex, Integer globalDisplayLineIndex);
    }

    public abstract Value add(Value value, Value add);

}
