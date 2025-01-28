/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import net.kyori.adventure.util.Index;

public final class ServerType extends Type {

  public static final ServerType LOBBY = new ServerType("lobby", "lby");
  public static final ServerType GAME = new ServerType("non_tmp_game", "ntg");
  public static final ServerType TEMP_GAME = new ServerType("tmp_game", "tlg");
  public static final ServerType BUILD = new ServerType("build", "bld");
  public static final ServerType LOUNGE = new ServerType("lounge", "lng");

  public static ServerType valueOf(String name) {
    return TYPES_BY_STRING.value(name.replace(PREFIX + DIVIDER, ""));
  }

  public static ServerType[] values() {
    return VALUES;
  }

  private static final ServerType[] VALUES = {LOBBY, GAME, TEMP_GAME, BUILD, LOUNGE};
  private static final Index<String, ServerType> TYPES_BY_STRING = Index.create(
      Type::getShortName, VALUES);

  public static final String PREFIX = "server";

  private final String tag;

  ServerType(String name, String tag) {
    super(name);
    this.tag = tag;
  }

  public String getTag() {
    return tag;
  }

  @Override
  protected String getType() {
    return PREFIX;
  }
}
