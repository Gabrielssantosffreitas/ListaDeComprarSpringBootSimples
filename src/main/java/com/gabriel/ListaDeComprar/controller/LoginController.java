package com.gabriel.ListaDeComprar.controller;

import com.gabriel.ListaDeComprar.DTO.LoginDTO;
import com.gabriel.ListaDeComprar.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginController {
    final LoginService SERVICE;

    public LoginController(LoginService controller) {
        this.SERVICE = controller;
    }

    @PostMapping("")
    public ResponseEntity<Map<String,String>> logar(@RequestBody LoginDTO loginDTO){
        return SERVICE.logar(loginDTO);
    }

}
