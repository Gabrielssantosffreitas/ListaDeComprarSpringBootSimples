package com.gabriel.ListaDeComprar.repository;

import com.gabriel.ListaDeComprar.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {
    Optional<UsuarioModel> findByEmail(String email);
}
