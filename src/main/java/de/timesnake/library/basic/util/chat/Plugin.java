package de.timesnake.library.basic.util.chat;

public class Plugin {

    public static final Plugin SYSTEM = new Plugin("System", "");
    public static final Plugin CONSOLE = new Plugin("Console", "");
    public static final Plugin BUKKIT = new Plugin("Bukkit", "BS");
    public static final Plugin PROXY = new Plugin("Proxy", "PR");
    public static final Plugin INFO = new Plugin("Info", "");
    public static final Plugin NETWORK = new Plugin("Network", "BN");
    public static final Plugin TIME_COINS = new Plugin("Coins", "BSC");
    public static final Plugin DATABASE = new Plugin("Database", "MDB");
    public static final Plugin PRIVATE_MESSAGES = new Plugin("Msg", "BPM");
    public static final Plugin MAILS = new Plugin("Mails", "BMA");

    private final String name;
    private final String code;

    protected Plugin(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

}

