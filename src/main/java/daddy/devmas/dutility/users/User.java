package daddy.devmas.dutility.users;

import com.github.vbauer.yta.model.Language;
import daddy.devmas.dutility.DUtility;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class User {

    private Player player;
    private UUID uuid;
    private Language lang;

    private File file;
    private YamlConfiguration data;

    public User(DUtility du, Player player) {
        this.player = player;
        this.uuid = player.getUniqueId();

        this.file = new File(du.getFiles().getUserFolder(), player.getUniqueId().toString() + ".yml");
        if(!this.file.exists()) {
            try {

                this.file.createNewFile();
                this.data = YamlConfiguration.loadConfiguration(this.file);

                this.data.set("uuid", player.getUniqueId().toString());
                this.data.set("lang", "EN");

                this.save();

            } catch (IOException e) { e.printStackTrace(); }
        }

        this.data = YamlConfiguration.loadConfiguration(this.file);
        this.lang = Language.ALL.get(this.data.getString("lang"));
    }

    public void save() {
        this.data.set("lang", this.lang.code());

        try{
            this.data.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UUID getUuid() { return uuid;  }
    public Language getLang() { return lang; }

    public void setLang(Language lang) {
        this.data.set("lang", lang.code());
        save();
        this.lang = lang;
    }

}
