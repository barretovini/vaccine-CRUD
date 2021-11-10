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

import com.gft.vacina.entities.Posto;
import com.gft.vacina.services.PostoService;

@Controller
@RequestMapping("posto")
public class PostoController {
	
	@Autowired
	private PostoService postoService;
	
	@RequestMapping(path = "novo") // http://localhost:8080/posto/novo
	public ModelAndView novaPosto() {
		
		ModelAndView mv = new ModelAndView("posto/form.html");
		mv.addObject("posto", new Posto());
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST , path = "novo")
	public ModelAndView salvarPosto(@Valid Posto posto, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("posto/form.html");
		
		boolean novo = true;
		
		if(posto.getId()!=null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("posto", posto);
			return mv;
		}

		Posto postoSalvo = postoService.salvarPosto(posto);
		
		if(novo) {
			mv.addObject("posto", new Posto());
		}else {
			mv.addObject("posto",postoSalvo);
		}
		
		
		
		mv.addObject("mensagem", "Posto salvo com sucesso");
		
		
		return mv;
		
	}
	
	@RequestMapping // http://localhost:8080/posto
	public ModelAndView listarPosto() {
		
		ModelAndView mv = new ModelAndView("posto/listar.html");
		mv.addObject("lista", postoService.listarPosto());
		return mv;
		
	}
	
	@RequestMapping("/editar")
	public ModelAndView editarPosto(@RequestParam Long id) {
		
		ModelAndView mv = new ModelAndView("posto/form.html");
		Posto posto;
		
		try {
			posto = postoService.obterPosto(id);
		}catch(Exception e) {
			posto = new Posto();
			mv.addObject("mensagem", e.getMessage());
		}
		
		mv.addObject("posto", posto);
		
		return mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirPosto(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/posto");

		try {
			 postoService.excluirPosto(id);
			 redirectAttributes.addFlashAttribute("mensagem", "Posto excluído com sucesso.");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Posto!"+e.getMessage());
		}
				
		return mv;
	}

}
