package sk.xpress.majncraft;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import sk.xpress.majncraft.listeners.CancelCoalDrop;

public class Main extends JavaPlugin {

    public void onEnable(){

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new CancelCoalDrop(), this);
    }

    public void onDisable(){

    }
}
