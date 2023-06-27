package me.ShermansWorld.AlathraExtras.chatitem;


import com.palmergames.bukkit.TownyChat.Chat;
import com.palmergames.bukkit.TownyChat.channels.Channel;

import com.palmergames.bukkit.towny.TownyAPI;

import com.palmergames.bukkit.towny.TownyUniverse;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import net.kyori.adventure.text.Component;

import net.kyori.adventure.text.format.TextColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class ChatItemCommand implements CommandExecutor {


    public ChatItemCommand(final JavaPlugin plugin) {
        plugin.getCommand("chatitem").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            var channel = Chat.getTownyChat().getPlayerChannel(player);
            Resident resident = TownyUniverse.getInstance().getResident(player.getUniqueId());
            Town town = TownyAPI.getInstance().getResidentTownOrNull(resident);
            Nation nation = TownyAPI.getInstance().getResidentNationOrNull(resident);
            var recipients = getRecipients(player, town, nation, channel, Bukkit.getOnlinePlayers().stream().collect(Collectors.toSet()));
            ItemStack itemStack = player.getInventory().getItemInMainHand();
            var message = Component.text(player.getName() + " is showing off their item.").color(TextColor.color(0x44FFA6)).hoverEvent(itemStack.asHoverEvent());
            recipients.forEach(recipient -> recipient.sendMessage(message));
        }
        return true;
    }

    private Set<Player> getRecipients(Player player, Town town, Nation nation, Channel channel, Set<Player> recipients) {
        return switch (channel.getType()) {
            case TOWN -> new HashSet<>(findRecipients(channel, player, TownyAPI.getInstance().getOnlinePlayers(town)));
            case NATION ->
                    new HashSet<>(findRecipients(channel, player, TownyAPI.getInstance().getOnlinePlayers(nation)));
            case ALLIANCE ->
                    new HashSet<>(findRecipients(channel, player, TownyAPI.getInstance().getOnlinePlayersAlliance(nation)));
            case DEFAULT -> new HashSet<>(findRecipients(channel, player, new ArrayList<>(recipients)));
            case GLOBAL, PRIVATE -> new HashSet<>(findRecipients(channel, player, new ArrayList<>(recipients)));
        };
    }

    private Set<Player> findRecipients(Channel channel, Player sender, List<Player> playerList) {
        // Refresh the potential channels a player can see, if they are not currently in the channel.
        playerList.forEach(p -> refreshPlayer(channel, p));
        return playerList.stream()
                .filter(p -> channel.hasPermission(p)) // Check permission.
                .filter(p -> testDistance(sender, p, channel.getRange())) // Within range.
                .filter(p -> !Chat.getTownyChat().isIgnoredByEssentials(sender, p)) // Check essentials ignore.
                .filter(p -> !channel.isAbsent(p.getName())) // Check if player is purposefully absent.
                .collect(Collectors.toSet());
    }

    private boolean testDistance(Player player1, Player player2, double range) {

        // unlimited range (all worlds)
        if (range == -1)
            return true;

        // Same world only
        if (range == 0)
            return player1.getWorld().equals(player2.getWorld());

        // Range check (same world)
        return player1.getWorld().equals(player2.getWorld()) &&
                player1.getLocation().distance(player2.getLocation()) < range;
    }

    private void refreshPlayer(Channel channel, Player player) {
        if (!channel.isPresent(player.getName()))
            channel.forgetPlayer(player);
    }


}