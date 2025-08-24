package com.gabriel.ListaDeComprar.controller;

import com.gabriel.ListaDeComprar.DTO.CadastroDTO;
import com.gabriel.ListaDeComprar.service.CadastroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cadastro")
public class CadastroController {
    private final CadastroService SERVICE;

    public CadastroController(CadastroService service) {
        this.SERVICE = service;
    }

    @PostMapping("")
    public ResponseEntity<String> cadastrar (@RequestBody CadastroDTO cadastroDTO){
        return SERVICE.cadastrar(cadastroDTO);
    }

}
