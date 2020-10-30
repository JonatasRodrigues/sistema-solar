package br.com.meli.sistema.solar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meli.sistema.solar.model.Meteorologia;

@Repository
public interface MeteorologiaRepository extends JpaRepository<Meteorologia,Integer>{

	public Meteorologia findByDia(Integer dia);
}
