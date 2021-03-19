package com.visionarie.seguradora.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.visionarie.seguradora.api.model.ApoliceInput;
import com.visionarie.seguradora.api.model.ApoliceModel;
import com.visionarie.seguradora.domain.exception.EntidadeNaoEncontradaException;
import com.visionarie.seguradora.domain.model.Apolice;
import com.visionarie.seguradora.domain.repository.ApoliceRepository;
import com.visionarie.seguradora.domain.service.GestaoApolicesService;

@RestController
@RequestMapping("/apolice-servico/{apoliceId}/apolices")
public class ApoliceController {
	
	@Autowired
	private GestaoApolicesService gestaoOrdemServico;
	
	@Autowired
	private ApoliceRepository apoliceRepository;
	
	@Autowired
	private ModelMapper modelMapper; 
	
	@GetMapping
	public List<ApoliceModel> listar(@PathVariable Long apoliceId) {
		@SuppressWarnings("unchecked")
		List<Apolice> apolices = (List<Apolice>) apoliceRepository.findById(apoliceId).orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de servi\\u00E7o n\\u00E3o encontrada"));
		
		return toCollectionModel(apolices);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ApoliceModel adicionar(@PathVariable Long apoliceId, @Valid @RequestBody ApoliceInput apoliceInput) {
		return toModel(gestaoOrdemServico.adicionarApolice(apoliceInput.getNumeroApolice()));
	}
	
	private ApoliceModel toModel(Apolice apoliceId) {
		return modelMapper.map(apoliceId, ApoliceModel.class);
	}
	
	private List<ApoliceModel> toCollectionModel(List<Apolice> apolice) {
		return apolice.stream()
				.map(numapolice -> toModel(numapolice))
				.collect(Collectors.toList());
	}

}
