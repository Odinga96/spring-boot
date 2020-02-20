package com.security.securirtywithjpa.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class Hello {

    @GetMapping("/all")
    public String sayHello(){
        return "Hello visitor";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/secured/all")
    public String secured(){
        return "Secured visitor. Congrats you were successfully authenticated";
    }
}
