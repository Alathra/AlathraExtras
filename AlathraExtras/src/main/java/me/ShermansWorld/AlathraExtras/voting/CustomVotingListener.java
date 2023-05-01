package me.ShermansWorld.AlathraExtras.voting;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.bencodez.votingplugin.user.VotingPluginUser;

public class CustomVotingListener {
	
	public static ArrayList<Player> playersWithAllSitesVoted = new ArrayList<Player>();

	public static void checkForAllSitesVoted() {
		// MUST BE CALLED AFTER DELAY
		
		if (VotingListener.votingPlugin == null) {
			return;
		}
		
		if (VotingListener.votingUserManager == null) {
			return;
		}
		
		if (VotingListener.playersWhoVoted.isEmpty()) {
			return;
		}
		
		for (Player p : VotingListener.playersWhoVoted) {
			VotingPluginUser votingUser;
			try {
				votingUser = VotingListener.votingUserManager.getVotingPluginUser(p);
				if (votingUser.getSitesVotedOn() == 5) {
					if (playersWithAllSitesVoted.isEmpty()) {
						playersWithAllSitesVoted.add(p);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "broadcast &2Thank you &c" + p.getName() + " &2for voting for &bAlathra &2on all sites!");
					} else {
						if (!(playersWithAllSitesVoted.contains(p))) {
							playersWithAllSitesVoted.add(p);
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "broadcast &2Thank you &c" + p.getName() + " &2for voting for &bAlathra &2on all sites!");
						}
					}
				}
			} catch (NullPointerException e) {
			}
		}
	}
	
}
