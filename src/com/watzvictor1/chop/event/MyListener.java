package com.watzvictor1.chop.event;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;


public class MyListener implements Listener {

	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent evt) {
		Block block_destroyed = evt.getBlock();
		if (!isLog(block_destroyed)) return;
		ItemStack item = evt.getPlayer().getInventory().getItemInMainHand();
		if (!isAxe(item)) return;
		Location tree_location = block_destroyed.getLocation();
		chopTree(tree_location);
	}

	private boolean isLog(Block block) {
		switch (block.getType()) {
		case ACACIA_LOG:
			return true;
		case BIRCH_LOG:
			return true;
		case DARK_OAK_LOG:
			return true;
		case JUNGLE_LOG:
			return true;
		case OAK_LOG:
			return true;
		case SPRUCE_LOG:
			return true;
		default:
			return false;
		}
	}
	
	private boolean isAxe(ItemStack item) {
		switch (item.getType()) {
		case NETHERITE_AXE:
			return true;
		case DIAMOND_AXE:
			return true;
		case GOLDEN_AXE:
			return true;
		case IRON_AXE:
			return true;
		case WOODEN_AXE:
			return true;
		case STONE_AXE:
			return true;
		default:
			return false;
		}
	}

	private void chopTree(Location tree_location) {
		Block block = tree_location.getBlock();
		if (!isLog(block)) return;
		block.breakNaturally();	
		chopTree(tree_location.clone().add(-1,1,0)); // 
		chopTree(tree_location.clone().add(-1,0,0)); // 
		chopTree(tree_location.clone().add(-1,-1,0)); // Matriz en el eje 0
		chopTree(tree_location.clone().add(0,1,0)); // 
		chopTree(tree_location.clone().add(0,0,0)); // 
		chopTree(tree_location.clone().add(0,-1,0)); // 
		chopTree(tree_location.clone().add(1,1,0)); // 
		chopTree(tree_location.clone().add(1,0,0)); // 
		chopTree(tree_location.clone().add(1,-1,0)); // 

		chopTree(tree_location.clone().add(-1,1,-1)); // 
		chopTree(tree_location.clone().add(-1,0,-1)); // 
		chopTree(tree_location.clone().add(-1,-1,-1)); // Matriz en el eje -1 
		chopTree(tree_location.clone().add(0,1,-1)); // 
		chopTree(tree_location.clone().add(0,0,-1)); // 
		chopTree(tree_location.clone().add(0,-1,-1)); // 
		chopTree(tree_location.clone().add(1,1,-1)); // 
		chopTree(tree_location.clone().add(1,0,-1)); // 
		chopTree(tree_location.clone().add(1,-1,-1)); // 
		
		chopTree(tree_location.clone().add(-1,1,1)); // 
		chopTree(tree_location.clone().add(-1,0,1)); // 
		chopTree(tree_location.clone().add(-1,-1,1)); // Matriz en el eje 1
		chopTree(tree_location.clone().add(0,1,1)); // 
		chopTree(tree_location.clone().add(0,0,1)); // 
		chopTree(tree_location.clone().add(0,-1,1)); // 
		chopTree(tree_location.clone().add(1,1,1)); // 
		chopTree(tree_location.clone().add(1,0,1)); // 
		chopTree(tree_location.clone().add(1,-1,1)); // 

		
	}
}
