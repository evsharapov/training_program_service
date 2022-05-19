package com.example.trainingprogramservice.builder;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    public static ResponseEntity<?> build(Object data) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", ThreadContext.get("requestId"));
        return ResponseEntity.ok().headers(headers).body(data);
    }

}
