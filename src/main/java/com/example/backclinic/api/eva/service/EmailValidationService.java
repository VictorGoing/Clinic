package com.example.backclinic.api.eva.service;

import com.example.backclinic.api.eva.downloaded.EmailDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class EmailValidationService {

    public EmailDetails checkEmail(String email){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EmailDetails> exchange = restTemplate.exchange(
                "https://api.eva.pingutil.com/email?email=" + email,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                EmailDetails.class);
        return exchange.getBody();
    }

    public Boolean checkEmailDetails(EmailDetails emailDetails){
        if(emailDetails.getStatus().equals("success") && emailDetails.getData().isValid_syntax())
            return Boolean.TRUE;
        else
            return  Boolean.FALSE;
    }
}
