package com.example.backclinic.apis.covid.service;

import com.example.backclinic.apis.covid.downloaded.CovidInfoDownloaded;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class CovidInfoService {

    public CovidInfoDownloaded checkCountry(String country){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CovidInfoDownloaded> exchange = restTemplate.exchange(
                "https://covid19.mathdro.id/api/countries/" + country,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                CovidInfoDownloaded.class);
        return exchange.getBody();
    }
}
