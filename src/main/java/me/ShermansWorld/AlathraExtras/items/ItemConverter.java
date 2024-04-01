package me.ShermansWorld.AlathraExtras.items;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ItemConverter implements Listener {
	/**
	 * Used for converting older item stacks to new ones since NBT data changed and
	 * broke some items when the server was updated from 1.20.1 to 1.20.4.
	 * 
	 * This listener makes it so when a player opens a container with the old items
	 * it will replace the item with the new version, if detected.
	 */
	
	// Alathran ores
	String oldPlatinum = "ItemStack{COPPER_INGOT x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"bold\":true,\"italic\":false,\"color\":\"dark_aqua\",\"text\":\"Platinum\"}, lore=[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}], custom-model-data=3}}";
	String oldPlatinum2 = "ItemStack{COPPER_INGOT x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"bold\":true,\"italic\":false,\"color\":\"dark_aqua\",\"text\":\"Platinum\"}, lore=[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}], custom-model-data=3, internal=H4sIAAAAAAAA/+NiYOBg4PaNDPHwdI4PiQxwZeAIyEksycwrzWUAALGXIoYcAAAA}}";
	String oldSilver = "ItemStack{COPPER_INGOT x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"bold\":true,\"italic\":false,\"color\":\"gray\",\"text\":\"Silver\"}, lore=[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}], custom-model-data=4}}";
	String oldSilver2 = "ItemStack{COPPER_INGOT x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"bold\":true,\"italic\":false,\"color\":\"gray\",\"text\":\"Silver\"}, lore=[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}], custom-model-data=4, internal=H4sIAAAAAAAA/+NiYOBg4PaNDPHwdI4PiQxwZWALzswpSy1iAAB/RFAdGgAAAA==}}";
	String oldTungsten = "ItemStack{COPPER_INGOT x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"bold\":true,\"italic\":false,\"color\":\"dark_gray\",\"text\":\"Tungsten\"}, lore=[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}], custom-model-data=2}}";
	String oldTungsten2 = "ItemStack{COPPER_INGOT x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"bold\":true,\"italic\":false,\"color\":\"dark_gray\",\"text\":\"Tungsten\"}, lore=[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}], custom-model-data=2, internal=H4sIAAAAAAAA/+NiYOBg4PaNDPHwdI4PiQxwZeAIKc1LLy5JzWMAAAokz+kcAAAA}}";

	// Pouches
	String oldCarrotPouch = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"gold\",\"text\":\"Carrot Pouch\"}],\"text\":\"\"}, custom-model-data=14701}}";
	String oldBeetrootPouch = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"dark_red\",\"text\":\"Beetroot Pouch\"}],\"text\":\"\"}, custom-model-data=14700}}";
	String oldPotatoPouch = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"yellow\",\"text\":\"Potato Pouch\"}],\"text\":\"\"}, custom-model-data=14713}}";
	
	// Nether heart
	String oldNetherHeart = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"bold\":true,\"italic\":false,\"color\":\"dark_red\",\"text\":\"Nether Heart\"}, lore=[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}], custom-model-data=14801}}";
	String oldNetherHeart2 = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"bold\":true,\"italic\":false,\"color\":\"dark_red\",\"text\":\"Nether Heart\"}, lore=[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}], custom-model-data=14801, internal=H4sIAAAAAAAA/+NiYOBg4PaNDPHwdI4PiQxwZeDxSy3JSC2K90hNLCphAAAcY4rIIAAAAA==}}";
	
	// Runes
	String forestRune = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"dark_green\",\"text\":\"Forest Rune\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14616}}";
	String mountainRune = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"gray\",\"text\":\"Mountain Rune\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14617}}";
	String tropicalRune = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"yellow\",\"text\":\"Tropical Rune\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14618}}";
	String tundraRune = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"dark_aqua\",\"text\":\"Tundra Rune\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14619}}";
	
	// Regional resources
	String abyssalStone = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"dark_gray\",\"text\":\"Abyssal Stone\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14600}}";
	String ancientWood = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"gold\",\"text\":\"Ancient Wood\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14601}}";
	String baerSteel = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"aqua\",\"text\":\"Baer Steel\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14602}}";
	String blessedOpal = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"yellow\",\"text\":\"Blessed Opal\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14603}}";
	String elustone = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"dark_aqua\",\"text\":\"Elustone\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14604}}";
	String fyada = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"aqua\",\"text\":\"Fyada\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14605}}";
	String luminousBismuth = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"dark_purple\",\"text\":\"Luminous Bismuth\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14606}}";
	String magikite = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"blue\",\"text\":\"Magikite\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14607}}";
	String quicksilver = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"gray\",\"text\":\"Quicksilver\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14608}}";
	String roseQuartz = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"light_purple\",\"text\":\"Rose Quartz\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14609}}";
	String rotwud = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"dark_red\",\"text\":\"Rotwud\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14610}}";
	String saelz = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"light_purple\",\"text\":\"Saelz\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14611}}";
	String solarGold = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"gold\",\"text\":\"Solar Gold\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14612}}";
	String tetracide = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"red\",\"text\":\"Tetracide\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14613}}";
	String velotite = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"dark_green\",\"text\":\"Velotite\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14614}}";
	String wildCitrine = "ItemStack{PAPER x 1, UNSPECIFIC_META:{meta-type=UNSPECIFIC, display-name={\"extra\":[{\"bold\":true,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"gold\",\"text\":\"Wild Citrine\"}],\"text\":\"\"}, lore=[{\"extra\":[{\"bold\":true,\"italic\":false,\"color\":\"green\",\"text\":\"Alathran Item\"}],\"text\":\"\"}], custom-model-data=14615}}";
	
	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent event) {
		ItemStack[] storageContents = event.getInventory().getStorageContents();
		for (int i = 0; i < storageContents.length; i++) {
			int amount;
			if (storageContents[i] == null) {
				continue;
			} else {
				amount = storageContents[i].getAmount();
			}

			if (storageContents[i].asOne().toString().equals(oldPlatinum)
					|| storageContents[i].asOne().toString().equals(oldPlatinum2)) {
				replaceItem(event.getInventory(), Items.getPlatinum(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(oldSilver)
					|| storageContents[i].asOne().toString().equals(oldSilver2)) {
				replaceItem(event.getInventory(), Items.getSilver(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(oldTungsten)
					|| storageContents[i].asOne().toString().equals(oldTungsten2)) {
				replaceItem(event.getInventory(), Items.getPlatinum(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(oldCarrotPouch)) {
				replaceItem(event.getInventory(), Items.getCarrotPouch(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(oldBeetrootPouch)) {
				replaceItem(event.getInventory(), Items.getBeetrootPouch(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(oldPotatoPouch)) {
				replaceItem(event.getInventory(), Items.getPotatoPouch(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(oldNetherHeart)
					|| storageContents[i].asOne().toString().equals(oldNetherHeart2)) {
				replaceItem(event.getInventory(), Items.getNetherHeart(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(forestRune)) {
				replaceItem(event.getInventory(), CustomResources.getForestRune(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(mountainRune)) {
				replaceItem(event.getInventory(), CustomResources.getMountainRune(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(tropicalRune)) {
				replaceItem(event.getInventory(), CustomResources.getTropicalRune(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(tundraRune)) {
				replaceItem(event.getInventory(), CustomResources.getTundraRune(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(abyssalStone)) {
				replaceItem(event.getInventory(), CustomResources.getAbyssalStone(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(ancientWood)) {
				replaceItem(event.getInventory(), CustomResources.getAncientWood(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(baerSteel)) {
				replaceItem(event.getInventory(), CustomResources.getBaerSteel(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(blessedOpal)) {
				replaceItem(event.getInventory(), CustomResources.getBlessedOpal(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(elustone)) {
				replaceItem(event.getInventory(), CustomResources.getElustone(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(fyada)) {
				replaceItem(event.getInventory(), CustomResources.getFyada(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(luminousBismuth)) {
				replaceItem(event.getInventory(), CustomResources.getLuminousBismuth(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(magikite)) {
				replaceItem(event.getInventory(), CustomResources.getMagikite(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(quicksilver)) {
				replaceItem(event.getInventory(), CustomResources.getQuicksilver(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(roseQuartz)) {
				replaceItem(event.getInventory(), CustomResources.getRoseQuartz(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(rotwud)) {
				replaceItem(event.getInventory(), CustomResources.getRotwud(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(saelz)) {
				replaceItem(event.getInventory(), CustomResources.getSaelz(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(solarGold)) {
				replaceItem(event.getInventory(), CustomResources.getSolarGold(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(tetracide)) {
				replaceItem(event.getInventory(), CustomResources.getTetracide(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(velotite)) {
				replaceItem(event.getInventory(), CustomResources.getVelotite(), i, amount);
			} else if (storageContents[i].asOne().toString().equals(wildCitrine)) {
				replaceItem(event.getInventory(), CustomResources.getWildCitrine(), i, amount);
			} else {
				//Bukkit.broadcastMessage(storageContents[i].asOne().toString());
			}
		}
	}

	private void replaceItem(Inventory inventory, ItemStack item, int slot, int amount) {
		item.setAmount(amount);
		inventory.setItem(slot, item);
	}
}
