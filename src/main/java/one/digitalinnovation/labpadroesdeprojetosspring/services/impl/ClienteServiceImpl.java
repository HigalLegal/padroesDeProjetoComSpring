package one.digitalinnovation.labpadroesdeprojetosspring.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.labpadroesdeprojetosspring.model.entities.Cliente;
import one.digitalinnovation.labpadroesdeprojetosspring.model.entities.Endereco;
import one.digitalinnovation.labpadroesdeprojetosspring.model.exceptions.ResourceNotFoundException;
import one.digitalinnovation.labpadroesdeprojetosspring.repositories.ClienteRepository;
import one.digitalinnovation.labpadroesdeprojetosspring.repositories.EnderecoRepository;
import one.digitalinnovation.labpadroesdeprojetosspring.services.ClienteService;
import one.digitalinnovation.labpadroesdeprojetosspring.services.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;

	@Override
	public List<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> buscarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente;
	}

	@Override
	public Cliente inserir(Cliente cliente) {
		cliente.setId(null);
		return salvarClienteComCep(cliente);
	}

	@Override
	public Cliente atualizar(Long id, Cliente cliente) {
		Optional<Cliente> verificador = clienteRepository.findById(id);

		if (verificador.isEmpty()) {
			throw new ResourceNotFoundException("Cliente não encontrado.");
		}

		cliente.setId(id);

		return clienteRepository.save(cliente);
	}

	@Override
	public void deletarPorId(Long id) {

		Optional<Cliente> verificador = clienteRepository.findById(id);

		if (verificador.isEmpty()) {
			throw new ResourceNotFoundException("Cliente não encontrado.");
		}

		clienteRepository.deleteById(id);
	}

	private Cliente salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		return clienteRepository.save(cliente);
	}

}
