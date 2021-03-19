package com.visionarie.seguradora.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visionarie.seguradora.domain.exception.NegocioException;
import com.visionarie.seguradora.domain.model.Cliente;
import com.visionarie.seguradora.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		Optional<Cliente> clienteExistente = clienteRepository.findByCpf(cliente.getCpf());
		
		if(clienteExistente.isPresent() && !clienteExistente.get().equals(cliente)) {
			throw new NegocioException("J\u00E1 existe um cliente cadastrado com este cpf.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

}
