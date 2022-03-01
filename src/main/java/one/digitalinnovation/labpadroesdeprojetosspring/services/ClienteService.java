package one.digitalinnovation.labpadroesdeprojetosspring.services;

import java.util.List;
import java.util.Optional;

import one.digitalinnovation.labpadroesdeprojetosspring.model.entities.Cliente;

public interface ClienteService {
	
	List<Cliente> buscarTodos();
	Optional<Cliente> buscarPorId(Long id);
	Cliente inserir(Cliente cliente);
	Cliente atualizar(Long id, Cliente cliente);
	void deletarPorId(Long id);

}
