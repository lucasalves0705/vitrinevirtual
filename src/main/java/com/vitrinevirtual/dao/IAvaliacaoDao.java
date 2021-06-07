package com.vitrinevirtual.dao;


import java.util.List;
import com.vitrinevirtual.Entidades.Avaliacao;

public interface IAvaliacaoDao {
	void save(Avaliacao avaliacao);	
	void update(Avaliacao avaliacao);
	void delete(Integer id);
	Avaliacao findById(Integer id);
	List<Avaliacao> findAll();
}
