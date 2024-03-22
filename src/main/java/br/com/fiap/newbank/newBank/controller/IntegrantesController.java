package br.com.fiap.newbank.newBank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IntegrantesController {
    @GetMapping
    public String index(){
        return "Nicolas e Maria";
    }
}
