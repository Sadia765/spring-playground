package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagesController {

    @GetMapping("/hello")
    public String getHello(){

        return "Hello from Spring!";
    }

    @GetMapping("/greeting")
    public String getQueryStrings(@RequestParam String first, @RequestParam String last){
        return "Hello "+ first + " " + last;
    }

    @GetMapping("/greeting/{first}/{last}")
    public String getPathVariables(@PathVariable String first, @PathVariable String last){
        return "Hi " + first + " " + last;
    }
}
