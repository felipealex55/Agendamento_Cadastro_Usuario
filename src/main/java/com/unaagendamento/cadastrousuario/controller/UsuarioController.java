package com.unaagendamento.cadastrousuario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unaagendamento.cadastrousuario.business.UsuarioService;
import com.unaagendamento.cadastrousuario.dto.UsuarioCadastroDTO;
import com.unaagendamento.cadastrousuario.infrastructure.entity.Usuario;

import lombok.RequiredArgsConstructor;

@RestController // Indica que é um controller REST
@RequestMapping("/usuario") // Define o endpoint base como /usuario
@RequiredArgsConstructor // Gera construtor com argumentos obrigatórios (final)

public class UsuarioController { // Controller para operações relacionadas ao usuário

    private final UsuarioService usuarioService; // Injeta o serviço de usuário

    @PostMapping // Mapeia requisições POST para este método
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody UsuarioCadastroDTO dto) {

        // 4. CONVERTA o DTO para a sua Entidade Usuario
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dto.getNome());
        novoUsuario.setEmail(dto.getEmail());
        novoUsuario.setCpf(dto.getCpf());
        novoUsuario.setSenha(dto.getSenha());
        novoUsuario.setTelefone(dto.getTelefone());

        Usuario usuarioSalvo = usuarioService.salvarUsuario(novoUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }
}
