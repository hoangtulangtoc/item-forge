package com.hoangtulangtoc.application;

import com.hoangtulangtoc.application.port.RecipeConfigSourcePort;
import com.hoangtulangtoc.domain.RecipeRegistry;
import com.hoangtulangtoc.domain.model.RecipeDefinition;

public class RecipeConfigLoaderService {

    private final RecipeConfigSourcePort configSource;
    private final RecipeRegistry registry;

    public RecipeConfigLoaderService(RecipeConfigSourcePort configSource, RecipeRegistry registry) {
        this.configSource = configSource;
        this.registry = registry;
    }

    public void loadAll() {
        registry.clear();
        configSource.loadAll().forEach(registry::register);
    }

    public void save(RecipeDefinition definition) {
        configSource.save(definition);
        registry.register(definition);
    }

    public void delete(String id) {
        configSource.delete(id);
        registry.remove(id);
    }
}
