package com.vitrinevirtual.dao;


import com.vitrinevirtual.Entidades.Empresa;
import java.util.List;

public interface IEmpresaDao {
	void save(Empresa empresa);	
	void update(Empresa empresa);
	void delete(Integer id);
	Empresa findById(Integer id);
	List<Empresa> findAll();
}
