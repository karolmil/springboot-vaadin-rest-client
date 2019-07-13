package com.example.springbootvaadinrestclient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class CatGifClient {


    public String getCatGifFormApi() {
        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<CatGif> exchange = restTemplate.exchange(
                "https://purr.objects-us-east-1.dream.io/i/h1TCS.jpg",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                CatGif.class);


        return exchange.getBody().getFile();
    }

}
