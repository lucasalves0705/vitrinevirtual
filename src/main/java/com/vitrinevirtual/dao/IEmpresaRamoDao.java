package com.vitrinevirtual.dao;

import java.util.List;

import com.vitrinevirtual.Entidades.Avaliacao;
import com.vitrinevirtual.Entidades.EmpresaRamo;

public interface IEmpresaRamoDao {

	void save(EmpresaRamo avaliacao);	
	void update(EmpresaRamo avaliacao);
	void delete(Integer id);
	EmpresaRamo findById(Integer id);
	List<EmpresaRamo> findAll();
	void deletarPorEmpresa(Integer empresaid);
	List<EmpresaRamo> findPorEmpresa(Integer empresaid);
}
