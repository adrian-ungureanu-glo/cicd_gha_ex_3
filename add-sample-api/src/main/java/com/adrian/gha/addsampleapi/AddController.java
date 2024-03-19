package com.adrian.gha.addsampleapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {

    private final AddService addService;
    private final String env;

    public AddController(final AddService addService, @Value("${appEnvName}") final String env) {
        this.addService = addService;
        this.env = env;
    }

    @GetMapping("/add")
    public ResponseEntity<String> add(@RequestParam int a, @RequestParam int b) {
        String result = "Response is: " + addService.add(a, b);
        return new ResponseEntity<>(result, null, HttpStatus.OK);
    }

    @GetMapping("/greeting")
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>(String.format("Hello, world! (from env '%s')", env) , null, HttpStatus.OK);
    }
}
