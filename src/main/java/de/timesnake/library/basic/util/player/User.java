package de.timesnake.library.basic.util.player;

import de.timesnake.database.util.user.DbUser;

import java.util.UUID;

public interface User {

    String getChatName();

    UUID getUniqueId();

    DbUser getDatabase();

}
