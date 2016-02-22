package br.com.casadocodigo.loja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoDAO dao;	
	
	@org.springframework.web.bind.annotation.InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidation());
		
	}
	
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("/produtos/form");
		mv.addObject("tipos", TipoPreco.values());
		
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(@Valid Produto produto, BindingResult result) {
		ModelAndView mv = new ModelAndView("/produtos/ok");
		if (result.hasErrors()) {
			return form();
		} 
		
		dao.gravar(produto);
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/produtos/lista");
		mv.addObject("produtos", dao.lista());
		return mv;
	}
	
}
