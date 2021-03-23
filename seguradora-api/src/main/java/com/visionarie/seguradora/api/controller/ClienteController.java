package com.visionarie.seguradora.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.visionarie.seguradora.domain.model.Cliente;
import com.visionarie.seguradora.domain.repository.ClienteRepository;
import com.visionarie.seguradora.domain.service.CadastroClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CadastroClienteService cadastroCliente;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{clienteID}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteID) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteID);
		
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return cadastroCliente.salvar(cliente);
	}
	
	@PutMapping("/{clienteID}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteID,@RequestBody Cliente cliente ) {
		
		if(!clienteRepository.existsById(clienteID)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(clienteID);
		cliente = cadastroCliente.alterar(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{clienteID}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteID) {
		
		if(!clienteRepository.existsById(clienteID)) {
			return ResponseEntity.notFound().build();
		}
		
		cadastroCliente.excluir(clienteID);
		
		return ResponseEntity.noContent().build();
	}

}
