package de.timesnake.library.basic.util.server;

import de.timesnake.library.basic.util.chat.Chat;

public interface Server {

    String WEBSITE_LINK = "https://timesnake.de";
    String SUPPORT_EMAIL = "support@mail.timesnake.de";
    String DISCORD_LINK = "https://discord.gg/YRCZhFVE9z";
    String PATREON_LINK = "https://www.patreon.com/user?u=59222684";

    static Chat getChat() {
        return new Chat();
    }
}
