package com.visionarie.seguradora.domain.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visionarie.seguradora.api.model.ApoliceRetorno;
import com.visionarie.seguradora.domain.model.Apolices;
import com.visionarie.seguradora.domain.repository.ApoliceRepository;

@Service
public class GestaoApolicesService {

	private static final String APOLICE_VENCIDA = "Apólice vencida.";
	private static final String DENTRO_DO_PRAZO = "Dentro do prazo.";
	private static final int VALOR_MAX_APOLICE = 100000000;
	@Autowired
	private ApoliceRepository apoliceRepository;

	public Apolices salvar(Apolices apolice) {

		Random gerador = new Random();
		Long valoApolice = (long) gerador.nextInt(VALOR_MAX_APOLICE);

		Apolices apoliceExistente = apoliceRepository.findByNumeroApolice(valoApolice);

		if (apoliceExistente.getNumeroApolice().equals(apoliceExistente.getNumeroApolice())) {
			salvar(apolice);
		}

		apolice.setNumeroApolice(valoApolice);
		return apoliceRepository.save(apolice);
	}

	public Apolices alterar(Apolices apolice) {
		return apoliceRepository.save(apolice);
	}

	public void excluir(Long apoliceID) {
		apoliceRepository.deleteById(apoliceID);
	}

	public ApoliceRetorno recuperarApolice(Long apoliceID) {
		Apolices apolice = apoliceRepository.findById(apoliceID).get();
		ApoliceRetorno apoliceRetorno = null;

		if (apolice != null) {
			apoliceRetorno = new ApoliceRetorno();
			apoliceRetorno.setNumeroApolice(apolice.getNumeroApolice().intValue());
			apoliceRetorno.setPlacaVeiculo(apolice.getPlacaVeiculo());
			apoliceRetorno.setValorApolice(apolice.getValorApolice());
			
			Calendar cal = new GregorianCalendar();
			cal.setTime(apolice.getFimVigencia());
			
			@SuppressWarnings("static-access")
			LocalDate localDate = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(cal.DAY_OF_MONTH) + 1);

			if (localDate.isEqual(LocalDate.now())) {
				apoliceRetorno.setVencimentoApolice(DENTRO_DO_PRAZO);
				apoliceRetorno.setMensagem("Sua apolice vencerá hoje. ");

			} else if (localDate.isAfter(LocalDate.now())) {

				apoliceRetorno.setVencimentoApolice(DENTRO_DO_PRAZO);
				apoliceRetorno.setMensagem(
						"Sua apolice vencerá em " + ChronoUnit.DAYS.between(LocalDate.now(), localDate) + " dias");

			} else if (localDate.isBefore(LocalDate.now())) {

				apoliceRetorno.setVencimentoApolice(APOLICE_VENCIDA);
				apoliceRetorno.setMensagem(
						"Sua apolice venceu a " + ChronoUnit.DAYS.between(LocalDate.now(), localDate) + " dias");
			}
		}

		return apoliceRetorno;
	}

	/**
	 * @param data
	 * @return
	 */
	public static Date extrairData(Date data) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(data);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

}
