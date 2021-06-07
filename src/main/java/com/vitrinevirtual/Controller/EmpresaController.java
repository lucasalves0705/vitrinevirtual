package com.vitrinevirtual.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vitrinevirtual.Entidades.Empresa;
import com.vitrinevirtual.dao.EmpresaDao;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
	@Autowired
	EmpresaDao dao;

	@GetMapping("/index")
	public String index() {
		return "/empresa/index";
	}
	
	@GetMapping("/cadastro")
	public String cadastro(ModelMap model) {
		model.addAttribute("empresa", new Empresa());
		return "/empresa/cadastro";
	}
	
	@PostMapping("/salvar")
	public void salvar(@ModelAttribute("empresa") Empresa obj, HttpServletResponse response) throws IOException {
		if(obj.getId() == null)
			dao.save(obj);
		else
			dao.update(obj);
		response.sendRedirect("/empresa/index");
	}
}