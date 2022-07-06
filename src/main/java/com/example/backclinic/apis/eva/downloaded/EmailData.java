package com.example.backclinic.apis.eva.downloaded;

import lombok.Getter;

@Getter
public class EmailData {
    private String email_address;
    private String domain;
    private boolean valid_syntax;
    private boolean disposable;
    private boolean webmail;
    private boolean deliverable;
    private boolean catch_all;
    private boolean gibberish;
    private boolean spam;
}
