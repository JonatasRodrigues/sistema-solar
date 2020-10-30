package br.com.meli.sistema.solar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import br.com.meli.sistema.solar.model.Planeta;
import br.com.meli.sistema.solar.model.Sol;

public class UtilsTest {

	@Test
	public void testRotacaoAntiHorario30() {
		Planeta planeta = new Planeta("planeta01",new BigDecimal(3), new BigDecimal(4),30);
		CalculoUtils.buildMatrizRotacaoAntiHorario(planeta);
		assertEquals(new BigDecimal(0.6).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaX().setScale(2, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal(4.96).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaY().setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void testRotacaoAntiHorario90() {
		Planeta planeta = new Planeta("planeta01",new BigDecimal(3), new BigDecimal(0),90);
		CalculoUtils.buildMatrizRotacaoAntiHorario(planeta);
		assertEquals(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaX().setScale(2, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal(3).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaY().setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void testRotacaoAntiHorario180() {
		Planeta planeta = new Planeta("planeta01",new BigDecimal(3), new BigDecimal(0),180);
		CalculoUtils.buildMatrizRotacaoAntiHorario(planeta);
		assertEquals(new BigDecimal(-3).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaX().setScale(2, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaY().setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void testRotacaoAntiHorario360() {
		Planeta planeta = new Planeta("planeta01",new BigDecimal(3), new BigDecimal(0),360);
		CalculoUtils.buildMatrizRotacaoHorario(planeta);
		assertEquals(new BigDecimal(3).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaX().setScale(2, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaY().setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void testRotacaoSentidoHorario45() {
		Planeta planeta = new Planeta("planeta01",new BigDecimal(2), new BigDecimal(3),45);
		CalculoUtils.buildMatrizRotacaoHorario(planeta);
		assertEquals(new BigDecimal(3.54).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaX().setScale(2, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal(0.71).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaY().setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void testRotacaoSentidoHorario60() {
		Planeta planeta = new Planeta("planeta01",new BigDecimal(3), new BigDecimal(4),60);
		CalculoUtils.buildMatrizRotacaoHorario(planeta);
		assertEquals(new BigDecimal(4.96).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaX().setScale(2, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal(-0.6).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaY().setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void testRotacaoSentidoHorario180() {
		Planeta planeta = new Planeta("planeta01",new BigDecimal(3), new BigDecimal(0),180);
		CalculoUtils.buildMatrizRotacaoHorario(planeta);
		assertEquals(new BigDecimal(-3).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaX().setScale(2, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaY().setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void testRotacaoSentidoHorario360() {
		Planeta planeta = new Planeta("planeta01",new BigDecimal(3), new BigDecimal(0),360);
		CalculoUtils.buildMatrizRotacaoHorario(planeta);
		assertEquals(new BigDecimal(3).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaX().setScale(2, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP), planeta.getCoordenadaY().setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void testPlanetaAlinhados() {
		Planeta ferengis = new Planeta("ferengis", new BigDecimal(1), new BigDecimal(2), 1);
		Planeta vulcanos = new Planeta("vulcanos", new BigDecimal(3), new BigDecimal(3), 5);
		Planeta betasoid = new Planeta("betasoid", new BigDecimal(5), new BigDecimal(4), 3);
		assertEquals(true, CalculoUtils. isPlanetasAlinhados(ferengis, vulcanos, betasoid));
	}
	
	@Test
	public void testPlanetaAlinhadosVerticalmente() {
		Planeta ferengis = new Planeta("ferengis", new BigDecimal(2), new BigDecimal(1), 1);
		Planeta vulcanos = new Planeta("vulcanos", new BigDecimal(2), new BigDecimal(2), 5);
		Planeta betasoid = new Planeta("betasoid", new BigDecimal(2), new BigDecimal(3), 3);
		assertEquals(true, CalculoUtils. isPlanetasAlinhados(ferengis, vulcanos, betasoid));
	}
	
	@Test
	public void testPlanetaNaoAlinhados() {
		Planeta ferengis = new Planeta("ferengis", new BigDecimal(1), new BigDecimal(3), 1);
		Planeta vulcanos = new Planeta("vulcanos", new BigDecimal(3), new BigDecimal(4), 5);
		Planeta betasoid = new Planeta("betasoid", new BigDecimal(1), new BigDecimal(2), 3);
		assertEquals(false, CalculoUtils. isPlanetasAlinhados(ferengis, vulcanos, betasoid));
	}
	
	@Test
	public void testSolAlinhados() {
		Sol sol = new Sol(new BigDecimal(0), new BigDecimal(0));
		Planeta ferengis = new Planeta("ferengis", new BigDecimal(1), new BigDecimal(1), 1);
		Planeta vulcanos = new Planeta("vulcanos", new BigDecimal(3), new BigDecimal(3), 5);
		assertEquals(true, CalculoUtils. isSolAlinhado(ferengis, vulcanos, sol));
	}
	
	@Test
	public void testNaoSolAlinhados() {
		Sol sol = new Sol(new BigDecimal(0), new BigDecimal(0));
		Planeta ferengis = new Planeta("ferengis", new BigDecimal(1), new BigDecimal(1), 1);
		Planeta vulcanos = new Planeta("vulcanos", new BigDecimal(3), new BigDecimal(4), 5);
		assertEquals(false, CalculoUtils. isSolAlinhado(ferengis, vulcanos, sol));
	}
	
	@Test
	public void testCalcularPerimetro() {
		Planeta ferengis = new Planeta("ferengis", new BigDecimal(3), new BigDecimal(6), 1);
		Planeta vulcanos = new Planeta("vulcanos", new BigDecimal(1), new BigDecimal(2), 5);
		Planeta betasoid = new Planeta("betasoid", new BigDecimal(5), new BigDecimal(1), 3);
		assertEquals(new BigDecimal(13.98).setScale(2, RoundingMode.HALF_UP), CalculoUtils. calcularPerimetro(ferengis, vulcanos, betasoid).setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void testSolDentroDoTriangulo() {
		Sol sol = new Sol(new BigDecimal(0), new BigDecimal(0));
		Planeta ferengis = new Planeta("ferengis", new BigDecimal(3), new BigDecimal(2), 1);
		Planeta vulcanos = new Planeta("vulcanos", new BigDecimal(-1), new BigDecimal(-2), 5);
		Planeta betasoid = new Planeta("betasoid", new BigDecimal(-2), new BigDecimal(3), 3);
		assertEquals(true, CalculoUtils. isBaricentro(ferengis, vulcanos, betasoid, sol));
	}
	
	@Test
	public void testSolForaDoTriangulo() {
		Sol sol = new Sol(new BigDecimal(0),  new BigDecimal(0));
		Planeta ferengis = new Planeta("ferengis", new BigDecimal(4), new BigDecimal(2), 1);
		Planeta vulcanos = new Planeta("vulcanos", new BigDecimal(2), new BigDecimal(4), 5);
		Planeta betasoid = new Planeta("betasoid", new BigDecimal(1), new BigDecimal(1), 3);
		assertEquals(false, CalculoUtils. isBaricentro(ferengis, vulcanos, betasoid, sol));
	}
}
