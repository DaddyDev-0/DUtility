package daddy.devmas.dutility.events.chat;

import com.github.vbauer.yta.model.Language;
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
        Language lang = this.du.getUserManager().getUser(e.getPlayer().getUniqueId()) != null ? this.du.getUserManager().getUser(e.getPlayer().getUniqueId()).getLang()
                : this.du.getTranslator().getLanguageFromCode(langCode);

        e.setMessage(this.du.getTranslator().translate(msg, lang));
    }
}
