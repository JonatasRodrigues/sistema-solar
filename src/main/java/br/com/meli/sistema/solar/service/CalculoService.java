package br.com.meli.sistema.solar.service;

import java.math.BigDecimal;

import br.com.meli.sistema.solar.constants.ApplicationConstants;
import br.com.meli.sistema.solar.model.Planeta;
import br.com.meli.sistema.solar.model.Sol;
import br.com.meli.sistema.solar.util.CalculoUtils;

public class CalculoService {

	private static final BigDecimal MAIOR_PERIMETRO = new BigDecimal(6271.703622671095);
	private static int countPeriodoChuva = 0, countMaiorDiaChuva = 0, countPeriodoIdeal = 0, countPeriodoSeca = 0;

	public static void verificarClima(Planeta ferengis, Planeta vulcanos, Planeta betasoid, Sol sol, int anos) {
		int qtdDias = anos * ApplicationConstants.DIAS_POR_ANO;

		for (int i = 1; i <= qtdDias; i++) {
			if (i > 1) {
				rotacionarPlanetas(ferengis, vulcanos, betasoid);
			}

			contabilizarPeriodoDeSeca(ferengis, vulcanos, betasoid, sol);
			contabilizarPeriodoIdeal(ferengis, vulcanos, betasoid, sol);
			contabilizarPeriodoDeChuva(ferengis, vulcanos, betasoid, sol, i);

		}

		System.out.println("Dias com pico de chuva: " + countMaiorDiaChuva);
		System.out.println("Periodo Chuva : " + countPeriodoChuva);
		System.out.println("Periodo Ideal : " + countPeriodoIdeal);
		System.out.println("Periodo Seca : " + countPeriodoSeca);

	}

	private static void contabilizarPeriodoDeSeca(Planeta ferengis, Planeta vulcanos, Planeta betasoid, Sol sol) {
		if (CalculoUtils.isPlanetasAlinhados(ferengis, vulcanos, betasoid) && CalculoUtils.isSolAlinhado(ferengis, vulcanos, sol)) {
			countPeriodoSeca += 1;
		}
	}

	private static void contabilizarPeriodoIdeal(Planeta ferengis, Planeta vulcanos, Planeta betasoid, Sol sol) {
		if (CalculoUtils.isPlanetasAlinhados(ferengis, vulcanos, betasoid) && !CalculoUtils.isSolAlinhado(ferengis, vulcanos, sol)) {
			countPeriodoIdeal += 1;
		}

	}

	private static void contabilizarPeriodoDeChuva(Planeta ferengis, Planeta vulcanos, Planeta betasoid, Sol sol, int dia) {
		if (CalculoUtils.isBaricentro(ferengis, vulcanos, betasoid, sol)) {
			countPeriodoChuva += 1;

			if (CalculoUtils.calcularPerimetro(ferengis, vulcanos, betasoid).compareTo(MAIOR_PERIMETRO)==0) {
				countMaiorDiaChuva += 1;
				 System.out.println("Dia com maior chuva: " + dia);
			}
		}
	}
	
	private static void rotacionarPlanetas(Planeta ferengis, Planeta vulcanos, Planeta betasoid) {
		CalculoUtils.buildMatrizRotacaoHorario(ferengis);
		CalculoUtils.buildMatrizRotacaoHorario(betasoid);
		CalculoUtils.buildMatrizRotacaoAntiHorario(vulcanos);
	}
}
