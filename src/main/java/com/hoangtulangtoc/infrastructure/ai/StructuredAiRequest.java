package com.hoangtulangtoc.infrastructure.ai;

/**
 * One structured-output call, described for use by the available provider adapters.
 *
 * <p>Adapters can use either the machine-readable JSON Schema or its prose description,
 * depending on the provider API. Features declare their output shape once, in one place.
 *
 * @param systemPrompt      task instructions, without the output shape
 * @param userMessage       the payload the model works on
 * @param schemaName        name used by APIs that model structured output as a tool call
 * @param schemaDescription one-line description of the structured output
 * @param jsonSchema        JSON Schema for the response object, in the standard lowercase dialect
 * @param schemaProse       the same shape in prose, for APIs that need the output format
 *                          described in the prompt
 */
public record StructuredAiRequest(
        String systemPrompt,
        String userMessage,
        String schemaName,
        String schemaDescription,
        String jsonSchema,
        String schemaProse) {

    public StructuredAiRequest {
        if (systemPrompt == null || systemPrompt.isBlank()) {
            throw new IllegalArgumentException("systemPrompt cannot be blank");
        }
        if (userMessage == null || userMessage.isBlank()) {
            throw new IllegalArgumentException("userMessage cannot be blank");
        }
        if (jsonSchema == null || jsonSchema.isBlank()) {
            throw new IllegalArgumentException("jsonSchema cannot be blank");
        }
        if (schemaProse == null || schemaProse.isBlank()) {
            throw new IllegalArgumentException("schemaProse cannot be blank");
        }
    }

    /**
     * Returns the task together with the output shape for APIs that need it in the prompt.
     */
    public String systemPromptWithSchemaProse() {
        return systemPrompt + " " + schemaProse;
    }
}
