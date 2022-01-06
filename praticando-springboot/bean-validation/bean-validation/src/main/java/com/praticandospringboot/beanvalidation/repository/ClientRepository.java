package com.praticandospringboot.beanvalidation.repository;

import com.praticandospringboot.beanvalidation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
