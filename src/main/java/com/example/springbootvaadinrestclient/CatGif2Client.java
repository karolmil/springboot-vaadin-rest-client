package com.example.springbootvaadinrestclient;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SourceFilteringListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;

@Service
public class CatGif2Client {
    private RestTemplate restTemplate;

    public CatGif2Client() {
        this.restTemplate = new RestTemplate();
    }


    public String getCatGifForm2Api() {
        String url;
        while (true) {
            ResponseEntity<String> exchange = restTemplate.exchange(
                    "https://aws.random.cat/meow",
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    String.class);

            String json = exchange.getBody();
            JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
            url = jsonObject.get("file").getAsString();
            if (url.endsWith(".gif"))
                break;
        }
        return url;

    }
}