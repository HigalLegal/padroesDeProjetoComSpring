package one.digitalinnovation.labpadroesdeprojetosspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.labpadroesdeprojetosspring.model.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
