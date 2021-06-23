package com.vitrinevirtual.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vitrinevirtual.Entidades.Empresa;
import com.vitrinevirtual.Entidades.Ramo;
import com.vitrinevirtual.dao.RamoDao;

@Controller
@RequestMapping("/ramo")
public class RamoController {
	@Autowired
	RamoDao ramodao;
	
	@GetMapping("/index")
	public String home(ModelMap model) {
		model.addAttribute("ramos", ramodao.findAll());
		return "/ramo/index";
	}
	
	@GetMapping("/cadastro")
	public String cadastro(ModelMap model) {
		model.addAttribute(new Ramo());
		return "/ramo/cadastro";
	}
	
	@GetMapping("/{id}/alterar")
	public String alterar(@PathVariable("id") int id, ModelMap model, HttpServletResponse response) throws IOException {
		model.addAttribute("ramo", ramodao.findById(id));
		return "/ramo/alterar";
	}
	
	@PostMapping("/salvar")
	public void salvar(@ModelAttribute("ramo") Ramo obj, HttpServletResponse response) throws IOException {
		if(obj.getId() == null)
			ramodao.save(obj);
		else
			ramodao.update(obj);
		response.sendRedirect("/ramo/index");
	}
}
