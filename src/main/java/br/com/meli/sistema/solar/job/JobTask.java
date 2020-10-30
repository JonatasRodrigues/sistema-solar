package br.com.meli.sistema.solar.job;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.meli.sistema.solar.constants.ApplicationConstants;
import br.com.meli.sistema.solar.model.Meteorologia;
import br.com.meli.sistema.solar.model.Planeta;
import br.com.meli.sistema.solar.model.Sol;
import br.com.meli.sistema.solar.service.MeteorologiaService;
import br.com.meli.sistema.solar.util.CalculoUtils;

@Component
public class JobTask {

	private static final Logger log = LoggerFactory.getLogger(JobTask.class);
	
	private static final int ANOS= 10;
	
	@Autowired
	private MeteorologiaService service;
	
	@PostConstruct
	public void inicializarBD() {
		log.info("Inicializando carga no banco de dados");
		
		int qtdDias = ANOS * ApplicationConstants.DIAS_POR_ANO;
		
		Sol sol = new Sol( new BigDecimal(0),  new BigDecimal(0));
		Planeta ferengis = new Planeta("ferengis", new BigDecimal(500),  new BigDecimal(0), 1);
		Planeta vulcanos = new Planeta("vulcanos",  new BigDecimal(1000),  new BigDecimal(0), 5);
		Planeta betasoid = new Planeta("betasoid",  new BigDecimal(2000),  new BigDecimal(0), 3);
		
		for (int i = 1; i <= qtdDias; i++) {
			if (i > 1) {
				rotacionarPlanetas(ferengis, vulcanos, betasoid);
			}

			Meteorologia m = new Meteorologia();
			m.setDia(i);
			m.setClima(getClima(ferengis, vulcanos, betasoid, sol));
			service.salvar(m);
		}
		
		log.info("Carga finalizada com sucesso.");
	}
	
	
	private String getClima(Planeta ferengis, Planeta vulcanos, Planeta betasoid, Sol sol) {
		
		if (CalculoUtils.isPlanetasAlinhados(ferengis, vulcanos, betasoid) && CalculoUtils.isSolAlinhado(ferengis, vulcanos, sol)) {
			return ApplicationConstants.CLIMA_SECO;
		}else if (CalculoUtils.isPlanetasAlinhados(ferengis, vulcanos, betasoid) && !CalculoUtils.isSolAlinhado(ferengis, vulcanos, sol)) {
			return ApplicationConstants.CLIMA_IDEAL;
		}else if (CalculoUtils.isBaricentro(ferengis, vulcanos, betasoid, sol)) {
			return ApplicationConstants.CLIMA_CHUVOSO;
		}
		
			return ApplicationConstants.CLIMA_DESCONHECIDO;
	}
	
	private void rotacionarPlanetas(Planeta ferengis, Planeta vulcanos, Planeta betasoid) {
		CalculoUtils.buildMatrizRotacaoHorario(ferengis);
		CalculoUtils.buildMatrizRotacaoHorario(betasoid);
		CalculoUtils.buildMatrizRotacaoAntiHorario(vulcanos);
	}
	
}
