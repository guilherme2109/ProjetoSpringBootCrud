package com.visionarie.seguradora.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visionarie.seguradora.domain.model.Apolice;
import com.visionarie.seguradora.domain.repository.ApoliceRepository;
import com.visionarie.seguradora.domain.repository.ClienteRepository;

@Service
public class GestaoApolicesService {
	
	@Autowired
	private ApoliceRepository apoliceRepository;
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
//	public OrdemServico criar(OrdemServico ordemServico) {
//		
//		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId()).orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente n\u00E3o encontrado"));
//		
//		ordemServico.setCliente(cliente);
//		ordemServico.setStatus(StatusOrdemServico.ABERTA);
//		ordemServico.setDataAbertura(OffsetDateTime.now());
//		
//		return apoliceRepository.save(ordemServico);
//	}
	
//	public void finalizar(Long ordemServicoId) {
//		OrdemServico  ordemServico = buscar(ordemServicoId);
//		
//		ordemServico.finalizar();
//		
//		apoliceRepository.save(ordemServico);
//	}
//	
	public Apolice adicionarApolice(Integer numeroApolice) {
		
		Apolice apolice = new Apolice();
//		apolice.setFimVigencia(inicioVigencia);
//		apolice.setInicioVigencia(fimVigencia);
		apolice.setNumeroApolice(numeroApolice);
//		apolice.setPlacaVeiculo(placeVaiculo);
//		apolice.setValorApolice(valorApolice);
		
		return apoliceRepository.save(apolice);
	}
//	
//	private OrdemServico buscar(Long ordemServicoId) {
//		return ordemServicoRepository.findById(ordemServicoId).orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de servi\u00E7o n\u00E3o encontrada"));
//	}

}
