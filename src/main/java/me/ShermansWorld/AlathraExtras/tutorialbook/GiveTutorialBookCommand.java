package me.ShermansWorld.AlathraExtras.tutorialbook;

import me.ShermansWorld.AlathraExtras.AlathraExtras;
import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.items.Items;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GiveTutorialBookCommand implements CommandExecutor {
    public GiveTutorialBookCommand(final AlathraExtras plugin) {
        PluginCommand tutorialbookCommand = plugin.getCommand("tutorialbook");

        if (tutorialbookCommand == null) return;

        tutorialbookCommand.setExecutor(this);
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player p)) {
            return false;
        }

        if (!p.hasPermission("AlathraExtras.tutorialbook")) {
            p.sendMessage(Helper.Chatlabel() + Helper.color("&cYou do not have permission to do this!"));
            return false;
        }

        p.getInventory().addItem(Items.tutorialBook());
        return true;
    }
}
