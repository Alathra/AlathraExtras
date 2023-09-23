package me.ShermansWorld.AlathraExtras.metrics;

import dev.cubxity.plugins.metrics.api.UnifiedMetrics;
import org.bukkit.plugin.RegisteredServiceProvider;

import static org.bukkit.Bukkit.getServer;

public class MetricsManager {
    public MetricsManager() {
        RegisteredServiceProvider<UnifiedMetrics> registration = getServer().getServicesManager().getRegistration(UnifiedMetrics.class);

        if (registration != null) {
            UnifiedMetrics api = registration.getProvider();
            api.getMetricsManager().registerCollection(new NewJoinCollectorCollection());
        }
    }
}
