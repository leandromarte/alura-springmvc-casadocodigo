package br.com.casadocodigo.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoDAO dao;	
	
	@RequestMapping("/produtos/form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("/produtos/form");
		mv.addObject("tipos", TipoPreco.values());
		
		return mv;
	}
	
	@RequestMapping("/produtos")
	public String gravar(Produto produto) {
		dao.gravar(produto);
		return "/produtos/ok";
	}
}
