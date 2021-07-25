package com.sda.goldmann.iss.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class IssClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(IssClient.class);

    HttpRequest request = null;

    public String get(String uri) {

        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .GET()
                    .build();
        } catch (URISyntaxException ex) {
            LOGGER.error("invalid uri");

            return "";

        }

        try {
            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .proxy(ProxySelector.getDefault())
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException ex) {
            LOGGER.error("failed to fetch data from API");

            return "";
        }

    }
}
