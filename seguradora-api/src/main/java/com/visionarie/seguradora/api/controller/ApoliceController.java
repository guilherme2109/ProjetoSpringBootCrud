package com.visionarie.seguradora.api.controller;

import java.util.List;

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

import com.visionarie.seguradora.api.model.ApoliceRetorno;
import com.visionarie.seguradora.domain.model.Apolices;
import com.visionarie.seguradora.domain.repository.ApoliceRepository;
import com.visionarie.seguradora.domain.service.GestaoApolicesService;

@RestController
@RequestMapping("/apolices")
public class ApoliceController {

	@Autowired
	private ApoliceRepository apoliceRepository;

	@Autowired
	private GestaoApolicesService gestaoApolicesService;

	@GetMapping
	public List<Apolices> listar() {
		return apoliceRepository.findAll();
	}

	@GetMapping("/{apoliceID}")
	public ResponseEntity<ApoliceRetorno> buscar(@PathVariable Long apoliceID) {

		ApoliceRetorno apoliceRetorno = gestaoApolicesService.recuperarApolice(apoliceID);

		if (apoliceRetorno==null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(apoliceRetorno);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Apolices adicionar(@Valid @RequestBody Apolices apolice) {
		return gestaoApolicesService.salvar(apolice);
	}

	@PutMapping("/{apoliceID}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Apolices> atualizar(@PathVariable Long apoliceID, @RequestBody Apolices apolice) {

		if (!apoliceRepository.existsById(apoliceID)) {
			return ResponseEntity.notFound().build();
		}

		apolice.setIdApolice(apoliceID);
		apolice = gestaoApolicesService.alterar(apolice);

		return ResponseEntity.ok(apolice);
	}

	@DeleteMapping("/{apoliceID}")
	public ResponseEntity<Void> remover(@PathVariable Long apoliceID) {

		if (!apoliceRepository.existsById(apoliceID)) {
			return ResponseEntity.notFound().build();
		}

		gestaoApolicesService.excluir(apoliceID);

		return ResponseEntity.noContent().build();
	}

}
