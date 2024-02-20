package me.ShermansWorld.AlathraExtras.yeet;

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
        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            target.setVelocity(new Vector(0, 10, 0));
            return true;
        }
        return false;
    }
}
