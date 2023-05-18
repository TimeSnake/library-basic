/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util.statistics;

public final class PercentStat extends StatType<Float> {

  public static final String NAME = "percent";

  public PercentStat(String name, String displayName, Float defaultValue, Integer displayIndex,
      Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
      Integer globalDisplayLineIndex) {
    super(name, displayName, defaultValue, displayIndex, displayLineIndex, globalDisplay,
        globalDisplayIndex,
        globalDisplayLineIndex);
  }

  public PercentStat(String name, String displayName, String defaultValue, Integer displayIndex,
      Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
      Integer globalDisplayLineIndex) {
    super(name, displayName, defaultValue, displayIndex, displayLineIndex, globalDisplay,
        globalDisplayIndex,
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
    if (y == null && x == null) {
      return -1;
    }
    if (y == null) {
      return -1;
    }
    if (x == null) {
      return 1;
    }
    return Float.compare(x, y);
  }
}
