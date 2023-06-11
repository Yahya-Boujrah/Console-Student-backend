package com.consolestudent.payloads;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateRequest {

    private String status;

}
