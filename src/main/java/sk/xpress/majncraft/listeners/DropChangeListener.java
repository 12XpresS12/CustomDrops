package sk.xpress.majncraft.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import sk.xpress.majncraft.Main;
import sk.xpress.majncraft.handler.Drop;
import sk.xpress.majncraft.handler.Drops;

import java.util.Random;

public class DropChangeListener implements Listener {

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e){
        if(!Main.getPlayerData(e.getPlayer()).isCustomDrops()) return;

        Location bLoc = e.getBlock().getLocation();
        Random rand = new Random();
        if(Main.getInstance().dropList == null) return;
        for(Drops itemDrop : Main.getInstance().dropList){

            if(e.getBlock().getType() != itemDrop.getMaterial()) continue;
            for(Drop drop : itemDrop.getDrops()){
                if(rand.nextDouble() * 100 < drop.getChance()){
                    e.getBlock().getDrops().clear();

                    ItemStack is = new ItemStack(drop.getMat());
                    is.setAmount(1);
                    if(is.getType() == Material.AIR) continue;
                    bLoc.getWorld().dropItem(bLoc, is);
                    break;
                } else continue;


            }
        }
    }
}
