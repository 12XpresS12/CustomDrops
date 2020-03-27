package sk.xpress.majncraft.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class CancelCoalDrop implements Listener {

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e){
        if(e.getBlock().getType() == Material.COAL_ORE){
            e.setDropItems(false);
        }
    }
}
