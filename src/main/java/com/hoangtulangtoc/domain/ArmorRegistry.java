package com.hoangtulangtoc.domain;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.hoangtulangtoc.domain.model.ArmorDefinition;

public class ArmorRegistry {

    private final Map<String, ArmorDefinition> armors = new ConcurrentHashMap<>();

    public void register(ArmorDefinition definition) {
        armors.put(definition.id(), definition);
    }

    public Optional<ArmorDefinition> get(String id) {
        return Optional.ofNullable(armors.get(id));
    }

    public Collection<ArmorDefinition> getAll() {
        return armors.values();
    }

    public void remove(String id) {
        armors.remove(id);
    }

    public void clear() {
        armors.clear();
    }

    public int size() {
        return armors.size();
    }
}
