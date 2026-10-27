package com.hoangtulangtoc.application.port;

import java.util.List;

import com.hoangtulangtoc.domain.model.ArmorDefinition;

public interface ArmorConfigSourcePort {

    List<ArmorDefinition> loadAll();

    void save(ArmorDefinition definition);

    void delete(String id);
}
