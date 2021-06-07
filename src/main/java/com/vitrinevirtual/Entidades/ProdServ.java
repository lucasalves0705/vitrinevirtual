package com.vitrinevirtual.Entidades;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="prodserv")
public class ProdServ extends AbstractEntity<Integer>{
	@ManyToMany
    @JoinTable(
        name = "empresa_prodserv",
        joinColumns = @JoinColumn(name = "id_empresa"),
        inverseJoinColumns = @JoinColumn(name = "id_ramo")
    )
    private List<Ramo> ramos;
	
	@ManyToMany
    @JoinTable(
        name = "empresa_usuario",
        joinColumns = @JoinColumn(name = "id_empresa"),
        inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Usuario> usuarios;
	

	@Column
	private String descricao;

	
	//Get e Set
	public List<Ramo> getRamos() {
		return ramos;
	}


	public void setRamos(List<Ramo> ramos) {
		this.ramos = ramos;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
