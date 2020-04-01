package com.gft.cobranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.cobranca.model.Usuario;
import com.gft.cobranca.service.CadastroUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private static final String CADASTRO_VIEW = "CadastroUsuario";
		
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
		
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Usuario());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Usuario usuario, Errors errors, RedirectAttributes attributes) {
		
		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		try {
			cadastroUsuarioService.salvar(usuario);		
			attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso");
			return "redirect:/usuarios/novo";			
		} catch (DataIntegrityViolationException e) {
			return CADASTRO_VIEW;
		}

	}
}
