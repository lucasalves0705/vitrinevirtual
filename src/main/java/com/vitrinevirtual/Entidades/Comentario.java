package com.vitrinevirtual.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="comentario")
public class Comentario extends AbstractEntity <Integer>{
	@Column(name="comentario")
	private String conteudo;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	//Get and Set
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name="idUsuario")
	private Integer idUsuario;
	
	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}
