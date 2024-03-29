package com.vitrinevirtual.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vitrinevirtual.Entidades.Empresa;
import com.vitrinevirtual.Entidades.Usuario;
import com.vitrinevirtual.dao.EmpresaDao;
import com.vitrinevirtual.dao.UsuarioDao;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	UsuarioDao dao;
	
	@Autowired
	EmpresaDao empresadao;
	
	@GetMapping("/")
	public String home(ModelMap model) {
		model.addAttribute("empresas", empresadao.findAll());
		return "/home/site";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping("/login-error")
	public String loginError(ModelMap model) {
		model.addAttribute("mensagem", "Dados invalidos!");
		return "/login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "/login";
	}
	
	@GetMapping("/register")
	public String register(ModelMap model) {
		model.addAttribute("usuario", new Usuario());
		return "/home/register";
	}
	
}
