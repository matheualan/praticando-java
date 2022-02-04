package br.com.lojavirtual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controllerMain")
public class ControllerMain {

    @GetMapping("/administrative")
    public String acessarPrincipal() {
        return "administrative/home";
    }

}
