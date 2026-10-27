package com.hoangtulangtoc.application;

import com.hoangtulangtoc.application.port.ConfigSourcePort;
import com.hoangtulangtoc.domain.ItemRegistry;
import com.hoangtulangtoc.domain.model.ItemDefinition;

public class ItemConfigLoaderService {

    private final ConfigSourcePort configSource;
    private final ItemRegistry registry;

    public ItemConfigLoaderService(ConfigSourcePort configSource, ItemRegistry registry) {
        this.configSource = configSource;
        this.registry = registry;
    }

    public void loadAll() {
        registry.clear();
        configSource.loadAll().forEach(registry::register);
    }

    public void save(ItemDefinition definition) {
        configSource.save(definition);
        registry.register(definition);
    }

    public void delete(String id) {
        configSource.delete(id);
        registry.remove(id);
    }
}
