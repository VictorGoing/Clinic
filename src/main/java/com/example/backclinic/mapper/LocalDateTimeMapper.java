package com.example.backclinic.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LocalDateTimeMapper {

    public LocalDateTime mapToLocalDateTime(String string){
        string = string.substring(20,40);
        return LocalDateTime.parse(string);
    }
}
