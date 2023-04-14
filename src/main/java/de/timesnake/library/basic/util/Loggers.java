/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface Loggers {

    Logger BUKKIT = LogHelper.getLogger("Bukkit", Level.INFO);

    Logger NETWORK = LogHelper.getLogger("Network", Level.INFO);

    Logger PRIVATE_MESSAGES = LogHelper.getLogger("Msg", Level.INFO);
    Logger CHATS = LogHelper.getLogger("Chats", Level.INFO);

    Logger SCOREBOARD = LogHelper.getLogger("Scoreboard");
    Logger SYSTEM = LogHelper.getLogger("System");
    Logger GROUPS = LogHelper.getLogger("Groups");
    Logger USERS = LogHelper.getLogger("Users");
    Logger COMMAND = LogHelper.getLogger("Command");
    Logger PACKETS = LogHelper.getLogger("Packets");
    Logger WORLDS = LogHelper.getLogger("Worlds");
    Logger MAPS = LogHelper.getLogger("Maps");
    Logger KITS = LogHelper.getLogger("Kits");
    Logger TEAMS = LogHelper.getLogger("Teams");
    Logger GAME = LogHelper.getLogger("Game");
    Logger ANTI_CHEAT = LogHelper.getLogger("AntiCheat");
    Logger WARPS = LogHelper.getLogger("Warps");
    Logger SURVIVAL = LogHelper.getLogger("Survival");
    Logger SHOP = LogHelper.getLogger("Shop");
    Logger LOBBY = LogHelper.getLogger("Lobby");
    Logger LOUNGE = LogHelper.getLogger("Lounge");
    Logger LOUNGE_BRIDGE = LogHelper.getLogger("LoungeBridge");
    Logger PERMISSIONS = LogHelper.getLogger("Permissions");

}
