package com.example.backclinic.apis.covid.controller;

import com.example.backclinic.apis.covid.downloaded.CovidInfoDownloaded;
import com.example.backclinic.apis.covid.dto.CovidInfoDto;
import com.example.backclinic.apis.covid.mapper.CovidInfoMapper;
import com.example.backclinic.apis.covid.service.CovidInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/covidInfo")
@RequiredArgsConstructor
public class CovidInfoController {

    private final CovidInfoService covidInfoService;
    private final CovidInfoMapper covidInfoMapper;
    @GetMapping(value = "{country}")
    public ResponseEntity<CovidInfoDto> checkCountry(@PathVariable String country){
        CovidInfoDownloaded  covidInfoDownloaded = covidInfoService.checkCountry(country);
        CovidInfoDto covidInfoDto = covidInfoMapper.mapToCovidInfoDto(covidInfoDownloaded);
        return ResponseEntity.ok(covidInfoDto);
    }
}
