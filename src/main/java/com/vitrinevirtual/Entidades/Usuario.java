package com.vitrinevirtual.Entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario extends AbstractEntity <Integer>{
	@ManyToOne
    @JoinColumn(name = "id_tipouser")
    private TipoUsuario id_tipouser;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="nascimento", columnDefinition = "DATE")
	private java.sql.Date nascimento;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="datainicial", columnDefinition = "DATE")
	private java.sql.Date datainicial;
	
	//Get e Set
	
	public TipoUsuario getId_tipouser() {
		return id_tipouser;
	}

	public void setId_tipouser(TipoUsuario id_tipouser) {
		this.id_tipouser = id_tipouser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public java.sql.Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(java.sql.Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public java.sql.Date getDatainicial() {
		return datainicial;
	}

	public void setDatainicial(java.sql.Date datainicial) {
		this.datainicial = datainicial;
	}
	
	
}
