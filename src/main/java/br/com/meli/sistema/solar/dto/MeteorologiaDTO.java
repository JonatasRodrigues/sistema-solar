package br.com.meli.sistema.solar.dto;

import br.com.meli.sistema.solar.model.Meteorologia;

public class MeteorologiaDTO {

	private int dia;
	private String clima;

	
	public static MeteorologiaDTO converterTo(Meteorologia meteorologia){
		MeteorologiaDTO dto = new MeteorologiaDTO();
		dto.setDia(meteorologia.getDia());
		dto.setClima(meteorologia.getClima());
		
		return dto;
	}
	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

}
