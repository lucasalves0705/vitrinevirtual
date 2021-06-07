package com.vitrinevirtual.dao;


import java.util.List;
import com.vitrinevirtual.Entidades.Ramo;

public interface IRamoDao {
	void save(Ramo ramo);	
	void update(Ramo ramo);
	void delete(Integer id);
	Ramo findById(Integer id);
	List<Ramo> findAll();
}
