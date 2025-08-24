package com.gabriel.ListaDeComprar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario_lista")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    @Column(name = "nome" , length = 100,nullable = false)
    private String nome;

    @Column(name = "email", length = 150, nullable = false,unique = true)
    private String email;

    @Column(name="senha",length = 100,nullable = false)
    private String senha;

    @Column(name="data_de_criacao",nullable = false)
    private LocalDateTime dataDeCriacao;

}
