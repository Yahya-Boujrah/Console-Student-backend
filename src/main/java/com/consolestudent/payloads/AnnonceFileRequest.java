package com.consolestudent.payloads;

import lombok.Data;

@Data
public class AnnonceFileRequest {
    private String salesforceId;
    private String file;
}
