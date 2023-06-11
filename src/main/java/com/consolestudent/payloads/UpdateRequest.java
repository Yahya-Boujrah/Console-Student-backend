package com.consolestudent.payloads;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateRequest {

   @JsonProperty("status")
   private String status;

}
