package me.ShermansWorld.AlathraExtras.cm;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.Main;

public class CMVoteCommands implements CommandExecutor {

	public CMVoteCommands(Main plugin) {
		plugin.getCommand("cmvote").setExecutor(this);
	}

	private static void helpMsg(Player p) {
		p.sendMessage(Helper.Chatlabel() + Helper.color("&a&lYou can vote for multiple candidates!"));
		p.sendMessage(Helper.Chatlabel() + Helper.color("&a&lCommand Usage: &r&e/cmvote add [candidate]"));
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				helpMsg(p);
				return false;
			} else if (args.length == 1 || args[0].equals("help")) {
				helpMsg(p);
				return false;
			} else if (args.length == 2 && args[0].equalsIgnoreCase("add")) {
				if (!CMUtil.candidates.contains(args[1].toLowerCase())) {
					p.sendMessage(Helper.Chatlabel() + Helper.color("&cThe candidate you entered does not exist."));
					helpMsg(p);
					return false;
				}
				String candidate = args[1].toLowerCase();
				CMUtil.addVote(p, candidate);
			} else if (args.length == 2 && args[0].equalsIgnoreCase("remove")) {
				if (!CMUtil.candidates.contains(args[1].toLowerCase())) {
					p.sendMessage(Helper.Chatlabel() + Helper.color("&cThe candidate you entered does not exist."));
					helpMsg(p);
					return false;
				}
				String candidate = args[1].toLowerCase();
				CMUtil.removeVote(p, candidate);
			} else {
				helpMsg(p);
				return false;
			}
		}
		return false;
	}
}
