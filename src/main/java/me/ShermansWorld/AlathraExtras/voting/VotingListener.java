package me.ShermansWorld.AlathraExtras.voting;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.bencodez.votingplugin.VotingPluginMain;
import com.bencodez.votingplugin.events.PlayerVoteEvent;
import com.bencodez.votingplugin.user.UserManager;

import me.ShermansWorld.AlathraExtras.AlathraExtras;
public class VotingListener implements Listener {
	
public static VotingPluginMain votingPlugin = null;
public static UserManager votingUserManager = null;
public static ArrayList<Player> playersWhoVoted = new ArrayList<Player>();

	public static void initVotingPlugin() {
		if (votingPlugin == null) {
			votingPlugin = JavaPlugin.getPlugin(VotingPluginMain.class);
			votingUserManager = votingPlugin.getVotingPluginUserManager();
		}
	}
	
	@EventHandler
	public static void onVote(PlayerVoteEvent e) {
		
		initVotingPlugin();
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(AlathraExtras.getInstance(), new Runnable() {
		    public void run() {
		    	CustomVotingListener.checkForAllSitesVoted();
		    }
		}, 20L); //20 Tick (1 Second) delay before run() is called
				
		try {
			Player p = Bukkit.getPlayer(e.getPlayer());
			if (playersWhoVoted.isEmpty()) {
				playersWhoVoted.add(p);
			} else {
				if (!(playersWhoVoted.contains(p))) {
					playersWhoVoted.add(p);
				}
			}
		} catch(NullPointerException err) {
			
		}
		
	}
	
}
