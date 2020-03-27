package sk.xpress.majncraft.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import sk.xpress.majncraft.Main;
import sk.xpress.majncraft.handler.PlayerConfig;

public class PlayerLeaveListener implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        saveData(e.getPlayer());
    }

    public static void saveData(Player p){
        PlayerConfig user = new PlayerConfig(p.getUniqueId());

        user.getUserFile().set("user.info.customDrops", Main.getPlayerData(p).isCustomDrops());
        user.saveUserFile();

        if(Main.getPlayerData().containsKey(p)) Main.getPlayerData().remove(p);
    }
}
