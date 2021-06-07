package com.vitrinevirtual.Entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="avaliacoes")
public class Avaliacao extends AbstractEntity<Integer>{

	@ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
	
	@Column
	private int nota;

	
	//Get e Set
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
}
