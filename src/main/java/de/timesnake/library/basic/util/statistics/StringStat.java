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
