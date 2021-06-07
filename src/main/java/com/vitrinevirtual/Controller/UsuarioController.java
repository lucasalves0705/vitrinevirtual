package com.vitrinevirtual.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.sql.Time;
import java.text.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vitrinevirtual.Entidades.Usuario;
import com.vitrinevirtual.dao.IUsuarioDao;
import com.vitrinevirtual.dao.UsuarioDao;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioDao dao;
	
	@GetMapping("/")
	public String home() {
		return "/index";
	}
	
	@PostMapping("/salvar")
	public String salvar(Usuario obj) {
		
		java.sql.Date x = new java.sql.Date(System.currentTimeMillis());
		obj.setDatainicial(x);
		
		obj.setSenha(new BCryptPasswordEncoder().encode(obj.getSenha()));
		
		if(obj.getId() == null)
			dao.save(obj);
		else
			dao.update(obj);
		
		return "/login";
	}
	
	@PostMapping("/{id}")
	public Usuario buscarUsuario(@RequestParam int id , Usuario usuario) {
		
		
		return usuario;
	}
}
