package com.vitrinevirtual.Entidades;

import java.time.Instant;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="empresas")
public class Empresa extends AbstractEntity<Integer>{
	@ManyToMany
    @JoinTable(
        name = "empresa_ramo",
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
	private String nome;
	
	@Column(columnDefinition="TEXT")
	private String descricao;
	
	@Column
	private String img_src;
	
	@Column
	private String facebook;
	
	@Column
	private String instagram;
	
	@Column
	private String email;
	
	@Column(length=20)
	private String contato;
	
	@Column(length=20)
	private String whatsapp;
	
	@Column
	private Instant horario_inicio = null;
	
	@Column
	private Instant horario_fim = null;
	
	
	//Get e Set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImg_src() {
		return img_src;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}

	public Instant getHorario_fim() {
		return horario_fim;
	}

	public void setHorario_fim(Instant horario_fim) {
		this.horario_fim = horario_fim;
	}

	public void setRamos(List<Ramo> ramos) {
		this.ramos = ramos;
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

	public String getImg_source() {
		return img_src;
	}

	public void setImg_source(String img_source) {
		this.img_src = img_source;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public Instant getHorario_inicio() {
		return horario_inicio;
	}

	public void setHorario_inicio(Instant horario_inicio) {
		this.horario_inicio = horario_inicio;
	}

	public Instant getHorario_termino() {
		return horario_fim;
	}

	public void setHorario_termino(Instant horario_termino) {
		this.horario_fim = horario_termino;
	}
	
	public List<Ramo> getRamos() {
        return this.ramos;
    }
	
	public List<Usuario> getUsuarios() {
        return this.usuarios;
    }
}
