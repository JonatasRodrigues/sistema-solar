package br.com.meli.sistema.solar.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.sistema.solar.dto.MeteorologiaDTO;
import br.com.meli.sistema.solar.service.MeteorologiaService;

@RestController
@RequestMapping("/api/v1")
public class MeteorologiaController {

	private static final Logger logger = LogManager.getLogger(MeteorologiaController.class);
	
	@Autowired
	private MeteorologiaService meteorologiaService;
	
	@GetMapping("/clima")
	public ResponseEntity<MeteorologiaDTO> buscarPorDia(@RequestParam Integer dia) {
		logger.info("Buscando clima por dia: {}", dia);
		return new ResponseEntity<MeteorologiaDTO>(MeteorologiaDTO.converterTo(meteorologiaService.findByDia(dia)), HttpStatus.OK);
	}
}
