package com.hoangtulangtoc.infrastructure.bukkit.http;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;

interface ApiResourceHandler {

    void handle(HttpExchange exchange) throws IOException;
}
