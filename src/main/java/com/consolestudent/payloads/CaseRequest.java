package com.consolestudent.payloads;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaseRequest {

    String RecordType;
    String Subject;
    String Description;

}
