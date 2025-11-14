package com.unaagendamento.cadastrousuario.business;

import org.springframework.stereotype.Service;

import com.unaagendamento.cadastrousuario.infrastructure.entity.Usuario;
import com.unaagendamento.cadastrousuario.infrastructure.exceptions.ConflictException;
import com.unaagendamento.cadastrousuario.infrastructure.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final UsuarioRepository usuarioRepository; // Usa Lombok para injetar o repositório (ou use o construtor)

        
    public Usuario salvarUsuario(Usuario usuario) {
        
        // 1. Verifica se o e-mail já existe usando o método corrigido
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            
            // 2. Se existir, lança a exceção de conflito
            throw new ConflictException("Email ja cadastrado");
        }
        
        // 3. Se não existir, salva o novo usuário no banco
        // (O Cascade.ALL nas entidades cuidará de salvar o endereço e telefones)
        return usuarioRepository.save(usuario);
    }
}
