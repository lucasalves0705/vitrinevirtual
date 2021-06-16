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
import org.springframework.web.bind.annotation.RequestMethod;

import com.vitrinevirtual.Entidades.ProdServ;
import com.vitrinevirtual.dao.ProdServDao;

@Controller
@RequestMapping("/produto")
public class ProdServController {

	@Autowired
	ProdServDao produtodao;

	@GetMapping("/index")
	public String home(ModelMap model) {
		model.addAttribute("produtos", produtodao.findAll());
		return "/produto/index";
	}
	
	@GetMapping("/form")
	public String cadastro(ModelMap model) {
		model.addAttribute("produto", new ProdServ());
		return "/produto/form";
	}
	
	/*@RequestMapping(value = "{descricao}", method = GET)
	  public String sayHello(
	      @PathVariable("descricao") String name,
	      ProdServ model) {
			
	    
	    return "hello";
		  
	  }*/
	
	@PostMapping("/salvar")
	public void salvar(@ModelAttribute("produto") ProdServ obj, HttpServletResponse response) throws IOException {
		if(obj.getId() == null)
			produtodao.save(obj);
		else
			produtodao.update(obj);
		response.sendRedirect("/produto/index");
	}
}
