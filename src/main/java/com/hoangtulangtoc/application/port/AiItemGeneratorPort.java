package com.hoangtulangtoc.application.port;

import com.hoangtulangtoc.domain.model.ItemDefinition;

/**
 * Port for generating an ItemDefinition from a natural-language description.
 */
public interface AiItemGeneratorPort {

    /**
     * Generates a draft ItemDefinition from the user's description. The draft's
     * customModelData is a placeholder with no meaning yet, because the AI cannot know
     * which values are free in the current registry -- assigning the real value is
     * AiItemGenerationService's job.
     */
    ItemDefinition generateDraft(String itemId, String description);
}
