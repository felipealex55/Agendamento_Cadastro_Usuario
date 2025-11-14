package com.unaagendamento.cadastrousuario.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "usuario") // Mapeia para a tabela "telefone"

public class Usuario { // Classe que representa o usuário

    @Id // Indica chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private Long id; // Identificador do usuário

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cpf", length = 15)
    private String cpf;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "senha", length = 30)
    private String senha;

    @Column(name = "telefone", length = 12)
    private String telefone;

}
