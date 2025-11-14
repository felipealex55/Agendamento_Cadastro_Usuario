package com.unaagendamento.cadastrousuario.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unaagendamento.cadastrousuario.infrastructure.entity.Usuario;

@Repository // Indica que é um repositório Spring
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { // Interface para operações com Usuario

    boolean existsByEmail(String email); // Verifica se existe usuário com o e-mail informado (possível erro de // digitação no nome do método)

}
