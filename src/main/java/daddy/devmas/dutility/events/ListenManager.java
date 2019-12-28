package daddy.devmas.dutility.events;

import daddy.devmas.dutility.DUtility;
import daddy.devmas.dutility.events.chat.ChatListen;
import org.bukkit.plugin.PluginManager;

public class ListenManager {

    private ChatListen chatListen;

    public ListenManager(DUtility du) {
        PluginManager pm = du.getServer().getPluginManager();

        chatListen = new ChatListen(du);
        pm.registerEvents(chatListen, du);
    }
}
