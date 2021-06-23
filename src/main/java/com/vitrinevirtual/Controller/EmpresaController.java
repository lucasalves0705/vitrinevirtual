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
import org.springframework.web.bind.annotation.RequestParam;

import com.vitrinevirtual.Entidades.Empresa;
import com.vitrinevirtual.dao.EmpresaDao;
import com.vitrinevirtual.dao.RamoDao;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
	@Autowired
	EmpresaDao empresadao;
	
	@Autowired
	RamoDao empresaramodao;

	@GetMapping("/index")
	public String home(ModelMap model) {
		model.addAttribute("empresas", empresadao.findAll());
		return "/empresa/index";
	}
	
	@GetMapping("/exibir")
	public String exibir(ModelMap model, int id) {
		model.addAttribute("empresas", empresadao.findById(id));
		return "/empresa/exibir";
	}
	
	@GetMapping("/cadastro")
	public String cadastro(ModelMap model) {
		model.addAttribute("empresa", new Empresa());
		return "/empresa/cadastro";
	}
	
	@PostMapping("/salvar")
	public void salvar(@ModelAttribute("empresa") Empresa obj, HttpServletResponse response) throws IOException {
		if(obj.getId() == null)
			empresadao.save(obj);
		else
			empresadao.update(obj);
		response.sendRedirect("/empresa/index");
	}
	
	/*@GetMapping("/{id}/excluir")
	public void excluir(@PathVariable("id") int id, ModelMap model, HttpServletResponse response) throws IOException {	
		empresaramodao.deletarPorEmpresa(id);
		empresadao.delete(id);
		response.sendRedirect("/empresa/index");
	}*/
}
