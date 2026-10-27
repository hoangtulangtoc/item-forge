package com.hoangtulangtoc.itemforge.dashboard.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("dashboard.admin")
public record DashboardAdminProperties(String username, String passwordHash) {
}
