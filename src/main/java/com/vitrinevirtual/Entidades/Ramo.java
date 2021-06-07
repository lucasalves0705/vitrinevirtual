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

	@Column(name="secao")
	private char secao;

	@Column(name="denominacao")
	private String denominacao;
	
	@Column(name="divisao")
	private int divisao;

	
	//Get e Set
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public char getSecao() {
		return secao;
	}

	public void setSecao(char secao) {
		this.secao = secao;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public int getDivisao() {
		return divisao;
	}

	public void setDivisao(int divisao) {
		this.divisao = divisao;
	}

	
}
