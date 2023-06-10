package com.consolestudent.payloads;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceRequest {


    private String Name;

    private String Etat__c;

    private String Type__c;

}
