package de.timesnake.library.basic.util.chat;

import de.timesnake.library.basic.util.cmd.Argument;
import de.timesnake.library.basic.util.cmd.Arguments;
import de.timesnake.library.basic.util.cmd.Sender;

public class Chat {

    public String getSplitter() {
        return ChatColor.DARK_GRAY + "» " + ChatColor.RESET;
    }

    public String getOtherSplitter() {
        return ChatColor.DARK_PURPLE + "» " + ChatColor.RESET;
    }

    public String getLineSeparator() {
        return ChatColor.WHITE + "----------";
    }

    public String getLongLineSeparator() {
        return ChatColor.WHITE + "---------------";
    }

    public String getDoubleLineSeparator() {
        return ChatColor.WHITE + "==========";
    }

    public String getSenderPlugin(Plugin plugin) {
        return ChatColor.DARK_AQUA + plugin.getName() + this.getSplitter();
    }

    public String getMessageCode(String codeType, int code, Plugin plugin) {
        return "(Code: " + codeType + code + " " + plugin.getCode() + ")";
    }

    public Arguments<Argument> createArguments(Sender sender, Argument... args) {
        return new Arguments<>(sender, args);
    }

}
