package com.example.backclinic.api.eva.controller;

import com.example.backclinic.api.eva.downloaded.EmailDetails;
import com.example.backclinic.api.eva.service.EmailValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/email")
@RequiredArgsConstructor
public class EmailValidationController {

    private final EmailValidationService emailValidationService;

    @GetMapping(value = "{email}")
    public ResponseEntity<Boolean> checkEmail(@PathVariable String email){
        EmailDetails emailDetails = emailValidationService.checkEmail(email);
        Boolean bool = emailValidationService.checkEmailDetails(emailDetails);
        return ResponseEntity.ok(bool);
    }
}
