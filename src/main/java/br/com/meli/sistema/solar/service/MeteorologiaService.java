package br.com.meli.sistema.solar.service;

import br.com.meli.sistema.solar.model.Meteorologia;

public interface MeteorologiaService {

	public void salvar(Meteorologia meteorologia);

	public Meteorologia findByDia(Integer dia);
}
