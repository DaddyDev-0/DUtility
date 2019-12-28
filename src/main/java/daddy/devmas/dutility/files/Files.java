package daddy.devmas.dutility.files;

import daddy.devmas.dutility.DUtility;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Files {

    //- Folders
    private File dataFolder;

    //- Files
    private File configF;
    private YamlConfiguration config;

    public Files(DUtility du) {

        //- Folders
        dataFolder = du.getDataFolder();
        if(!dataFolder.exists()) dataFolder.mkdirs();

        //- Files
        configF = new File(dataFolder, "Config.yml");
        if(!configF.exists()) du.saveResource("Config.yml", false);
        config = YamlConfiguration.loadConfiguration(configF);
    }

    public File getDataFolder() {
        return dataFolder;
    }

    public File getConfigF() {
        return configF;
    }

    public YamlConfiguration getConfig() {
        return config;
    }

    public boolean saveConfig() {
        try {
            config.save(configF);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configF);
    }
}
