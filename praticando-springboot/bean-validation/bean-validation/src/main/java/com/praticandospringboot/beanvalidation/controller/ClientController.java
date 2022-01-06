package com.praticandospringboot.beanvalidation.controller;

import com.praticandospringboot.beanvalidation.model.Client;
import com.praticandospringboot.beanvalidation.repository.ClientRepository;
import com.praticandospringboot.beanvalidation.service.ClientService;
import com.praticandospringboot.beanvalidation.utils.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/client")
@Log4j2
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    public DateUtil dateUtil;

    @GetMapping("/findAllClient")
    public ResponseEntity<List<Client>> findAllClient() {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" Log Method GET findAllClient"));
        List<Client> listAllClient = new ArrayList<>();
        listAllClient = clientRepository.findAll();
        return new ResponseEntity<>(listAllClient, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return new ResponseEntity<>(clientRepository.getById(id), HttpStatus.OK);
    }

    @PostMapping("/updateClient")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" Log POST (updateClient)"));
        return new ResponseEntity<>(clientRepository.save(client), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Client> deleteById(@PathVariable Long id) {
        clientRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteClientById/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" Log DELETE (deleteClientById)"));
        return ResponseEntity.status(HttpStatus.OK).body(clientService.deleteClient(id));
    }


}