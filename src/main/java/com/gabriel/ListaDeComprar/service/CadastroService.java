package com.gabriel.ListaDeComprar.service;

import com.gabriel.ListaDeComprar.DTO.CadastroDTO;
import com.gabriel.ListaDeComprar.model.UsuarioModel;
import com.gabriel.ListaDeComprar.repository.UsuarioRepository;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class CadastroService {
    private final UsuarioRepository REPOSITORY;
    private UsuarioModel usuarioModel;

    public CadastroService(UsuarioRepository repository) {
        this.REPOSITORY = repository;
    }

    // todo quando adicionar o spring secerite lebrar de usar critografia

    public ResponseEntity<String> cadastrar(CadastroDTO cadastroDTO){
        UsuarioModel usuarioModel =  new UsuarioModel();
                usuarioModel.setNome(cadastroDTO.nome());
                usuarioModel.setEmail(cadastroDTO.email());
                usuarioModel.setSenha(cadastroDTO.senha());
                usuarioModel.setDataDeCriacao(LocalDateTime.now());

        try {
            REPOSITORY.save(usuarioModel);
            return ResponseEntity.ok().body(String.valueOf(usuarioModel.getId()));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("ja existe uma conta com esse email");
        }


    }

}
