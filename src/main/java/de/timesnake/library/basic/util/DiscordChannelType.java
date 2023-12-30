/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import net.kyori.adventure.util.Index;

public final class DiscordChannelType extends Type {

  public static final DiscordChannelType FORBIDDEN = new DiscordChannelType("forbidden");
  public static final DiscordChannelType TEAMS = new DiscordChannelType("teams");
  public static final DiscordChannelType DISTANCE = new DiscordChannelType("distance");

  public static DiscordChannelType valueOf(String name) {
    return TYPES_BY_STRING.value(name.replace(PREFIX + DIVIDER, ""));
  }

  public static DiscordChannelType[] values() {
    return VALUES;
  }

  private static final DiscordChannelType[] VALUES = {FORBIDDEN, TEAMS, DISTANCE};
  private static final Index<String, DiscordChannelType> TYPES_BY_STRING = Index.create(Type::getShortName, VALUES);

  public static final String PREFIX = "discord";

  DiscordChannelType(String type) {
    super(type);
  }

  @Override
  protected String getType() {
    return PREFIX;
  }
}
