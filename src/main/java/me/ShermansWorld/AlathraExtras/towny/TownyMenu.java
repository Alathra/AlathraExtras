package me.ShermansWorld.AlathraExtras.towny;

import java.util.ArrayList;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.palmergames.adventure.text.Component;
import com.palmergames.adventure.text.event.HoverEvent;
import com.palmergames.bukkit.towny.event.statusscreen.TownStatusScreenEvent;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.util.Colors;

public class TownyMenu implements Listener {
	
	@EventHandler(priority = EventPriority.LOW)
	public void onTownStatusScreen(TownStatusScreenEvent event) {
		
		Town town = event.getTown();
		ArrayList<Resident> activeResidents = new ArrayList<Resident>();
		for (Resident resident : town.getResidents()) {
			long now = System.currentTimeMillis();
			long lastPlayed = resident.getLastOnline();
			long lastOnline = now - lastPlayed; // miliseconds player has been offline
			long milisecPerDay = 1000 * 60 * 60 * 24; // 1000 milisec/sec * 60 sec/min * 60 min/hr * 24 hr/day
			long limit = milisecPerDay * 30;
			if (lastOnline < limit) {
				activeResidents.add(resident);
			}
		}
		String activeResidentsStr = "&2Active Residents (Online in the last 30 days) &a[" + String.valueOf(activeResidents.size() + "]:&r ");
		for (Resident resident : activeResidents) {
			activeResidentsStr += resident.getName() + ", ";
		}
		
		// Remove the last comma and space
		activeResidentsStr = activeResidentsStr.substring(0, activeResidentsStr.length() -2);
		
		// Translate legancy color codes
		activeResidentsStr = Colors.translateColorCodes(activeResidentsStr);
		
		// Build component
		Component component = Component.empty();
		component = component
				.append(Component.text(Colors.translateColorCodes("&7[&aActive Residents&7]&r")).hoverEvent(HoverEvent.showText(Component.text(activeResidentsStr))));
		component = component.append(Component.newline());
		
		// Add component to Towny Menu
		event.getStatusScreen().addComponentOf("AlathraExtras", component);
	}
}
