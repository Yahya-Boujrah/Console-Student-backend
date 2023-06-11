package com.consolestudent.payloads;


import lombok.Data;

@Data
public class SalesforceId {

    private String id;

    public SalesforceId(String id) {
        this.id = id;
    }
}
