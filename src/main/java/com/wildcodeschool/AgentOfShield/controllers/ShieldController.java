package com.wildcodeschool.AgentOfShield.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShieldController {

    @GetMapping("/")
    public String all() {
        return "Welcome to the SHIELD";
    }

    @GetMapping("/avengers/assemble")
    public String champion() {
        return "Avengers... Assemble";
    }

    @GetMapping("/secret-bases")
    public String redirect() {
        return "Biarritz\n" +
        "Bordeaux\n" +
        "La Loupe \uD83C\uDF32\n" +
        "Lille\n" +
        "Lyon\n" +
        "Nantes\n" +
        "Orléans\n" +
        "Paris\n" +
        "Reims\n" +
        "Strasbourg\n" +
        "Toulouse";
    }

}