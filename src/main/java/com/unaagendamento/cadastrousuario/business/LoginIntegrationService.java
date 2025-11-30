package com.unaagendamento.cadastrousuario.business;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginIntegrationService {

    // IMPORTANTE: Se o cadastro e login rodarem juntos, garanta que as portas sejam diferentes (ex: 8080 e 8081)
    private final String LOGIN_API_URL = "http://localhost:8080/internal/sync/users";

    public void enviarUsuarioParaLogin(String email, String senha) {
        System.out.println("Integracao: Enviando usuário " + email + " para o serviço de Login...");

        try {
            // 1. Prepara a "caixa" (JSON) para envio
            Map<String, String> jsonBody = new HashMap<>();
            jsonBody.put("email", email);
            jsonBody.put("senha", senha);

            // 2. Prepara o carteiro (RestTemplate)
            RestTemplate restTemplate = new RestTemplate();

            // 3. Faz o envio (POST)
            restTemplate.postForEntity(LOGIN_API_URL, jsonBody, String.class);
            
            System.out.println("Integracao: Sucesso! Usuário sincronizado.");

        } catch (Exception e) {
            // Se o serviço de login estiver desligado, cai aqui.
            // Em produção, você salvaria isso numa fila para tentar depois.
            System.err.println("Integracao: FALHA ao conectar com serviço de Login: " + e.getMessage());
        }
    }
}