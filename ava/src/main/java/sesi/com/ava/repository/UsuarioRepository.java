package sesi.com.ava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sesi.com.ava.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	

}
