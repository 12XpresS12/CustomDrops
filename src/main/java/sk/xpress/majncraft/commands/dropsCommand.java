package sk.xpress.majncraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sk.xpress.majncraft.Main;
import sk.xpress.majncraft.handler.PlayerConfig;

public class dropsCommand implements CommandExecutor {



    public boolean onCommand(CommandSender sender, Command cmd, String labe, String[] args) {

        if(cmd.getName().equalsIgnoreCase("drops"))
        if(sender instanceof Player){
            Player p = (Player) sender;

            if(Main.getPlayerData(p).isCustomDrops()){
                Main.getPlayerData(p).setCustomDrops(false);
                p.sendMessage("§aPráve si si §c§lvypol§a custom drops!");
            }else {
                Main.getPlayerData(p).setCustomDrops(true);
                p.sendMessage("§aPráve si si §a§lzapol§a custom drops!");
            }

        }

        return false;
    }

}
