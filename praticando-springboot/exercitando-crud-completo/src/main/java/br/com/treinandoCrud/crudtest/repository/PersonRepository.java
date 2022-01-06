package br.com.treinandoCrud.crudtest.repository;

import br.com.treinandoCrud.crudtest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
