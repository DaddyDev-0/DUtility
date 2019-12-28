package daddy.devmas.dutility.events.chat;

import daddy.devmas.dutility.DUtility;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListen implements Listener {

    private DUtility du;
    private YamlConfiguration config;
    public ChatListen(DUtility du) {
        this.du = du;
        this.config = du.getFiles().getConfig();
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String msg = e.getMessage();
        String langCode = config.contains("translator.default-lang") ? config.getString("translator.default-lang") : "EN";

        e.setMessage(this.du.getTranslator().translate(msg, this.du.getTranslator().getLanguageFromCode(langCode)));
    }
}
