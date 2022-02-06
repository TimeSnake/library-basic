package de.timesnake.library.basic.util.cmd;

public interface CommandSender {

    void sendMessage(String s);

    void sendMessage(String[] strings);

    String getName();

    boolean hasPermission(String s);

    boolean isConsole();

    <User extends de.timesnake.library.basic.util.player.User> User getUser();

    <Player> Player getPlayer();
}


    

