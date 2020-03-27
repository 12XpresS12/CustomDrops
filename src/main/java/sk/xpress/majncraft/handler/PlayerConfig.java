package sk.xpress.majncraft.handler;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import sk.xpress.majncraft.Main;

import java.io.File;
import java.util.UUID;

public class PlayerConfig {
    UUID u;
    File userFile;
    FileConfiguration userConfig;

    public PlayerConfig(UUID u){
        this.u = u;
        userFile = new File(Main.getInstance().getDataFolder(), "players/" + u + ".yml");
        userConfig = YamlConfiguration.loadConfiguration(userFile);
    }

    public void createUser(Player player){
        if ( !(userFile.exists()) ) {
            try {
                YamlConfiguration UserConfig = YamlConfiguration.loadConfiguration(userFile);
                UserConfig.set("user.info.PreviousName", player.getName());
                UserConfig.set("user.info.UniqueID", player.getUniqueId().toString());
                UserConfig.set("user.info.customDrops", false);
               // UserConfig.save(userFile);

                saveUserFile();
            } catch (Exception e) {

                e.printStackTrace();

            }
        }
    }

    public FileConfiguration getUserFile(){
        return userConfig;
    }

    public void saveUserFile(){
        try {
            getUserFile().save(userFile);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
