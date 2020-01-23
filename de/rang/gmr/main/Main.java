package de.rang.gmr.main;

import org.bukkit.plugin.java.JavaPlugin;
import de.rang.gmr.commands.Rang;

public class Main extends JavaPlugin {
	
	public static final String Prefix = "§9•§b● §9RangSystem §8» §7";
	
	public void onEnable() {
		getCommand("rang").setExecutor(new Rang());
	}

}
