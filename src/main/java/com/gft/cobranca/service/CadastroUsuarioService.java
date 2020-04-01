package com.gft.cobranca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gft.cobranca.model.Usuario;
import com.gft.cobranca.repository.Usuarios;

@Service
public class CadastroUsuarioService {
	
	@Autowired
	private Usuarios usuarios;
	
	public void salvar(Usuario usuario) {
		try {
			usuarios.save(usuario);			
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Algo de errado não está certo");
		}
	}
	
}
