package br.com.lojavirtual.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userController")
public class UserController {

    @GetMapping("/administrative/users/signup")
    public ResponseEntity<String> signUp() {
        return ResponseEntity.status(HttpStatus.OK).body("admnistrative/users/signup");
    }

    @GetMapping("/administrative/users/listAll")
    public ResponseEntity<String> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body("/administrative/users/listAll");
    }

    @GetMapping("/administrative/users/signup2")
    public String signUp2() {
        return "admnistrative/users/signup";
    }

    @GetMapping("/administrative/users/listAll2")
    public String listAll2() {
        return "/administrative/users/listAll";
    }

}
