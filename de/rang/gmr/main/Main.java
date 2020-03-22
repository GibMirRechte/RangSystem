package de.rang.gmr.main;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import de.rang.gmr.commands.Rang;

public class Main extends JavaPlugin {
	
	File file = new File("plugins//RangSystem//config.yml");
	YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
	
	public void onEnable() {
		setConfig();
		getCommand("rang").setExecutor(new Rang());
	}
	public void setConfig() {
		if(!file.exists()) {
			file.mkdir();
			yaml.set("Prefix", "&9•&b● &9RangSystem &8» &7");
			yaml.set("Permission", "df.perm.rang");
			yaml.set("Nachrichten.Hilfe", "Bitte benutze /rang <Spieler> <Rang>");
			yaml.set("Nachrichten.RangVergeben", "%player% hat nun den Rang &c%rang%&7!");
			yaml.set("Nachrichten.Offline", "&c%player% ist nicht online!");
			yaml.set("Nachrichten.NoPerm", "&7Dazu hast du keine Berechtigung!");
		}
	}

}
