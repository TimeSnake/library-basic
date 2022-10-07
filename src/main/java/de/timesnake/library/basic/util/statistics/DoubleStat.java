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

public final class DoubleStat extends StatType<Double> {

    public static final String NAME = "double";

    public DoubleStat(String name, String displayName, Double defaultValue, Integer displayIndex,
                      Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                      Integer globalDisplayLineIndex) {
        super(name, displayName, defaultValue, displayIndex, displayLineIndex, globalDisplay, globalDisplayIndex,
                globalDisplayLineIndex);
    }

    public DoubleStat(String name, String displayName, String defaultValue, Integer displayIndex,
                      Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
                      Integer globalDisplayLineIndex) {
        super(name, displayName, defaultValue, displayIndex, displayLineIndex, globalDisplay, globalDisplayIndex,
                globalDisplayLineIndex);
    }

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
    public String getType() {
        return NAME;
    }

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

}
