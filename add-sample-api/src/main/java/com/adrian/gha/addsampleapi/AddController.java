package com.adrian.gha.addsampleapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AddController {

    private final AddService addService;

    public AddController(AddService addService) {
        this.addService = addService;
    }

    @GetMapping("/add")
    public ResponseEntity<String> add(@RequestParam int a, @RequestParam int b) {
        String result = "Response is: " + addService.add(a, b);
        return new ResponseEntity<>(result, null, HttpStatus.OK);
    }
}
