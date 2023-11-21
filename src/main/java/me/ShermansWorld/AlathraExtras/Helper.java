package me.ShermansWorld.AlathraExtras;

import org.bukkit.ChatColor;

public class Helper {
    public static String color(final String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    public static String Chatlabel() {
        return color("&6[&aAlathraExtras&6]&r ");
    }

}
