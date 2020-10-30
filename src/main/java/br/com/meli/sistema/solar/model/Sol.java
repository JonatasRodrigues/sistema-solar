package br.com.meli.sistema.solar.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sol {

	private BigDecimal coordenadaX;
	private BigDecimal coordenadaY;
	
	public Sol(BigDecimal coordenadaX, BigDecimal coordenadaY) {
		super();
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}

	public BigDecimal getCoordenadaX() {
		return coordenadaX.setScale(6, RoundingMode.HALF_UP);
	}

	public void setCoordenadaX(BigDecimal coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public BigDecimal getCoordenadaY() {
		return coordenadaY.setScale(6, RoundingMode.HALF_UP);
	}

	public void setCoordenadaY(BigDecimal coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

}
