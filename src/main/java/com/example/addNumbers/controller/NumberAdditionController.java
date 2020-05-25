package com.example.addNumbers.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.example.addNumbers.service.NumberAdditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
public class NumberAdditionController {

    NumberAdditionService numberAdditionService;

    @Autowired
    public NumberAdditionController(NumberAdditionService numberAdditionService) {
        this.numberAdditionService = numberAdditionService;
    }

    @GetMapping("/")
    @ApiOperation("This is the hello world api")
    public String hello() {
        return "Hello World!!";
    }

    @PostMapping("/api/add")
    @ApiOperation("Addition of two numbers")
    public ResponseEntity<String> add(@RequestBody String requestBody) throws Exception {

        log.info("request body for addition of numbers: " + requestBody);

        String addNumbersResponse = numberAdditionService.addNumbers(requestBody);

        log.info("response body for addition of numbers: " + addNumbersResponse);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(addNumbersResponse, responseHeaders, HttpStatus.OK);
    }
}
