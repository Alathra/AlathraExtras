package me.ShermansWorld.AlathraExtras.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("deprecation")
public class CustomResources {
	/**
	 * BORROWED FROM TOWNY PRODUCTION 4/1/2024
	/**

	/**
	 * String reused in getters
	 */
	private static List<String> lore;

	/**
	 * Tag for Alathra Items
	 */
	// private static String alathraItemTag = color("§a&lAlathran Item"));

	/**
	 * Gets Abyssal Stone ItemStack
	 * 
	 * @return an ItemStack containing Abyssal Stone
	 */
	public static ItemStack getAbyssalStone() {
		ItemStack abyssalStone = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = abyssalStone.getItemMeta();
		meta.setDisplayName(("§8§lAbyssal Stone"));
		lore = new ArrayList<String>();
		lore.add(("§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14600);
		abyssalStone.setItemMeta(meta);
		return abyssalStone;
	}

	/**
	 * Gets Ancient Wood ItemStack
	 * 
	 * @return an ItemStack containing Ancient Wood
	 */
	public static ItemStack getAncientWood() {
		ItemStack ancientWood = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = ancientWood.getItemMeta();
		meta.setDisplayName(("§6§lAncient Wood"));
		lore = new ArrayList<String>();
		lore.add(("§r§2§5§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14601);
		ancientWood.setItemMeta(meta);
		return ancientWood;
	}

	/**
	 * Gets Baer Steel ItemStack
	 * 
	 * @return an ItemStack containing Baer Steel
	 */
	public static ItemStack getBaerSteel() {
		ItemStack baerSteel = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = baerSteel.getItemMeta();
		meta.setDisplayName(("§b§lBaer Steel"));
		lore = new ArrayList<String>();
		lore.add(("§r§2§b§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14602);
		baerSteel.setItemMeta(meta);
		return baerSteel;
	}

	/**
	 * Gets Blessed Opal ItemStack
	 * 
	 * @return an ItemStack containing Blessed Opal
	 */
	public static ItemStack getBlessedOpal() {
		ItemStack blessedOpal = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = blessedOpal.getItemMeta();
		meta.setDisplayName(("§e§lBlessed Opal"));
		lore = new ArrayList<String>();
		lore.add(("§r§3§0§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14603);
		blessedOpal.setItemMeta(meta);
		return blessedOpal;
	}

	/**
	 * Gets Elustone ItemStack
	 * 
	 * @return an ItemStack containing Elustone
	 */
	public static ItemStack getElustone() {
		ItemStack elustone = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = elustone.getItemMeta();
		meta.setDisplayName(("§3§lElustone"));
		lore = new ArrayList<String>();
		lore.add(("§r§2§2§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14604);
		elustone.setItemMeta(meta);
		return elustone;
	}

	/**
	 * Gets Fyada ItemStack
	 * 
	 * @return an ItemStack containing Fyada
	 */
	public static ItemStack getFyada() {
		ItemStack fyada = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = fyada.getItemMeta();
		meta.setDisplayName(("§b§lFyada"));
		lore = new ArrayList<String>();
		lore.add(("§r§2§c§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14605);
		fyada.setItemMeta(meta);
		return fyada;
	}

	/**
	 * Gets Luminous Bismuth ItemStack
	 * 
	 * @return an ItemStack containing Luminous Bismuth
	 */
	public static ItemStack getLuminousBismuth() {
		ItemStack luminousBismuth = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = luminousBismuth.getItemMeta();
		meta.setDisplayName(("§5§lLuminous Bismuth"));
		lore = new ArrayList<String>();
		lore.add(("§r§2§4§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14606);
		luminousBismuth.setItemMeta(meta);
		return luminousBismuth;
	}

	/**
	 * Gets Magikite ItemStack
	 * 
	 * @return an ItemStack containing Magikite
	 */
	public static ItemStack getMagikite() {
		ItemStack magikite = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = magikite.getItemMeta();
		meta.setDisplayName(("§9§lMagikite"));
		lore = new ArrayList<String>();
		lore.add(("§r§2§a§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14607);
		magikite.setItemMeta(meta);
		return magikite;
	}

	/**
	 * Gets Quicksilver ItemStack
	 * 
	 * @return an ItemStack containing Quicksilver
	 */
	public static ItemStack getQuicksilver() {
		ItemStack quicksilver = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = quicksilver.getItemMeta();
		meta.setDisplayName(("§7§lQuicksilver"));
		lore = new ArrayList<String>();
		lore.add(("§r§2§8§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14608);
		quicksilver.setItemMeta(meta);
		return quicksilver;
	}

	/**
	 * Gets Rose Quartz ItemStack
	 * 
	 * @return an ItemStack containing Rose Quartz
	 */
	public static ItemStack getRoseQuartz() {
		ItemStack roseQuartz = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = roseQuartz.getItemMeta();
		meta.setDisplayName(("§d§lRose Quartz"));
		lore = new ArrayList<String>();
		lore.add(("§r§2§e§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14609);
		roseQuartz.setItemMeta(meta);
		return roseQuartz;
	}

	/**
	 * Gets Rotwud ItemStack
	 * 
	 * @return an ItemStack containing Rotwud
	 */
	public static ItemStack getRotwud() {
		ItemStack rotwud = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = rotwud.getItemMeta();
		meta.setDisplayName(("§4§lRotwud"));
		lore = new ArrayList<String>();
		lore.add(("§r§2§3§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14610);
		rotwud.setItemMeta(meta);
		return rotwud;
	}

	/**
	 * Gets Saelz ItemStack
	 * 
	 * @return an ItemStack containing Saelz
	 */
	public static ItemStack getSaelz() {
		ItemStack saelz = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = saelz.getItemMeta();
		meta.setDisplayName(("§d§lSaelz"));
		lore = new ArrayList<String>();
		lore.add(("§r§2§f§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14611);
		saelz.setItemMeta(meta);
		return saelz;
	}

	/**
	 * Gets SolarGold ItemStack
	 * 
	 * @return an ItemStack containing SolarGold
	 */
	public static ItemStack getSolarGold() {
		ItemStack solarGold = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = solarGold.getItemMeta();
		meta.setDisplayName(("§6§lSolar Gold"));
		lore = new ArrayList<String>();
		lore.add(("§r§2§6§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14612);
		solarGold.setItemMeta(meta);
		return solarGold;
	}

	/**
	 * Gets Tetracide ItemStack
	 * 
	 * @return an ItemStack containing Tetracide
	 */
	public static ItemStack getTetracide() {
		ItemStack tetracide = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = tetracide.getItemMeta();
		meta.setDisplayName(("§c§lTetracide"));
		lore = new ArrayList<String>();
		lore.add(("§r§2§d§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14613);
		tetracide.setItemMeta(meta);
		return tetracide;
	}

	/**
	 * Gets Velotite ItemStack
	 * 
	 * @return an ItemStack containing Velotite
	 */
	public static ItemStack getVelotite() {
		ItemStack velotite = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = velotite.getItemMeta();
		meta.setDisplayName(("§2§lVelotite"));
		lore = new ArrayList<String>();
		lore.add(("§r§2§1§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14614);
		velotite.setItemMeta(meta);
		return velotite;
	}

	/**
	 * Gets Wild Citrine ItemStack
	 * 
	 * @return an ItemStack containing Wild Citrine
	 */
	public static ItemStack getWildCitrine() {
		ItemStack wildCitrine = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = wildCitrine.getItemMeta();
		meta.setDisplayName(("§6§lWild Citrine"));
		lore = new ArrayList<String>();
		lore.add(("§r§2§7§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14615);
		wildCitrine.setItemMeta(meta);
		return wildCitrine;
	}

	public static ItemStack getSelfEsteemite() {
		ItemStack selfEsteemite = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = selfEsteemite.getItemMeta();
		meta.setDisplayName("§7§lSelf Esteemite");
		lore = new ArrayList<String>();
		lore.add(("§r§3§4§r§a§lAlathran Item"));
		lore.add(("§r§3Picks you up, when you feel down"));
		meta.setCustomModelData(14620);
		meta.setLore(lore);
		selfEsteemite.setItemMeta(meta);
		return selfEsteemite;
	}

	/**
	 * Gets Forest Rune ItemStack
	 * 
	 * @return an ItemStack containing Forest Rune
	 */
	public static ItemStack getForestRune() {
		ItemStack forestRune = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = forestRune.getItemMeta();
		meta.setDisplayName(("§2§lForest Rune"));
		lore = new ArrayList<String>();
		lore.add(("§r§3§4§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14616);
		forestRune.setItemMeta(meta);
		return forestRune;
	}

	/**
	 * Gets Mountain Rune ItemStack
	 * 
	 * @return an ItemStack containing Mountain Rune
	 */
	public static ItemStack getMountainRune() {
		ItemStack mountainRune = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = mountainRune.getItemMeta();
		meta.setDisplayName(("§7§lMountain Rune"));
		lore = new ArrayList<String>();
		lore.add(("§r§3§1§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14617);
		mountainRune.setItemMeta(meta);
		return mountainRune;
	}

	/**
	 * Gets Tropical Rune ItemStack
	 * 
	 * @return an ItemStack containing Tropical Rune
	 */
	public static ItemStack getTropicalRune() {
		ItemStack tropicalRune = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = tropicalRune.getItemMeta();
		meta.setDisplayName(("§e§lTropical Rune"));
		lore = new ArrayList<String>();
		lore.add(("§r§3§3§r§a§lAlathran Item"));
		meta.setLore(lore);

		meta.setCustomModelData(14618);
		tropicalRune.setItemMeta(meta);
		return tropicalRune;
	}

	/**
	 * Gets Tundra Rune ItemStack
	 * 
	 * @return an ItemStack containing Tundra Rune
	 */
	public static ItemStack getTundraRune() {
		ItemStack tundraRune = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = tundraRune.getItemMeta();
		meta.setDisplayName(("§3§lTundra Rune"));
		lore = new ArrayList<String>();
		lore.add(("§r§3§2§r§a§lAlathran Item"));
		meta.setLore(lore);
		meta.setCustomModelData(14619);
		tundraRune.setItemMeta(meta);
		return tundraRune;
	}

	/**
	 * Gets an arraylist of all of the resources in CustomResources.java
	 * 
	 * @return an ArrayList<ItemStack> containing all of the resources
	 */
	public static ArrayList<ItemStack> getResources() {
		ArrayList<ItemStack> resources = new ArrayList<ItemStack>();
		// 16
		resources.add(getAbyssalStone());
		resources.add(getAncientWood());
		resources.add(getBaerSteel());
		resources.add(getBlessedOpal());
		resources.add(getElustone());
		resources.add(getFyada());
		resources.add(getLuminousBismuth());
		resources.add(getMagikite());
		resources.add(getQuicksilver());
		resources.add(getRoseQuartz());
		resources.add(getRotwud());
		resources.add(getSaelz());
		resources.add(getSolarGold());
		resources.add(getTetracide());
		resources.add(getVelotite());
		resources.add(getWildCitrine());
		resources.add(getSelfEsteemite());
		return resources;
	}

	/**
	 * Gets an arraylist of all of the runes in CustomResources.java
	 * 
	 * @return an ArrayList<ItemStack> containing all of the runes
	 */
	public static ArrayList<ItemStack> getRunes() {
		ArrayList<ItemStack> runes = new ArrayList<ItemStack>();
		// 4
		runes.add(getForestRune());
		runes.add(getMountainRune());
		runes.add(getTropicalRune());
		runes.add(getTundraRune());
		return runes;
	}

	public static ArrayList<ItemStack> getAll() {
		ArrayList<ItemStack> returnList = getResources();
		returnList.addAll(getRunes());
		return returnList;
	}

	public static ItemStack get(String string) {
		ArrayList<ItemStack> resources = getResources();
		resources.addAll(getRunes());
		for (ItemStack stack : resources) {
			if (ChatColor.stripColor(stack.getItemMeta().getDisplayName()).replace(' ', '_').toUpperCase()
					.equals(string)) {
				return stack;
			}
		}

		return null;
	}

}
