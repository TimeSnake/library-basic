/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import net.kyori.adventure.util.Index;

import java.io.Serializable;

public final class PunishType extends Type implements Serializable {

  public static final PunishType BAN = new PunishType("ban");
  public static final PunishType TEMP_BAN = new PunishType("tempban");
  public static final PunishType JAIL = new PunishType("jail");
  public static final PunishType MUTE = new PunishType("mute");
  public static final PunishType TEMP_MUTE = new PunishType("tempmute");

  public static PunishType valueOf(String name) {
    return TYPES_BY_STRING.value(name.replace(PREFIX + DIVIDER, ""));
  }

  public static PunishType[] values() {
    return VALUES;
  }

  private static final PunishType[] VALUES = {BAN, TEMP_BAN, JAIL, MUTE, TEMP_MUTE};
  private static final Index<String, PunishType> TYPES_BY_STRING = Index.create(Type::getShortName, VALUES);

  public static final String PREFIX = "punish";

  PunishType(String type) {
    super(type);
  }

  @Override
  protected String getType() {
    return PREFIX;
  }
}