/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import net.kyori.adventure.util.Index;

public final class Availability extends Type {

  public static final Availability FORBIDDEN = new Availability("forbidden");
  public static final Availability ALLOWED = new Availability("allowed");
  public static final Availability REQUIRED = new Availability("required");

  public static Availability valueOf(String name) {
    return TYPES_BY_STRING.value(name.replace(PREFIX + DIVIDER, ""));
  }

  public static Availability[] values() {
    return VALUES;
  }

  private static final Availability[] VALUES = {FORBIDDEN, ALLOWED, REQUIRED};
  private static final Index<String, Availability> TYPES_BY_STRING = Index.create(Type::getShortName, VALUES);

  public static final String PREFIX = "avail";

  Availability(String type) {
    super(type);
  }

  @Override
  protected String getType() {
    return PREFIX;
  }
}
