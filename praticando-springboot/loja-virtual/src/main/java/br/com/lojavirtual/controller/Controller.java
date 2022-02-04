package br.com.lojavirtual.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/administrative")
    public String acessarPrincipal() {
        return "administrative/home";
    }

}
