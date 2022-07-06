package com.example.backclinic.api.eva.downloaded;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EmailDetails {
    private String status;
    private EmailData data;
}
