package com.devsuperior.hrworker.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping
    public String home() {
        return "Hello World";
    }

    @GetMapping("/hr-worker")
    public String wrongPath() {
        return "Está no caminho errado";
    }

}
