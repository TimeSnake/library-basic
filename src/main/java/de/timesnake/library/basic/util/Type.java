/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import java.io.Serializable;
import java.util.Objects;

public abstract sealed class Type implements Serializable permits Availability, DiscordChannelType, PunishType, ServerType {

  public static final String DIVIDER = "_";

  public static <T extends Type> T valueOf(String name) {
    if (name == null) {
      return null;
    }

    String[] names = name.split(DIVIDER);

    if (names.length < 2) {
      return null;
    }

    return switch (names[0]) {
      case ServerType.PREFIX -> (T) ServerType.valueOf(names[1]);
      case PunishType.PREFIX -> (T) PunishType.valueOf(names[1]);
      case Availability.PREFIX -> (T) Availability.valueOf(names[1]);
      case DiscordChannelType.PREFIX -> (T) DiscordChannelType.valueOf(names[1]);
      default -> null;
    };
  }

  private final String name;

  Type(String name) {
    this.name = name;
  }

  /**
   * Gets name
   * <p>Must not be longer than 20 characters.</p>
   *
   * @return
   */
  public String getShortName() {
    return this.name;
  }

  public String getName() {
    return this.getType() + DIVIDER + this.getShortName();
  }

  protected abstract String getType();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Type type = (Type) o;
    return Objects.equals(name, type.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
