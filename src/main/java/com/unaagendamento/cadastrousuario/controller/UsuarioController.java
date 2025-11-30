package com.unaagendamento.cadastrousuario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unaagendamento.cadastrousuario.business.LoginIntegrationService;
import com.unaagendamento.cadastrousuario.business.UsuarioService;
import com.unaagendamento.cadastrousuario.dto.UsuarioCadastroDTO;
import com.unaagendamento.cadastrousuario.infrastructure.entity.Usuario;


@RestController // Indica que é um controller REST
@RequestMapping("/usuario") // Define o endpoint base como /usuario

public class UsuarioController { // Controller para operações relacionadas ao usuário

    private final UsuarioService usuarioService; // Injeta o serviço de usuário
    private final LoginIntegrationService loginIntegration;

    public UsuarioController(UsuarioService usuarioService, LoginIntegrationService loginIntegration) {
        this.usuarioService = usuarioService;
        this.loginIntegration = loginIntegration;
    }

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody UsuarioCadastroDTO dto) {

        // 1. Converter DTO para Entidade
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dto.getNome());
        novoUsuario.setEmail(dto.getEmail());
        novoUsuario.setCpf(dto.getCpf());
        novoUsuario.setSenha(dto.getSenha());
        novoUsuario.setTelefone(dto.getTelefone());

        // 2. Salvar no Banco Local (Cadastro)
        Usuario usuarioSalvo = usuarioService.salvarUsuario(novoUsuario);

        // 3. ENVIAR PARA O SERVIÇO DE LOGIN (Sincronização)
        if (dto.getEmail() != null && dto.getSenha() != null) {
            loginIntegration.enviarUsuarioParaLogin(dto.getEmail(), dto.getSenha());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }
}
