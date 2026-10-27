package com.hoangtulangtoc.application.port;

import java.util.List;

import com.hoangtulangtoc.domain.model.RecipeDefinition;

public interface RecipeConfigSourcePort {

    List<RecipeDefinition> loadAll();

    void save(RecipeDefinition definition);

    void delete(String id);
}
