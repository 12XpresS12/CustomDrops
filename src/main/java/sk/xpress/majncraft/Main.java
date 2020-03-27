package sk.xpress.majncraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import sk.xpress.majncraft.commands.dropsCommand;
import sk.xpress.majncraft.handler.Drop;
import sk.xpress.majncraft.handler.Drops;
import sk.xpress.majncraft.handler.PlayerData;
import sk.xpress.majncraft.listeners.DropChangeListener;
import sk.xpress.majncraft.listeners.PlayerJoinListener;
import sk.xpress.majncraft.listeners.PlayerLeaveListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends JavaPlugin {

    private static Map<Player, PlayerData> playerData = new HashMap<Player, PlayerData>();
    public List<Drops> dropList = new ArrayList<Drops>();
    private static Main instance;

    public void onEnable(){
        this.instance = this;

        registerListeners();
        registerCommands();

        loadDropList();
        this.saveDefaultConfig();

        for(Player p : Bukkit.getOnlinePlayers()) PlayerJoinListener.loadConfigData(p);
    }

    public void onDisable(){
        for(Player p : Bukkit.getOnlinePlayers()) PlayerLeaveListener.saveData(p);
    }

    public void loadDropList(){
        ConfigurationSection cs = Main.getInstance().getConfig().getConfigurationSection("drops");
        for(String dropMaterial : cs.getKeys(false)) {
            List<String> dropString = Main.getInstance().getConfig().getStringList("drops." + dropMaterial);

            List<Drop> drops = new ArrayList<Drop>();
            for(String s : dropString){
                String[] splitter = s.split(":");

                Material mat = Material.getMaterial(splitter[0]);
                if(mat == null) continue;

                drops.add(new Drop(mat, Integer.parseInt(splitter[1])));
            }

            Material mat = Material.getMaterial(dropMaterial);
            if(mat == null) continue;
            print(mat + " : " + drops.get(0));
            dropList.add(new Drops(mat, drops));
        }
    }

    public static void print(String s){
        Bukkit.getConsoleSender().sendMessage("§f[CustomDrops]§7 " + s);
    }

    public void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new DropChangeListener(), this);
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerLeaveListener(), this);
    }

    public void registerCommands(){
        this.getCommand("drops").setExecutor(new dropsCommand());
    }

    public static Main getInstance() {
        return instance;
    }

    public static PlayerData getPlayerData(Player p) {
        if(playerData.containsKey(p)){
            return playerData.get(p);
        }
        return null;
    }

    public static Map<Player, PlayerData> getPlayerData() {
        return playerData;
    }
}
