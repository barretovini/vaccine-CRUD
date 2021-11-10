package com.gft.vacina.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.vacina.entities.Vacina;
import com.gft.vacina.repositories.VacinaRepository;
import com.gft.vacina.services.VacinaService;

@Controller
@RequestMapping("vacina")
public class VacinaController {
	
	@Autowired
	private VacinaService vacinaService;
	
	//@Autowired
	//private LoteRepository loteRepository;
	
	@Autowired
	private VacinaRepository vacinaRepository;
	
	@RequestMapping(path = "novo") // http://localhost:8080/vacina/novo
	public ModelAndView novaVacina() {
		
		ModelAndView mv = new ModelAndView("vacina/form.html");
		mv.addObject("vacina", new Vacina());
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST , path = "novo")
	public ModelAndView salvarVacina(@Valid Vacina vacina, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("vacina/form.html");
		
		boolean novo = true;
		
		if(vacina.getId()!=null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("vacina", vacina);
			return mv;
		}

		Vacina vacinaSalva = vacinaService.salvarVacina(vacina);
		
		if(novo) {
			mv.addObject("vacina", new Vacina());
		}else {
			mv.addObject("vacina",vacinaSalva);
		}
		
		
		
		mv.addObject("mensagem", "Vacina salva com sucesso");
		
		
		return mv;
		
	}
	
	@RequestMapping // http://localhost:8080/vacina
	public ModelAndView listarVacina() {
		
		ModelAndView mv = new ModelAndView("vacina/listar.html");
		mv.addObject("lista", vacinaService.listarVacina());
		
		
		return mv;
		
	}
	
	@RequestMapping("/editar")
	public ModelAndView editarVacina(@RequestParam Long id) {
		
		ModelAndView mv = new ModelAndView("vacina/form.html");
		Vacina vacina;
		
		try {
			vacina = vacinaService.obterVacina(id);
		}catch(Exception e) {
			vacina = new Vacina();
			mv.addObject("mensagem", e.getMessage());
		}
		
		mv.addObject("vacina", vacina);
		
		return mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirVacina(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/vacina");

		try {
			 vacinaService.excluirVacina(id);
			 redirectAttributes.addFlashAttribute("mensagem", "Vacina excluída com sucesso.");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir vacina!"+e.getMessage());
		}
				
		return mv;
	}
	
	@RequestMapping(value="/listarPorLote" , method = RequestMethod.GET)
	@ResponseBody
	public List<Vacina> listarVacinasPorLote(Long idLotes){
		
		List<Vacina> listaVacina = vacinaRepository.findByLotes_Id(idLotes);
		return listaVacina;
	}
}
