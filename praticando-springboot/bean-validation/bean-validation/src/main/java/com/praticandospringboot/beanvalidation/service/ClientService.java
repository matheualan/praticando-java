package com.praticandospringboot.beanvalidation.service;

import com.praticandospringboot.beanvalidation.model.Client;
import com.praticandospringboot.beanvalidation.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public String deleteClient(Long id) {
        //verifyIfExist(id);
        clientRepository.deleteById(id);
        return String.format("Client com ID %d deletado com sucesso!", id);
    }

//    private Client verifyIfExist(Long id) {
//        return clientRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
//    }
}
