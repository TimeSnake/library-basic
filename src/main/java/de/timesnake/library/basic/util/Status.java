/*
 * library-basic.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

package de.timesnake.library.basic.util;

import java.util.HashMap;

public abstract class Status {

    public static final String DIVIDER = "$";

    public static <T extends Status> T parseStatus(String name) {
        String[] names = name.split(DIVIDER);

        if (names.length < 2) {
            return null;
        }

        switch (names[0]) {
            case User.PREFIX:
                return (T) User.parseValue(names[1]);
            case Server.PREFIX:
                return (T) Server.parseValue(names[1]);
            case Permission.PREFIX:
                return (T) Permission.parseValue(names[1]);
            case Ticket.PREFIX:
                return (T) Ticket.parseValue(names[1]);
        }

        return null;
    }

    protected final String name;

    protected Status(String name) {
        this.name = name;
    }

    public abstract String getName();

    public abstract String getSimpleName();

    public static class User extends Status {
        public static final User OFFLINE = new User("offline");
        public static final User ONLINE = new User("online");
        public static final User IN_GAME = new User("ingame");
        public static final User OUT_GAME = new User("outgame");
        public static final User PRE_GAME = new User("pregame");
        public static final User SPECTATOR = new User("spectator");
        public static final HashMap<String, User> STATUS_BY_STRING = new HashMap<>();

        public static Status.User[] values() {
            return new Status.User[]{OFFLINE, ONLINE, IN_GAME, OUT_GAME, PRE_GAME, SPECTATOR};
        }

        public static User parseValue(String statusValue) {
            return STATUS_BY_STRING.get(statusValue.replace(PREFIX + DIVIDER, ""));
        }

        private static final String PREFIX = "user";

        static {
            for (Status.User status : values()) {
                STATUS_BY_STRING.put(status.getSimpleName(), status);
            }
        }

        User(String status) {
            super(status);
        }

        @Override
        public String getName() {
            return PREFIX + DIVIDER + this.name;
        }

        @Override
        public String getSimpleName() {
            return name;
        }
    }

    public static class Server extends Status {
        public static final Server OFFLINE = new Server("offline", false);
        public static final Server LAUNCHING = new Server("launching", false);
        public static final Server LOADING = new Server("loading", false);
        public static final Server ONLINE = new Server("online", true);
        public static final Server SERVICE = new Server("service", true);
        public static final Server IN_GAME = new Server("ingame", true);
        public static final Server PRE_GAME = new Server("pregame", true);
        public static final Server POST_GAME = new Server("postgame", true);
        public static final HashMap<String, Server> STATUS_BY_STRING = new HashMap<>();

        public static Status.Server[] values() {
            return new Status.Server[]{OFFLINE, LAUNCHING, LOADING, ONLINE, SERVICE, IN_GAME, PRE_GAME, POST_GAME};
        }

        public static Server parseValue(String statusValue) {
            return STATUS_BY_STRING.get(statusValue.replace(PREFIX + DIVIDER, ""));
        }

        private static final String PREFIX = "server";

        static {
            for (Status.Server status : values()) {
                STATUS_BY_STRING.put(status.getSimpleName(), status);
            }
        }

        private final boolean running;

        Server(String status, boolean running) {
            super(status);
            this.running = running;
        }

        @Override
        public String getName() {
            return PREFIX + DIVIDER + this.name;
        }

        @Override
        public String getSimpleName() {
            return name;
        }

        public boolean isRunning() {
            return this.running;
        }
    }

    public static class Permission extends Status {
        public static final Permission ONLINE = new Permission("online");
        public static final Permission SERVICE = new Permission("service");
        public static final Permission IN_GAME = new Permission("ingame");
        public static final HashMap<String, Permission> STATUS_BY_STRING = new HashMap<>();

        public static Status.Permission[] values() {
            return new Status.Permission[]{ONLINE, SERVICE, IN_GAME};
        }

        public static Permission parseValue(String statusValue) {
            return STATUS_BY_STRING.get(statusValue.replace(PREFIX + DIVIDER, ""));
        }

        private static final String PREFIX = "permission";

        static {
            for (Status.Permission status : values()) {
                STATUS_BY_STRING.put(status.getSimpleName(), status);
            }
        }

        Permission(String status) {
            super(status);
        }

        @Override
        public String getName() {
            return PREFIX + DIVIDER + this.name;
        }

        @Override
        public String getSimpleName() {
            return name;
        }

    }


    public static class Ticket extends Status {
        public static final Ticket OPEN = new Ticket("open", "Open", "§2");
        public static final Ticket IN_PROCESS = new Ticket("in_process", "In Process", "§6");
        public static final Ticket SOLVED = new Ticket("solved", "Solved", "§c");
        public static final Ticket ADMIN = new Ticket("admin", "Admin", "§9");
        public static final Ticket DELETE = new Ticket("deleted", "Delete", "§4");
        public static final HashMap<String, Ticket> STATUS_BY_STRING = new HashMap<>();

        public static Status.Ticket[] values() {
            return new Status.Ticket[]{OPEN, IN_PROCESS, SOLVED, ADMIN, DELETE};
        }

        public static Ticket parseValue(String statusValue) {
            return STATUS_BY_STRING.get(statusValue.replace(PREFIX + DIVIDER, ""));
        }

        private static final String PREFIX = "ticket";

        static {
            for (Status.Ticket status : values()) {
                STATUS_BY_STRING.put(status.getSimpleName(), status);
            }
        }

        private final String name;
        private final String chatColor;

        Ticket(String status, String name, String chatColor) {
            super(status);
            this.name = name;
            this.chatColor = chatColor;
        }

        public String getDisplayName() {
            return name;
        }

        public String getChatColor() {
            return chatColor;
        }

        @Override
        public String getName() {
            return PREFIX + DIVIDER + name;
        }

        @Override
        public String getSimpleName() {
            return name;
        }
    }

}

