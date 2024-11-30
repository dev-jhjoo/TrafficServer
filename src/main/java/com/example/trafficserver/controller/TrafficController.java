package com.example.trafficserver.controller;

import com.example.trafficserver.dto.MyResult;
import com.example.trafficserver.service.TrafficService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrafficController {

    private final TrafficService trafficService;

    @Autowired
    public TrafficController(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    @GetMapping("/traffic")
    public ResponseEntity<MyResult> exec(HttpServletRequest request) {
        System.out.println("request: " + request);
        MyResult result = trafficService.exec(request);
        return ResponseEntity
                .status(trafficService.getHttpStatus(result))
                .body(result);
    }
}
