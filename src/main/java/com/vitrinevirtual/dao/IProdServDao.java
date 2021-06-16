package com.vitrinevirtual.dao;


import com.vitrinevirtual.Entidades.ProdServ;
import java.util.List;

public interface IProdServDao {
	void save(ProdServ prodserv);	
	void update(ProdServ prodserv);
	void delete(Integer id);
	ProdServ findById(Integer id);
	List<ProdServ> findAll();
}
