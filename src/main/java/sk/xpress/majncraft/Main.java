package sk.xpress.majncraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import sk.xpress.majncraft.handler.Drop;
import sk.xpress.majncraft.handler.Drops;
import sk.xpress.majncraft.listeners.DropChangeListener;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    public List<Drops> dropList = new ArrayList<Drops>();
    private static Main instance;

    public void onEnable(){
        this.instance = this;
        registerListeners();
        loadDropList();

        this.saveDefaultConfig();
    }

    public void onDisable(){

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
                print("MAT: " + mat + " DROPS: " + splitter[1]);
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
    }

    public static Main getInstance() {
        return instance;
    }
}
