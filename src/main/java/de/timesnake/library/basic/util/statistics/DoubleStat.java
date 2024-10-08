/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util.statistics;

public final class DoubleStat extends StatType<Double> {

  public static final String NAME = "double";

  public DoubleStat(String name, String displayName, Double defaultValue, Integer displayIndex,
      Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
      Integer globalDisplayLineIndex) {
    super(name, displayName, defaultValue, displayIndex, displayLineIndex, globalDisplay,
        globalDisplayIndex,
        globalDisplayLineIndex);
  }

  public DoubleStat(String name, String displayName, String defaultValue, Integer displayIndex,
      Integer displayLineIndex, Boolean globalDisplay, Integer globalDisplayIndex,
      Integer globalDisplayLineIndex) {
    super(name, displayName, defaultValue, displayIndex, displayLineIndex, globalDisplay,
        globalDisplayIndex,
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
    if (value == null) {
      value = this.getDefaultValue();
    }
    return value + add;
  }

  @Override
  public int compare(Double x, Double y) {
    if (y == null && x == null) {
      return -1;
    }
    if (y == null) {
      return -1;
    }
    if (x == null) {
      return 1;
    }
    return Double.compare(x, y);
  }

}
