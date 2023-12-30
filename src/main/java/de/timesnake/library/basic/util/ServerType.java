/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import net.kyori.adventure.util.Index;

public final class ServerType extends Type {

  public static final ServerType LOBBY = new ServerType("lobby");
  public static final ServerType GAME = new ServerType("game");
  public static final ServerType TEMP_GAME = new ServerType("tempgame");
  public static final ServerType BUILD = new ServerType("build");
  public static final ServerType LOUNGE = new ServerType("lounge");

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

  ServerType(String type) {
    super(type);
  }

  @Override
  protected String getType() {
    return PREFIX;
  }
}
