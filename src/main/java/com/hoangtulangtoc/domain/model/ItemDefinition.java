package com.hoangtulangtoc.domain.model;

import java.util.List;

import com.hoangtulangtoc.domain.exception.InvalidItemDefinitionException;

public record ItemDefinition(
        String id,
        String material,
        int customModelData,
        String displayName,
        List<String> lore,
        List<AbilityDefinition> abilities) {

    public ItemDefinition{
        if(id==null || id.isBlank()) {
            throw new InvalidItemDefinitionException("Item ID cannot be blank");
        }

        if(material==null || material.isBlank()){
            throw new InvalidItemDefinitionException("Item Material cannot be blank");
        }

        lore = lore == null ? List.of() : List.copyOf(lore);
        abilities = abilities == null ? List.of() : List.copyOf(abilities);
    }
}
