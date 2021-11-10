package com.gft.vacina.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.vacina.entities.Vacinacao;
import com.gft.vacina.services.LoteService;
import com.gft.vacina.services.PessoaService;
import com.gft.vacina.services.PostoService;
import com.gft.vacina.services.VacinacaoService;

@Controller
@RequestMapping("vacinacao")
public class VacinacaoController {

	@Autowired
	private VacinacaoService vacinacaoService;
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private PostoService postoService;
	@Autowired
	private LoteService loteService;

	@RequestMapping(path = "editar") // http://localhost:8080/vacina/editar
	public ModelAndView editarVacinacao(@RequestParam(required = false) Long id) {

		ModelAndView mv = new ModelAndView("vacinacao/form.html");

		Vacinacao vacinacao;

		if (id == null) {
			vacinacao = new Vacinacao();
		} else {
			try {
				vacinacao = vacinacaoService.obterVacinacao(id);
			} catch (Exception e) {
				vacinacao = new Vacinacao();
				mv.addObject("mensagem", e.getMessage());
			}
		}

		mv.addObject("vacinacao", vacinacao);
		mv.addObject("listaPessoa", pessoaService.listarPessoa());
		mv.addObject("listaPosto", postoService.listarPosto());
		mv.addObject("listaLote", loteService.listarLote(new Date(), 0));

		return mv;

	}

	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView salvarVacinacao(@Valid Vacinacao vacinacao, BindingResult bindingResult) {

		ModelAndView mv = new ModelAndView("vacinacao/form.html");

		boolean novo = true;

		if (vacinacao.getId() != null) {
			novo = false;
		}

		if (bindingResult.hasErrors()) {
			mv.addObject("vacinacao", vacinacao);
			return mv;
		}


		vacinacaoService.salvarVacinacao(vacinacao);
	
		if(novo) {
			mv.addObject("vacinacao", new Vacinacao());
		}else {
			mv.addObject("vacinacao", vacinacao);
		}
		
		mv.addObject("mensagem", "Vacinacao salva com sucesso");
		mv.addObject("listaPessoa", pessoaService.listarPessoa());
		mv.addObject("listaPosto", postoService.listarPosto());
		mv.addObject("listaLote", loteService.listarLote(new Date(), 0));

		return mv;

	}

	@RequestMapping
	public ModelAndView listarVacinacao(int vacinado) {

		ModelAndView mv = new ModelAndView("vacinacao/listar.html");

		mv.addObject("lista", vacinacaoService.listarVacinacao(vacinado));

		return mv;

	}

	@RequestMapping("/excluir")
	public ModelAndView excluirVacinacao(@RequestParam Long id, RedirectAttributes redirectAttributes) {

		ModelAndView mv = new ModelAndView("redirect:/vacinacao?vacinado=0");

		try {
			vacinacaoService.excluirVacinacao(id);
			redirectAttributes.addFlashAttribute("mensagem", "Vacinação excluída com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir vacinação!" + e.getMessage());
		}

		return mv;
	}

}
