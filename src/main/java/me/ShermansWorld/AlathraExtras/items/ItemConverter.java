package me.ShermansWorld.AlathraExtras.items;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

public class ItemConverter implements Listener {
	/**
	 * Used for converting older item stacks to new ones since NBT data changed and
	 * broke some items when the server was updated from 1.20.1 to 1.20.4.
	 * 
	 * This listener makes it so when a player opens a container with the old items
	 * it will replace the item with the new version, if detected.
	 */

	String oldPlatinum = "ItemStack{COPPER_INGOT x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"bold\":true,\"italic\":false,\"color\":\"dark_aqua\",\"text\":\"Platinum\"}, lore=[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}], custom-model-data=3}}";
	String oldSilver = "ItemStack{COPPER_INGOT x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"bold\":true,\"italic\":false,\"color\":\"gray\",\"text\":\"Silver\"}, lore=[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}], custom-model-data=4}}";
	String oldTungsten = "ItemStack{COPPER_INGOT x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"bold\":true,\"italic\":false,\"color\":\"dark_gray\",\"text\":\"Tungsten\"}, lore=[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}], custom-model-data=2}}";
	
	String oldCarrotPouch = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"gold\",\"text\":\"Carrot Pouch\"}],\"text\":\"\"}, custom-model-data=14701}}";
	String oldBeetrootPouch = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"dark_red\",\"text\":\"Beetroot Pouch\"}],\"text\":\"\"}, custom-model-data=14700}}";
	String oldPotatoPouch = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"yellow\",\"text\":\"Potato Pouch\"}],\"text\":\"\"}, custom-model-data=14713}}";
	
	String oldNetherHeart = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"bold\":true,\"italic\":false,\"color\":\"dark_red\",\"text\":\"Nether Heart\"}, lore=[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}], custom-model-data=14801}}";
	
	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent event) {
			ItemStack[] storageContents = event.getInventory().getStorageContents();
			for (int i = 0; i < storageContents.length; i++) {
				int amount;
				ItemStack item;
				if (storageContents[i] == null) {
					continue;
				} else if(storageContents[i].asOne().toString().equals(oldPlatinum)) {
					item = Items.getPlatinum();
					amount = storageContents[i].getAmount();
					item.setAmount(amount);
					event.getInventory().setItem(i, item);
				} else if (storageContents[i].asOne().toString().equals(oldSilver)) {
					item = Items.getSilver();
					amount = storageContents[i].getAmount();
					item.setAmount(amount);
					event.getInventory().setItem(i, item);
				} else if (storageContents[i].asOne().toString().equals(oldTungsten)) {
					item = Items.getTungsten();
					amount = storageContents[i].getAmount();
					item.setAmount(amount);
					event.getInventory().setItem(i, item);
				} else if (storageContents[i].asOne().toString().equals(oldCarrotPouch)) {
					item = Items.getCarrotPouch();
					amount = storageContents[i].getAmount();
					item.setAmount(amount);
					event.getInventory().setItem(i, item);
				} else if (storageContents[i].asOne().toString().equals(oldBeetrootPouch)) {
					item = Items.getBeetrootPouch();
					amount = storageContents[i].getAmount();
					item.setAmount(amount);
					event.getInventory().setItem(i, item);
				} else if (storageContents[i].asOne().toString().equals(oldPotatoPouch)) {
					item = Items.getPotatoPouch();
					amount = storageContents[i].getAmount();
					item.setAmount(amount);
					event.getInventory().setItem(i, item);
				} else if (storageContents[i].asOne().toString().equals(oldNetherHeart)) {
					item = Items.getNetherHeart();
					amount = storageContents[i].getAmount();
					item.setAmount(amount);
					event.getInventory().setItem(i, item);
				}//else {
					//Bukkit.broadcastMessage(storageContents[i].asOne().toString());
				//}
			}
		}
}
