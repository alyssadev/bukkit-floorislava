package me.ads;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.entity.Player;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.Material;

public class FloorIsLava extends JavaPlugin implements Listener {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		Block standingon = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
		if (standingon.getType() == Material.GRASS ||
		    standingon.getType() == Material.GRASS_BLOCK ||
		    standingon.getType() == Material.STONE ||
		    standingon.getType() == Material.SAND) {
			p.setFireTicks(p.getMaxFireTicks());
		}
	}
}
