package de.rang.gmr.commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Rang implements CommandExecutor {
	
	File file = new File("plugins//RangSystem//config.yml");
	YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String args[]) {
		if(cmd.getName().equalsIgnoreCase("rang")) {
			String Prefix = yaml.getString("Prefix").replace("&", "§");
			if(sender.hasPermission(yaml.getString("Permission"))) {
				if(args.length == 0) {
					sender.sendMessage(Prefix + yaml.getString("Nachrichten.Hilfe"));
				}else if(args.length == 1) {
					Player t = Bukkit.getPlayer(args[0]);
					if(t != null) {
						PermissionsEx.getUser(t).addGroup(args[1]);
						sender.sendMessage(Prefix + yaml.getString("Nachrichten.RangVergeben").replace("&", "§").replace("%player%", t.getName()).replace("%rang%", args[1]));
					}else {
						sender.sendMessage(Prefix + yaml.getString("Nachrichten.NichtOnline").replace("&", "§").replace("%player%", args[0]));
					}
				}
			}else {
				sender.sendMessage(Prefix + yaml.getString("Nachrichten.NoPerm"));
			}
		}
		return false;
	}

}
