package me.ShermansWorld.AlathraExtras.chatitem;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.HoverEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class ChatItemCommand implements CommandExecutor {


    public ChatItemCommand(final JavaPlugin plugin) {

        plugin.getCommand("chatitem").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            ItemStack itemStack = p.getInventory().getItemInMainHand();
            HoverEvent<HoverEvent.ShowItem> hoverEvent = itemStack.asHoverEvent();

            p.sendMessage(Component.text("Test").hoverEvent(hoverEvent));
        }
        return true;
    }


}