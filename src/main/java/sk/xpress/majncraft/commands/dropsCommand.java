package sk.xpress.majncraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sk.xpress.majncraft.Main;
import sk.xpress.majncraft.handler.PlayerConfig;

public class dropsCommand implements CommandExecutor {



    public boolean onCommand(CommandSender sender, Command cmd, String labe, String[] args) {

        if(cmd.getName().equalsIgnoreCase("drops")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;

                if (Main.getPlayerData(p).isCustomDrops()) {
                    Main.getPlayerData(p).setCustomDrops(false);
                    String send = Main.getInstance().getConfig().getString("lang.customdrops.off");
                    p.sendMessage(send);
                    //p.sendMessage("§aPráve si si §c§lvypól§a custom drops!");
                } else {
                    Main.getPlayerData(p).setCustomDrops(true);
                    String send = Main.getInstance().getConfig().getString("lang.customdrops.on");
                    p.sendMessage(send);
                    //p.sendMessage("§aPráve si si §a§lzapól§a custom drops!");
                }

            }
        }

        return false;
    }

}
