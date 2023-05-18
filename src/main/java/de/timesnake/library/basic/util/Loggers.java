/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface Loggers {

  Logger BUKKIT = LogHelper.getLogger("Bukkit", Level.INFO);
  Logger NETWORK = LogHelper.getLogger("Network", Level.INFO);
  Logger SYSTEM = LogHelper.getLogger("System");

  Logger PRIVATE_MESSAGES = LogHelper.getLogger("Msg", Level.INFO);
  Logger CHATS = LogHelper.getLogger("Chats", Level.INFO);
  Logger DISCORD = LogHelper.getLogger("Discord", Level.INFO);

  Logger SCOREBOARD = LogHelper.getLogger("Scoreboard");
  Logger COMMAND = LogHelper.getLogger("Command");
  Logger PERMISSIONS = LogHelper.getLogger("Permissions");

  Logger USERS = LogHelper.getLogger("Users");
  Logger GROUPS = LogHelper.getLogger("Groups");

  Logger WORLDS = LogHelper.getLogger("Worlds");
  Logger PLOTS = LogHelper.getLogger("Plots");

  Logger GAME = LogHelper.getLogger("Game", Level.INFO);
  Logger KITS = LogHelper.getLogger("Kits", Level.INFO);
  Logger MAPS = LogHelper.getLogger("Maps", Level.INFO);
  Logger TEAMS = LogHelper.getLogger("Teams", Level.INFO);

  Logger PACKETS = LogHelper.getLogger("Packets");
  Logger CHANNEL = LogHelper.getLogger("Channel");

  Logger ANTI_CHEAT = LogHelper.getLogger("AntiCheat");
  Logger WARPS = LogHelper.getLogger("Warps");
  Logger SURVIVAL = LogHelper.getLogger("Survival");
  Logger SHOP = LogHelper.getLogger("Shop");
  Logger LOBBY = LogHelper.getLogger("Lobby");
  Logger LOUNGE = LogHelper.getLogger("Lounge");
  Logger LOUNGE_BRIDGE = LogHelper.getLogger("LoungeBridge");

}
