package br.com.lojavirtual.controller;

import br.com.lojavirtual.model.Funcionario;
import br.com.lojavirtual.repository.FuncionarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class FuncionarioControle {

    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;

    @GetMapping("/administrativo/funcionarios/cadastrar")
    public ModelAndView cadastrar(Funcionario funcionario) {
        ModelAndView mv = new ModelAndView("administrative/users/signup");
        mv.addObject("user", funcionario);
        return mv;
    }

    @GetMapping("/administrativo/funcionarios/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("/administrative/users/list");
        mv.addObject("listUsers", funcionarioRepositorio.findAll());
        return mv;
    }

    @PostMapping("/administrativo/funcionarios/salvar")
    public ModelAndView salvar(@Valid Funcionario funcionario, BindingResult result) {
        if(result.hasErrors()) {
            return cadastrar(funcionario);
        }
        funcionarioRepositorio.saveAndFlush(funcionario);
        return cadastrar(new Funcionario());
    }

}
