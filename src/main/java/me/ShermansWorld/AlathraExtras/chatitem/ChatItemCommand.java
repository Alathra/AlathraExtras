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
            case TOWN -> new HashSet<>(receivers(channel, player, TownyAPI.getInstance().getOnlinePlayers(town)));
            case NATION -> new HashSet<>(receivers(channel, player, TownyAPI.getInstance().getOnlinePlayers(nation)));
            case ALLIANCE -> new HashSet<>(receivers(channel, player, TownyAPI.getInstance().getOnlinePlayersAlliance(nation)));
            case DEFAULT, GLOBAL, PRIVATE -> new HashSet<>(receivers(channel, player, new ArrayList<>(recipients)));
        };
    }

    private Set<Player> receivers(Channel channel, Player sender, List<Player> playerList) {
        playerList.forEach(player-> checkChannels(player, channel));
        return playerList.stream()
                .filter(player -> !Chat.getTownyChat().isIgnoredByEssentials(sender, player))
                .filter(player -> !channel.isAbsent(player.getName()))
                .filter(channel::hasPermission)
                .filter(player -> isInRange(channel.getRange(), sender, player))
                .collect(Collectors.toSet());
    }

    private boolean isInRange(double range, Player firstPlayer, Player secondPlayer) {
        return switch ((int) range) {
            case -1 -> true;
            case 0 -> firstPlayer.getWorld().equals(secondPlayer.getWorld());
            default -> firstPlayer.getWorld().equals(secondPlayer.getWorld()) &&
                    firstPlayer.getLocation().distance(secondPlayer.getLocation()) < range;
        };
    }

    private void checkChannels(Player player, Channel channel) {
        if (!channel.isPresent(player.getName())) channel.forgetPlayer(player);
    }


}