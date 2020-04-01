package com.gft.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.cobranca.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, String> {
	
	Usuario findByLogin(String login);
}
