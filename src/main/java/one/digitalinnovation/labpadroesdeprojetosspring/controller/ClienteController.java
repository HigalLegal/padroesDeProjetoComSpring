package one.digitalinnovation.labpadroesdeprojetosspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.labpadroesdeprojetosspring.model.entities.Cliente;
import one.digitalinnovation.labpadroesdeprojetosspring.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService servico;
	
	//-------------------------------------------------

	@GetMapping
	public ResponseEntity<List<Cliente>> buscarTodos() {
		List<Cliente> resposta = servico.buscarTodos();
		
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> buscarPorId(@PathVariable Long id) {
		Optional<Cliente> resposta = servico.buscarPorId(id);
		
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
		Cliente resposta = servico.inserir(cliente);
		
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente resposta = servico.atualizar(id, cliente);

		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		servico.deletarPorId(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
