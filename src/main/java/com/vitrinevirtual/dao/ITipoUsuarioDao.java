package com.vitrinevirtual.dao;

import java.util.List;
import com.vitrinevirtual.Entidades.TipoUsuario;

public interface ITipoUsuarioDao {
	void save(TipoUsuario tipoUsuario);	
	void update(TipoUsuario tipoUsuario);
	void delete(Integer id);
	TipoUsuario findById(Integer id);
	List<TipoUsuario> findAll();
}
