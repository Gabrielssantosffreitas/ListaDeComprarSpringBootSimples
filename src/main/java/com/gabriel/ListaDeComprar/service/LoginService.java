package com.gabriel.ListaDeComprar.service;

import com.gabriel.ListaDeComprar.DTO.LoginDTO;
import com.gabriel.ListaDeComprar.model.UsuarioModel;
import com.gabriel.ListaDeComprar.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {
        final UsuarioRepository REPOSITORY;

    public LoginService(UsuarioRepository repository) {
        this.REPOSITORY = repository;
    }

    public ResponseEntity<Map<String,String>> logar(LoginDTO loginDTO){
        Optional<UsuarioModel> optionalUsuario =  REPOSITORY.findByEmail(loginDTO.email());

        Map<String,String> map = new HashMap<>();
        map.put("logado","nao foi possivel logar");

        if (optionalUsuario.isEmpty()) return ResponseEntity.badRequest().body(map);

       Map<String,String> ok = new HashMap<>();
       ok.put("logado",String.valueOf(optionalUsuario.get().getId()));

        if (optionalUsuario.get().getSenha().equals(loginDTO.senha())) return ResponseEntity.ok().body(ok);
        else return ResponseEntity.badRequest().body(map);

    }
}
