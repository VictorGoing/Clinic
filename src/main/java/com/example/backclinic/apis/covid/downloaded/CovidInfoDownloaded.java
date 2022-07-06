package com.example.backclinic.apis.covid.downloaded;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CovidInfoDownloaded {
    private CovidDetails confirmed;
    private CovidDetails recovered;
    private CovidDetails deaths;
    private String lastUpdate;
}
