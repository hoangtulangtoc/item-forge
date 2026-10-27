package com.hoangtulangtoc.domain.model;

/**
 * RecipeDefinition
 */
public sealed interface RecipeDefinition
        permits ShapedRecipeDefinition, ShapelessRecipeDefinition {

    String id();

    String resultId();

    int resultCount();
}
