package com.gft.vacina.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.vacina.entities.Pessoa;
import com.gft.vacina.services.PessoaService;

@Controller
@RequestMapping("pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(path = "novo") // http://localhost:8080/pessoa/novo
	public ModelAndView novaPessoa() {
		
		ModelAndView mv = new ModelAndView("pessoa/form.html");
		mv.addObject("pessoa", new Pessoa());
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST , path = "novo")
	public ModelAndView salvarPessoa(@Valid Pessoa pessoa, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("pessoa/form.html");
		
		boolean novo = true;
		
		if(pessoa.getId()!=null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("pessoa", pessoa);
			return mv;
		}

		Pessoa pessoaSalva = pessoaService.salvarPessoa(pessoa);
		
		if(novo) {
			mv.addObject("pessoa", new Pessoa());
		}else {
			mv.addObject("pessoa",pessoaSalva);
		}
		
		
		
		mv.addObject("mensagem", "Pessoa salva com sucesso");
		
		
		return mv;
		
	}
	
	@RequestMapping // http://localhost:8080/pessoa
	public ModelAndView listarPessoa() {
		
		ModelAndView mv = new ModelAndView("pessoa/listar.html");
		mv.addObject("lista", pessoaService.listarPessoa());
		return mv;
		
	}
	
	@RequestMapping("/editar")
	public ModelAndView editarPessoa(@RequestParam Long id) {
		
		ModelAndView mv = new ModelAndView("pessoa/form.html");
		Pessoa pessoa;
		
		try {
			pessoa = pessoaService.obterPessoa(id);
		}catch(Exception e) {
			pessoa = new Pessoa();
			mv.addObject("mensagem", e.getMessage());
		}
		
		mv.addObject("pessoa", pessoa);
		
		return mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirPessoa(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/pessoa");

		try {
			 pessoaService.excluirPessoa(id);
			 redirectAttributes.addFlashAttribute("mensagem", "Pessoa excluída com sucesso.");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Pessoa!"+e.getMessage());
		}
				
		return mv;
	}

}
