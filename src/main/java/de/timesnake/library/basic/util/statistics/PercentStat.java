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

public final class PercentStat extends StatType<Float> {

    public static final String NAME = "percent";

    public PercentStat(String name, String displayName, Float defaultValue, Integer displayIndex,
                       Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                       Integer globalDisplayLineIndex) {
        super(name, displayName, defaultValue, displayIndex, displayLineIndex, globalDisplay, globalDisplayIndex,
                globalDisplayLineIndex);
    }

    public PercentStat(String name, String displayName, String defaultValue, Integer displayIndex,
                       Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                       Integer globalDisplayLineIndex) {
        super(name, displayName, defaultValue, displayIndex, displayLineIndex, globalDisplay, globalDisplayIndex,
                globalDisplayLineIndex);
    }

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
    public String getType() {
        return NAME;
    }

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
}
