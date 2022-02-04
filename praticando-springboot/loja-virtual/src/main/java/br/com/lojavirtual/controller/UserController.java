package br.com.lojavirtual.controller;

import br.com.lojavirtual.model.User;
import br.com.lojavirtual.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/administrative/users/signup")
    public ModelAndView cadastrar(User user) {
        ModelAndView mv = new ModelAndView("administrative/users/signup");
        mv.addObject("user", user);
        return mv;
    }

    @GetMapping("/administrative/users/list")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("/administrative/users/list");
        mv.addObject("listUsers", userRepository.findAll());
        return mv;
    }

    @PostMapping("/administrative/users/save")
    public ModelAndView salvar(@Validated User user, BindingResult result) {
        if(result.hasErrors()) {
            return cadastrar(user);
        }
        userRepository.saveAndFlush(user);
        return cadastrar(new User());
    }

}
