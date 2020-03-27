package sk.xpress.majncraft.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import sk.xpress.majncraft.Main;
import sk.xpress.majncraft.handler.PlayerConfig;
import sk.xpress.majncraft.handler.PlayerData;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e){
        Player p = e.getPlayer();
        loadConfigData(p);
    }

    public void loadConfigData(Player p){
        PlayerConfig user = new PlayerConfig(p.getUniqueId());
        user.saveUserFile();
        user.createUser(p);

        if(!Main.getPlayerData().containsKey(p)){
            Main.getPlayerData().put(p, new PlayerData());
            Main.getPlayerData(p).setCustomDrops(user.getUserFile().getBoolean("user.info.customDrops"));
        }
    }
}
