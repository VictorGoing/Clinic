package com.example.backclinic.api.covid.downloaded;

import lombok.Getter;

@Getter
public class CovidInfoDownloaded {
    private CovidDetails confirmed;
    private CovidDetails recovered;
    private CovidDetails deaths;
    private String lastUpdate;
}
