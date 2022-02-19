package de.timesnake.library.basic.util;

import java.util.HashMap;

public abstract class Status {

    public static final String DIVIDER = "$";

    protected final String name;

    protected Status(String name) {
        this.name = name;
    }

    public abstract String getName();

    public abstract String getSimpleName();

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


    public static class User extends Status {
        private static final String PREFIX = "user";

        public static final User OFFLINE = new User("offline");
        public static final User ONLINE = new User("online");
        public static final User IN_GAME = new User("ingame");
        public static final User OUT_GAME = new User("outgame");
        public static final User PRE_GAME = new User("pregame");
        public static final User SPECTATOR = new User("spectator");

        public static final HashMap<String, User> STATUS_BY_STRING = new HashMap<>();

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

        public static Status.User[] values() {
            return new Status.User[]{OFFLINE, ONLINE, IN_GAME, OUT_GAME, PRE_GAME, SPECTATOR};
        }

        public static User parseValue(String statusValue) {
            return STATUS_BY_STRING.get(statusValue.replace(PREFIX + DIVIDER, ""));
        }
    }

    public static class Server extends Status {
        private static final String PREFIX = "server";

        public static final Server OFFLINE = new Server("offline");
        public static final Server STARTING = new Server("starting");
        public static final Server ONLINE = new Server("online");
        public static final Server SERVICE = new Server("service");
        public static final Server IN_GAME = new Server("ingame");
        public static final Server PRE_GAME = new Server("pregame");
        public static final Server POST_GAME = new Server("postgame");

        Server(String status) {
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

        public static Status.Server[] values() {
            return new Status.Server[]{OFFLINE, STARTING, ONLINE, SERVICE, IN_GAME, PRE_GAME, POST_GAME};
        }

        public static final HashMap<String, Server> STATUS_BY_STRING = new HashMap<>();

        static {
            for (Status.Server status : values()) {
                STATUS_BY_STRING.put(status.getSimpleName(), status);
            }
        }

        public static Server parseValue(String statusValue) {
            return STATUS_BY_STRING.get(statusValue.replace(PREFIX + DIVIDER, ""));
        }
    }

    public static class Permission extends Status {
        private static final String PREFIX = "permission";

        public static final Permission ONLINE = new Permission("online");
        public static final Permission SERVICE = new Permission("service");
        public static final Permission IN_GAME = new Permission("ingame");

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

        public static Status.Permission[] values() {
            return new Status.Permission[]{ONLINE, SERVICE, IN_GAME};
        }

        public static final HashMap<String, Permission> STATUS_BY_STRING = new HashMap<>();

        static {
            for (Status.Permission status : values()) {
                STATUS_BY_STRING.put(status.getSimpleName(), status);
            }
        }

        public static Permission parseValue(String statusValue) {
            return STATUS_BY_STRING.get(statusValue.replace(PREFIX + DIVIDER, ""));
        }

    }


    public static class Ticket extends Status {
        private static final String PREFIX = "ticket";

        public static final Ticket OPEN = new Ticket("open", "Open", "§2");
        public static final Ticket IN_PROCESS = new Ticket("in_process", "In Process", "§6");
        public static final Ticket SOLVED = new Ticket("solved", "Solved", "§c");
        public static final Ticket ADMIN = new Ticket("admin", "Admin", "§9");
        public static final Ticket DELETE = new Ticket("deleted", "Delete", "§4");


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

        public static Status.Ticket[] values() {
            return new Status.Ticket[]{OPEN, IN_PROCESS, SOLVED, ADMIN, DELETE};
        }

        public static final HashMap<String, Ticket> STATUS_BY_STRING = new HashMap<>();

        static {
            for (Status.Ticket status : values()) {
                STATUS_BY_STRING.put(status.getSimpleName(), status);
            }
        }

        public static Ticket parseValue(String statusValue) {
            return STATUS_BY_STRING.get(statusValue.replace(PREFIX + DIVIDER, ""));
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

