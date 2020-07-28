package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final String template2 = "So, %s, you found a secret page?";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "user") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/secret")
    public Greeting greeting2(@RequestParam(value = "name", defaultValue = "user") String name2) {
        return new Greeting(counter.incrementAndGet(), String.format(template2, name2));
    }

}