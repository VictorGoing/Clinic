package com.example.backclinic.apis.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovidInfoDto {
    private int confirmed;
    private int recovered;
    private int deaths;
    private String lastUpdate;
}
