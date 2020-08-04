package com.watzvictor1.chop;

import org.bukkit.plugin.java.JavaPlugin;

import com.watzvictor1.chop.event.MyListener;

public class Chop_Main extends JavaPlugin {

	public static Chop_Main INSTANCE;
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
	}

	@Override
	public void onEnable() {
		INSTANCE = this;
		this.getServer().getPluginManager().registerEvents(new MyListener(),  this);
		super.onEnable();
	}

}
