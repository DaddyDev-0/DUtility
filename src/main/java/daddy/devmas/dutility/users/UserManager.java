package daddy.devmas.dutility.users;

import com.github.vbauer.yta.model.Language;
import daddy.devmas.dutility.DUtility;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.UUID;

public class UserManager {

    private DUtility dUtility;
    private HashSet<User> users;

    public UserManager(DUtility dUtility) {
        this.dUtility = dUtility;
        this.users = new HashSet<>();
    }

    public HashSet<User> getUsers() {
        return users;
    }

    public User getUser(UUID uuid) {
        for(User u : users) {
            if(u.getUuid().toString().matches(uuid.toString())) return u;
        }
        return null;
    }

    public void createUser(Player pl) {
        User u = new User(this.dUtility, pl);
        users.add(u);
    }

    public void removeUser(Player pl) {
        User u = getUser(pl.getUniqueId());
        u.save();
        users.remove(u);
    }

    //- Player API
    public boolean playerExists(UUID uuid) {
        return new File(this.dUtility.getFiles().getUserFolder(), uuid.toString() + ".yml").exists();
    }

    public String getLangCoder(UUID uuid) {
        YamlConfiguration file = YamlConfiguration.loadConfiguration(new File(this.dUtility.getFiles().getUserFolder(), uuid.toString() + ".yml"));
        return file.getString("lang");
    }

    public File getUserFile(UUID uuid) {
        return new File(this.dUtility.getFiles().getUserFolder(), uuid.toString() + ".yml");
    }

    public YamlConfiguration getUserData(UUID uuid) {
        return YamlConfiguration.loadConfiguration(new File(this.dUtility.getFiles().getUserFolder(), uuid.toString() + ".yml"));
    }

    public boolean setLang(UUID uuid, Language language) {
        File f = new File(this.dUtility.getFiles().getUserFolder(), uuid.toString() + ".yml");
        YamlConfiguration d = YamlConfiguration.loadConfiguration(f);
        d.set("lang", language.code());

        try {
            d.save(f);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
