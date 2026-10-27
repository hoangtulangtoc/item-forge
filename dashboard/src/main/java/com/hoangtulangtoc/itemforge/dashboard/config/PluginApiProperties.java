package com.hoangtulangtoc.itemforge.dashboard.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("item-forge.api")
public record PluginApiProperties(String baseUrl, String token) {
}
