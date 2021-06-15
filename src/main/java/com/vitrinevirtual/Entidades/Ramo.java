package com.vitrinevirtual.Entidades;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ramos")
public class Ramo extends AbstractEntity<Integer>{
	@ManyToMany(mappedBy = "ramos")
    private List<Empresa> empresas;

	@Column(name="codigo")
	private int codigo;

	@Column(name="descricao")
	private String descricao;
	
	

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		
}
