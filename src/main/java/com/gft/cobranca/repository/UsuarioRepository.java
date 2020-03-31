package com.gft.cobranca.repository;

import org.springframework.data.repository.CrudRepository;

import com.gft.cobranca.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	Usuario findByLogin(String login);
	
}
