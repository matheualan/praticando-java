package br.com.bluebank.crudtest.resource;

import br.com.bluebank.crudtest.model.Person;
import br.com.bluebank.crudtest.repository.PersonRepository;
import br.com.bluebank.crudtest.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Api
@RestController
@RequestMapping("/persons")
@Log4j2
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DateUtil dateUtil;

//    public PersonResource(DateUtil dateUtil) {
//        this.dateUtil = dateUtil;
//    }
//
//    @GetMapping(path = "/listagem")
//    public List<Person> listagem() {
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()));
//        List<Person> listarPessoas = new ArrayList<>();
//        listarPessoas = personRepository.findAll();
//        return listarPessoas;
//    }

    @ApiOperation("Cadastrar uma pessoa por vez.")
    @PostMapping
    public ResponseEntity<Person> save (@RequestBody Person person) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()));
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @ApiOperation("Listar todos os cadastros.")
    @GetMapping(path = "/list")
    public ResponseEntity<List<Person>> getAll() {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()));
        List<Person> personList = new ArrayList<>();
        personList = personRepository.findAll();
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @ApiOperation("Buscar cadastro de uma pessoa por Id.")
    @GetMapping(path = "/list/{id}")
    public ResponseEntity<Optional<Person>> getById (@PathVariable Long id) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()));
        Optional<Person> person;
        try {
            person = personRepository.findById(id);
            return new ResponseEntity<Optional<Person>>(person, HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Person>>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation("Atualizar o cadastro de uma pessoa buscando por Id.")
    @PutMapping(value = "/att/{id}")
    public ResponseEntity<Person> update (@PathVariable Long id, @RequestBody Person novaPessoa) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()));
        return personRepository.findById(id)
                .map(person -> {
                    person.setNome(novaPessoa.getNome());
                    person.setDataNascimento(novaPessoa.getDataNascimento());
                    person.setProfissao(novaPessoa.getProfissao());
                    Person personUpdate = personRepository.save(person);
                    return ResponseEntity.ok().body(personUpdate);
                }).orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation("Deletar uma pessoa do cadastro buscando por Id.")
    @DeleteMapping(path = "/del/{id}")
    public ResponseEntity<Optional<Person>> deleteById(@PathVariable Long id) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()));
        try {
            personRepository.deleteById(id);
            return new ResponseEntity<Optional<Person>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Person>>(HttpStatus.NOT_FOUND);
        }
    }

}
