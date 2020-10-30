package br.com.meli.sistema.solar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.sistema.solar.model.Meteorologia;
import br.com.meli.sistema.solar.repository.MeteorologiaRepository;

@Service
public class MeteorologiaServiceImpl implements MeteorologiaService{

	@Autowired
	private MeteorologiaRepository meteorologiaRepository;
	
	public void salvar(Meteorologia meteorologia) {
		meteorologiaRepository.save(meteorologia);
	}
	
	public Meteorologia findByDia(Integer dia) {
		return meteorologiaRepository.findByDia(dia);
	}
}
