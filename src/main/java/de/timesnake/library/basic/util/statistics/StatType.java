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

import java.util.Comparator;

public sealed abstract class StatType<Value> implements Comparator<Value> permits DoubleStat, IntegerStat, StringStat,
        PercentStat {

    public static StatType<?> wrapStatType(String type,
                                           String name, String displayName, String defaultValue,
                                           Integer displayIndex, Integer displayLineIndex, Boolean globalDisplay,
                                           Integer globalDisplayIndex, Integer globalDisplayLineIndex) {
        return switch (type.toLowerCase()) {
            case IntegerStat.NAME -> new IntegerStat(name, displayName, defaultValue, displayIndex, displayLineIndex,
                    globalDisplay, globalDisplayIndex, globalDisplayLineIndex);
            case DoubleStat.NAME -> new DoubleStat(name, displayName, defaultValue, displayIndex, displayLineIndex,
                    globalDisplay, globalDisplayIndex, globalDisplayLineIndex);
            case PercentStat.NAME -> new PercentStat(name, displayName, defaultValue, displayIndex, displayLineIndex,
                    globalDisplay, globalDisplayIndex, globalDisplayLineIndex);
            case StringStat.NAME -> new StringStat(name, displayName, defaultValue, displayIndex, displayLineIndex,
                    globalDisplay, globalDisplayIndex, globalDisplayLineIndex);
            default -> null;
        };
    }

    private final String name;

    private final Boolean globalDisplay;
    private final String displayName;
    private final Integer displayIndex;
    private final Integer displayLineIndex;
    private final Integer globalDisplayIndex;
    private final Integer globalDisplayLineIndex;
    private Value defaultValue;

    public StatType(String name, String displayName, Value defaultValue, Integer displayIndex,
                    Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                    Integer globalDisplayLineIndex) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.displayName = displayName;
        this.displayIndex = displayIndex;
        this.displayLineIndex = displayLineIndex;
        this.globalDisplay = globalDisplay;
        this.globalDisplayIndex = globalDisplayIndex;
        this.globalDisplayLineIndex = globalDisplayLineIndex;
    }

    public StatType(String name, String displayName, String defaultValue, Integer displayIndex,
                    Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                    Integer globalDisplayLineIndex) {
        this.name = name;
        this.defaultValue = this.valueOf(defaultValue);
        this.displayName = displayName;
        this.displayIndex = displayIndex;
        this.displayLineIndex = displayLineIndex;
        this.globalDisplay = globalDisplay;
        this.globalDisplayIndex = globalDisplayIndex;
        this.globalDisplayLineIndex = globalDisplayLineIndex;
    }

    public StatType(String name, String displayName, Integer displayIndex,
                    Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                    Integer globalDisplayLineIndex) {
        this.name = name;
        this.displayName = displayName;
        this.displayIndex = displayIndex;
        this.displayLineIndex = displayLineIndex;
        this.globalDisplay = globalDisplay;
        this.globalDisplayIndex = globalDisplayIndex;
        this.globalDisplayLineIndex = globalDisplayLineIndex;
    }

    public Boolean getGlobalDisplay() {
        return globalDisplay;
    }

    public String getName() {
        return name;
    }

    public Value getDefaultValue() {
        return defaultValue;
    }

    protected void setDefaultValue(Value value) {
        this.defaultValue = value;
    }

    public String getDefaultValueAsString() {
        return this.valueToString(this.defaultValue);
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

    public Integer getGlobalDisplayIndex() {
        return globalDisplayIndex;
    }

    public Integer getGlobalDisplayLineIndex() {
        return globalDisplayLineIndex;
    }

    public abstract String getType();

    public abstract Value add(Value value, Value add);

    public abstract Value valueOf(String s);

    public abstract String valueToString(Value valueType);

    public abstract String valueToDisplay(Value valueType);

}
