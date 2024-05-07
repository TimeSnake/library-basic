/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import net.kyori.adventure.util.Index;

import java.io.Serializable;
import java.util.Objects;

public abstract class Status implements Serializable {

  public static final String DIVIDER = "_";

  public static <T extends Status> T valueOf(String name) {
    if (name == null) {
      return null;
    }

    String[] names = name.split(DIVIDER);

    if (names.length < 2) {
      return null;
    }

    return switch (names[0]) {
      case User.PREFIX -> (T) User.valueOf(names[1]);
      case Server.PREFIX -> (T) Server.valueOf(names[1]);
      case Permission.PREFIX -> (T) Permission.valueOf(names[1]);
      case Ticket.PREFIX -> (T) Ticket.valueOf(names[1]);
      default -> null;
    };

  }

  protected final String name;

  protected Status(String name) {
    this.name = name;
  }

  /**
   * Gets name
   * <p>Must not be longer than 20 characters.</p>
   *
   * @return
   */
  public String getName() {
    return this.getType() + DIVIDER + this.getShortName();
  }

  public String getShortName() {
    return this.name;
  }

  @Override
  public String toString() {
    return this.getShortName();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Status status = (Status) o;
    return Objects.equals(this.getName(), status.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getName());
  }

  protected abstract String getType();

  public static class User extends Status implements Serializable {

    public static final User OFFLINE = new User("offline");
    public static final User ONLINE = new User("online");
    public static final User IN_GAME = new User("ingame");
    public static final User OUT_GAME = new User("outgame");
    public static final User PRE_GAME = new User("pregame");
    public static final User SPECTATOR = new User("spectator");

    public static User valueOf(String name) {
      if (name == null) {
        return null;
      }
      return STATUS_BY_STRING.value(name.replace(PREFIX + DIVIDER, ""));
    }

    public static User[] values() {
      return VALUES;
    }

    private static final User[] VALUES = {OFFLINE, ONLINE, IN_GAME, OUT_GAME, PRE_GAME, SPECTATOR};
    private static final Index<String, User> STATUS_BY_STRING = Index.create(Status::getShortName, VALUES);

    private static final String PREFIX = "user";

    User(String status) {
      super(status);
    }

    @Override
    protected String getType() {
      return PREFIX;
    }
  }

  public static class Server extends Status implements Serializable {

    public static final Server OFFLINE = new Server("offline", false, false);
    public static final Server LAUNCHING = new Server("launching", false, false);
    public static final Server LOADING = new Server("loading", false, false);
    public static final Server ONLINE = new Server("online", true, false);
    public static final Server SERVICE = new Server("service", true, false);
    public static final Server IN_GAME = new Server("ingame", true, true);
    public static final Server PRE_GAME = new Server("pregame", true, true);
    public static final Server POST_GAME = new Server("postgame", true, true);

    public static Server valueOf(String name) {
      if (name == null) {
        return null;
      }
      return STATUS_BY_STRING.value(name.replace(PREFIX + DIVIDER, ""));
    }

    public static Server[] values() {
      return VALUES;
    }

    private static final Server[] VALUES = {OFFLINE, LAUNCHING, LOADING, ONLINE, SERVICE, IN_GAME, PRE_GAME, POST_GAME};
    private static final Index<String, Server> STATUS_BY_STRING = Index.create(Status::getShortName, VALUES);

    private static final String PREFIX = "server";

    private final boolean running;
    private final boolean gameState;

    Server(String status, boolean running, boolean gameState) {
      super(status);
      this.running = running;
      this.gameState = gameState;
    }

    public boolean isRunning() {
      return running;
    }

    public boolean isGameState() {
      return gameState;
    }

    @Override
    protected String getType() {
      return PREFIX;
    }
  }

  public static class Permission extends Status {

    public static final Permission ONLINE = new Permission("online");
    public static final Permission SERVICE = new Permission("service");
    public static final Permission IN_GAME = new Permission("ingame");

    public static Permission valueOf(String name) {
      if (name == null) {
        return null;
      }
      return STATUS_BY_STRING.value(name.replace(PREFIX + DIVIDER, ""));
    }

    public static Permission[] values() {
      return VALUES;
    }

    private static final Permission[] VALUES = {ONLINE, SERVICE, IN_GAME};
    private static final Index<String, Permission> STATUS_BY_STRING = Index.create(Status::getShortName, VALUES);

    private static final String PREFIX = "permission";

    Permission(String status) {
      super(status);
    }

    @Override
    protected String getType() {
      return PREFIX;
    }

  }

  public static class Ticket extends Status {

    public static final Ticket OPEN = new Ticket("open", "Open");
    public static final Ticket IN_PROCESS = new Ticket("in_process", "In Process");
    public static final Ticket SOLVED = new Ticket("solved", "Solved");
    public static final Ticket ADMIN = new Ticket("admin", "Admin");
    public static final Ticket DELETE = new Ticket("deleted", "Delete");

    public static Ticket valueOf(String name) {
      if (name == null) {
        return null;
      }
      return STATUS_BY_STRING.value(name.replace(PREFIX + DIVIDER, ""));
    }

    public static Ticket[] values() {
      return VALUES;
    }

    private static final Ticket[] VALUES = {OPEN, IN_PROCESS, SOLVED, ADMIN, DELETE};
    private static final Index<String, Ticket> STATUS_BY_STRING = Index.create(Status::getShortName, VALUES);

    private static final String PREFIX = "ticket";

    private final String name;

    Ticket(String status, String name) {
      super(status);
      this.name = name;
    }

    public String getDisplayName() {
      return name;
    }

    @Override
    protected String getType() {
      return PREFIX;
    }
  }

}

