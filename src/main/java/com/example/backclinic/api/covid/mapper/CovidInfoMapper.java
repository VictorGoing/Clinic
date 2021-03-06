package com.example.backclinic.api.covid.mapper;

import com.example.backclinic.api.covid.downloaded.CovidInfoDownloaded;
import com.example.backclinic.api.covid.dto.CovidInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CovidInfoMapper {

    public CovidInfoDto mapToCovidInfoDto(CovidInfoDownloaded covidInfoDownloaded){
        return new CovidInfoDto(
                covidInfoDownloaded.getConfirmed().getValue(),
                covidInfoDownloaded.getRecovered().getValue(),
                covidInfoDownloaded.getDeaths().getValue(),
                covidInfoDownloaded.getLastUpdate()
        );
    }
}
