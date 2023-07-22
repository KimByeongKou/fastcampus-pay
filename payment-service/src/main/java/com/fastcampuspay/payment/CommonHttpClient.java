package com.fastcampuspay.payment;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

@Component
public class CommonHttpClient {
    private final HttpClient httpClient;
    
    public CommonHttpClient() {
        httpClient = HttpClient.newBuilder().build();
    }
    
    public HttpResponse<String> sendGetRequest(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
    
    public CompletableFuture<HttpResponse<String>> sendPostRequest(String url, String body) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }
}

