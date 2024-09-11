package me.ShermansWorld.AlathraExtras.utilities;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

public class CommandSenderUtil {

    /**
     * Sends a console command.
     * @param command the command to send
     */
    public static void sendConsoleCommand(String command) {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        Bukkit.dispatchCommand(console, command);
    }
}