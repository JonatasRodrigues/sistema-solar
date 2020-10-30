package br.com.meli.sistema.solar.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.meli.sistema.solar.model.Planeta;
import br.com.meli.sistema.solar.model.Sol;

public class CalculoUtils {
	
	//verifica se os planetas estão alinhados
	public static boolean isPlanetasAlinhados(Planeta planeta1, Planeta planeta2, Planeta planeta3) {
		BigDecimal diagonal1 = planeta1.getCoordenadaY().multiply(planeta2.getCoordenadaX())
				.add(planeta2.getCoordenadaY().multiply(planeta3.getCoordenadaX()))
				.add(planeta3.getCoordenadaY().multiply(planeta1.getCoordenadaX()));
		
		BigDecimal diagonal2 = planeta1.getCoordenadaX().multiply(planeta2.getCoordenadaY())
				.add(planeta2.getCoordenadaX().multiply(planeta3.getCoordenadaY()))
				.add(planeta3.getCoordenadaX().multiply(planeta1.getCoordenadaY()));
		
		BigDecimal res = diagonal1.subtract(diagonal2);
		
		return res.setScale(2, RoundingMode.HALF_UP).compareTo(new BigDecimal(0.00))==0;
	}
	
	//verifica se o sol está alinhado com os planetas
	public static boolean isSolAlinhado(Planeta planeta1, Planeta planeta2, Sol sol) {
		BigDecimal diagonal1 = sol.getCoordenadaY().multiply(planeta1.getCoordenadaX())
				.add(planeta1.getCoordenadaY().multiply(planeta2.getCoordenadaX()))
				.add(planeta2.getCoordenadaY().multiply(sol.getCoordenadaX()));
		
		BigDecimal diagonal2 = sol.getCoordenadaX().multiply(planeta1.getCoordenadaY())
				.add(planeta1.getCoordenadaX().multiply(planeta2.getCoordenadaY()))
				.add(planeta2.getCoordenadaX().multiply(sol.getCoordenadaY()));
		
		BigDecimal res = diagonal1.subtract(diagonal2);

		return res.setScale(2, RoundingMode.HALF_UP).compareTo(new BigDecimal(0.00))==0;
		
	}
	
	//calcula o perimetro do triangulo
	public static BigDecimal calcularPerimetro(Planeta planeta1, Planeta planeta2, Planeta planeta3) {
		double ab = obterDistanciaEntreLados(planeta1, planeta2);
		double ac =  obterDistanciaEntreLados(planeta1, planeta3);
		double bc =  obterDistanciaEntreLados(planeta2, planeta3);
		return new BigDecimal(ab + ac + bc);
	}
	
	//calcula a distancia entre os lados do triangulo
	private static double obterDistanciaEntreLados(Planeta planeta1, Planeta planeta2) {
		double a = Math.pow((planeta2.getCoordenadaX().subtract(planeta1.getCoordenadaX()).doubleValue()),2);
		double b = Math.pow((planeta2.getCoordenadaY().subtract(planeta1.getCoordenadaY()).doubleValue()),2);
		return Math.sqrt(a + b);
	}
	
	//verifica se o sol está dentro do triangulo
	public static boolean isBaricentro(Planeta planeta1, Planeta planeta2, Planeta planeta3, Sol sol) {
		BigDecimal x1 = (sol.getCoordenadaX().subtract(planeta1.getCoordenadaX()))
				.multiply((planeta2.getCoordenadaY().subtract(planeta1.getCoordenadaY())))
				.subtract((sol.getCoordenadaY().subtract(planeta1.getCoordenadaY()))
				.multiply((planeta2.getCoordenadaX().subtract(planeta1.getCoordenadaX()))))
				.setScale(6, RoundingMode.HALF_UP);
		
		BigDecimal x2 = (sol.getCoordenadaX().subtract(planeta2.getCoordenadaX()))
				.multiply((planeta3.getCoordenadaY().subtract(planeta2.getCoordenadaY())))
				.subtract((sol.getCoordenadaY().subtract(planeta2.getCoordenadaY()))
				.multiply((planeta3.getCoordenadaX().subtract(planeta2.getCoordenadaX()))))
				.setScale(6, RoundingMode.HALF_UP);
		
		BigDecimal x3 = (sol.getCoordenadaX().subtract(planeta3.getCoordenadaX()))
				.multiply((planeta1.getCoordenadaY().subtract(planeta3.getCoordenadaY())))
				.subtract((sol.getCoordenadaY().subtract(planeta3.getCoordenadaY()))
				.multiply((planeta1.getCoordenadaX().subtract(planeta3.getCoordenadaX()))))
				.setScale(6, RoundingMode.HALF_UP);

		return (x1.compareTo(new BigDecimal(0.00))==1 &&  x2.compareTo(new BigDecimal(0.00))==1 
				&&  x3.compareTo(new BigDecimal(0.00))==1) 
				|| (x1.compareTo(new BigDecimal(0.00))== -1 &&  x2.compareTo(new BigDecimal(0.00))== -1 
						&&  x3.compareTo(new BigDecimal(0.00))== -1);
	}
	
	//rotaciona um planeta no sentido horario
	public static void buildMatrizRotacaoHorario(Planeta planeta) {
		BigDecimal x1 = (calcularCosseno(planeta.getRotacao()).multiply(planeta.getCoordenadaX())).add((calcularSeno(planeta.getRotacao())
				.multiply(planeta.getCoordenadaY())));
		BigDecimal y1 = ((calcularSeno(planeta.getRotacao()).multiply(new BigDecimal(-1))).multiply(planeta.getCoordenadaX()))
				.add((calcularCosseno(planeta.getRotacao()).multiply(planeta.getCoordenadaY())));
		planeta.setCoordenadaX(x1);
		planeta.setCoordenadaY(y1);
	}
	
	//rotaciona um planeta no sentido anti-horario
	public static void buildMatrizRotacaoAntiHorario(Planeta planeta) {
		BigDecimal x1 = (calcularCosseno(planeta.getRotacao()).multiply(planeta.getCoordenadaX()).subtract(calcularSeno(planeta.getRotacao()).multiply(planeta.getCoordenadaY())));
		BigDecimal y1 = (calcularSeno(planeta.getRotacao()).multiply(planeta.getCoordenadaX()).add(calcularCosseno(planeta.getRotacao()).multiply(planeta.getCoordenadaY())));
		planeta.setCoordenadaX(x1);
		planeta.setCoordenadaY(y1);
	}
	

	// Dado um angulo em graus retornar o cosseno
	private static BigDecimal calcularCosseno(double angulo) {
		double valor = Math.cos(Math.toRadians(angulo));
		return new BigDecimal(valor).setScale(6, RoundingMode.HALF_UP);
	}
	
	// Dado um angulo em graus retornar o sen
	private static BigDecimal calcularSeno(double angulo) {
		double valor =  Math.sin(Math.toRadians(angulo));
		return new BigDecimal(valor).setScale(6, RoundingMode.HALF_UP);
	}
}
