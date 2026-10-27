package com.hoangtulangtoc.application.port;

import java.util.List;

import com.hoangtulangtoc.domain.model.CustomBlockDefinition;

public interface CustomBlockConfigSourcePort {

    List<CustomBlockDefinition> loadAll();

    void save(CustomBlockDefinition definition);

    void delete(String id);
}
