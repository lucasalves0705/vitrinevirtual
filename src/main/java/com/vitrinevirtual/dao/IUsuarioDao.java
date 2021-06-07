package com.vitrinevirtual.dao;

import java.util.List;

import com.vitrinevirtual.Entidades.Usuario;

public interface IUsuarioDao {
	void save(Usuario usuario);	
	void update(Usuario usuario);
	void delete(Integer id);
	Usuario findById(Integer id);
	List<Usuario> findAll();
	Usuario findByUserName(String username);
}
