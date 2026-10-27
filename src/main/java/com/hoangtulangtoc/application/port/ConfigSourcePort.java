package com.hoangtulangtoc.application.port;

import java.util.List;

import com.hoangtulangtoc.domain.model.ItemDefinition;

public interface ConfigSourcePort {

    List<ItemDefinition> loadAll();

    void save(ItemDefinition definition);

    void delete(String id);
}
