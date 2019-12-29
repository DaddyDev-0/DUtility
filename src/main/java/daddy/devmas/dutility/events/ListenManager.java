package daddy.devmas.dutility.events;

import daddy.devmas.dutility.DUtility;
import daddy.devmas.dutility.events.chat.ChatListen;
import daddy.devmas.dutility.events.user.UserJoin;
import org.bukkit.plugin.PluginManager;

public class ListenManager {

    public ListenManager(DUtility du) {
        PluginManager pm = du.getServer().getPluginManager();

        ChatListen chatListen = new ChatListen(du);
        pm.registerEvents(chatListen, du);

        UserJoin userJoin = new UserJoin(du);
        pm.registerEvents(userJoin, du);
    }
}
