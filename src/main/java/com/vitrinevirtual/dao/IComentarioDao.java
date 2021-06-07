package com.vitrinevirtual.dao;

import java.util.List;

import com.vitrinevirtual.Entidades.Comentario;

public interface IComentarioDao {
	void save(Comentario comentario);
	Comentario findById(Integer id);
	List<Comentario> findAll();
}
