package br.com.meli.sistema.solar.app;

import java.math.BigDecimal;

import br.com.meli.sistema.solar.model.Planeta;
import br.com.meli.sistema.solar.model.Sol;
import br.com.meli.sistema.solar.service.CalculoService;

public class SistemaSolar {

	private static Planeta vulcanos;
	private static Planeta ferengis;
	private static Planeta betasoid;
	private static Sol sol;

	private static final int ANOS = 10;

	public static void main(String[] args) {
		System.out.println(String.format("Inicializando previsão do tempo dos próximos %s anos", ANOS));

		sol = new Sol(new BigDecimal(0), new BigDecimal(0));
		ferengis = new Planeta("ferengis", new BigDecimal(500), new BigDecimal(0), 1);
		vulcanos = new Planeta("vulcanos", new BigDecimal(1000), new BigDecimal(0), 5);
		betasoid = new Planeta("betasoid", new BigDecimal(2000), new BigDecimal(0), 3);

		CalculoService.verificarClima(ferengis, vulcanos, betasoid, sol, ANOS);
		
	}

}
