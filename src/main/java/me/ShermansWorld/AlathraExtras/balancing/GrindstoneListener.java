package me.ShermansWorld.AlathraExtras.balancing;

import com.github.milkdrinkers.colorparser.ColorParser;
import me.ShermansWorld.AlathraExtras.Helper;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.GrindstoneInventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class GrindstoneListener implements Listener {
    @EventHandler
    public void onCure(InventoryClickEvent e) {
        if (e.getInventory().getType() == InventoryType.GRINDSTONE && e.getSlotType() == InventoryType.SlotType.RESULT) {
            if (!(e.getInventory() instanceof GrindstoneInventory grindstoneInv))
                return;

            for (ItemStack item : grindstoneInv.getContents()) {
                if (item != null && item.hasItemMeta()) {
                    if (item.getItemMeta().hasLore()) {
                        List<Component> loreList = item.getItemMeta().lore();

                        if (loreList == null) return;

                        for (Component loreLine : loreList) {
                            if (loreLine.toString().contains("Alathran Item")) {
                                grindstoneInv.getViewers().get(0).sendMessage(ColorParser.of(
                                    Helper.Chatlabel() +
                                        "&cYou cannot repair Alathran items in the grindstone!")
                                    .parseLegacy().build());
                                e.setCancelled(true);
                            }
                        }
                    }
                }
            }
        }
    }
}
