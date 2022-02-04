package br.com.lojavirtual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerMain {

    @GetMapping("/administrative")
    public String accessMainPage() {
        return "/administrative/home.html";
    }

}
