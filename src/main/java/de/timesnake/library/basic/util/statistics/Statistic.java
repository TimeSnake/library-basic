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
