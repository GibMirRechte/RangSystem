package de.rang.gmr.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.rang.gmr.main.Main;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Rang implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String args[]) {
		if(cmd.getName().equalsIgnoreCase("rang")) {
			if(sender.hasPermission("df.perm.rang")) {
				if(args.length == 0) {
					sender.sendMessage(Main.Prefix + "Bitte benutze /rang <Spieler> <Rang>");
				}else if(args.length == 1) {
					Player t = Bukkit.getPlayer(args[0]);
					if(t != null) {
						PermissionsEx.getUser(t).addGroup(args[1]);
						sender.sendMessage(Main.Prefix + "Der Spieler §c" + t.getName() + " §7hat nun §c" + args[1] + "§7.");
					}else {
						sender.sendMessage(Main.Prefix + "Dieser Spieler ist nicht online!");
					}
				}
			}else {
				sender.sendMessage(Main.Prefix + "Dazu hast du keine Berechtigung!");
			}
		}
		return false;
	}

}
