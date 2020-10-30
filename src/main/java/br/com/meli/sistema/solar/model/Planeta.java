package br.com.meli.sistema.solar.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Planeta {

	private String nome;
	private BigDecimal coordenadaX;
	private BigDecimal coordenadaY;
	private double rotacao;

	
	public Planeta(String nome, BigDecimal coordenadaX, BigDecimal coordenadaY, double rotacao) {
		super();
		this.nome = nome;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.rotacao = rotacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public double getRotacao() {
		return rotacao;
	}

	public void setRotacao(double rotacao) {
		this.rotacao = rotacao;
	}

	@Override
	public String toString() {
		return "Planeta [nome=" + nome + ", coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", rotacao="
				+ rotacao + "]";
	}
	
}
