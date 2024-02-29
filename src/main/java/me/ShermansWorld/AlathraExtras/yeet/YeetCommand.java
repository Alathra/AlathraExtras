package me.ShermansWorld.AlathraExtras.yeet;

import com.github.milkdrinkers.colorparser.ColorParser;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class YeetCommand implements CommandExecutor {


    public YeetCommand(final JavaPlugin plugin) {
        plugin.getCommand("yeet").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!commandSender.hasPermission("alathraextras.commands.yeet")) {
            commandSender.sendMessage(ColorParser.of("<red>You don't have permission to use this command").build());
            return true;
        }

        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                target.setVelocity(new Vector(0, 10, 0));
                return true;
            }
            commandSender.sendMessage(ColorParser.of("<red>Invalid player.").build());
            return false;
        }
        return false;
    }
}
