package me.ShermansWorld.AlathraExtras.metrics;

import dev.cubxity.plugins.metrics.api.metric.collector.Collector;
import dev.cubxity.plugins.metrics.api.metric.data.GaugeMetric;
import dev.cubxity.plugins.metrics.api.metric.data.Metric;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewJoinCollector implements Collector {
    private final Map<String, String> EMPTY_LABELS = new HashMap<>();

    @NotNull
    @Override
    public List<Metric> collect() {
        GaugeMetric metric = new GaugeMetric("minecraft_new_players_count", EMPTY_LABELS, PlayerFirstJoinListener.getNewJoins());
        return Collections.singletonList(metric);
    }
}