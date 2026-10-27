package com.hoangtulangtoc.infrastructure.ai;

import java.util.Locale;
import java.util.logging.Logger;

import com.hoangtulangtoc.application.exception.AiRequestException;

/**
 * Creates the AI adapter selected by ai.provider in config.yml.
 */
public class AiProviderFactory {

    public StructuredAiClient create(String provider, String apiKey, String model, int maxTokens,
            int timeoutSeconds, Logger logger) {
        return switch (provider.toLowerCase(Locale.ROOT)) {
            case "claude" -> new ClaudeAiAdapter(apiKey, model, maxTokens, timeoutSeconds, logger);
            case "chatgpt" -> new ChatGptAiAdapter(apiKey, model, maxTokens, timeoutSeconds, logger);
            case "deepseek" -> new DeepSeekAiAdapter(apiKey, model, maxTokens, timeoutSeconds, logger);
            case "gemini" -> new GeminiAiAdapter(apiKey, model, maxTokens, timeoutSeconds, logger);
            default -> throw new AiRequestException(
                    "Unknown AI provider: '" + provider + "'. Supported providers: claude, chatgpt, deepseek, gemini");
        };
    }
}
