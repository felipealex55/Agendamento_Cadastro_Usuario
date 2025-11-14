package com.unaagendamento.cadastrousuario.infrastructure.exceptions;

// Classe de exceção personalizada para conflitos (ex: dados já existentes)
public class ConflictException extends RuntimeException {

    // Construtor que recebe apenas a mensagem do erro
    public ConflictException(String mensagem) {
        super(mensagem);
    }

    // Construtor que recebe mensagem e causa do erro
    public ConflictException(String mensagem, Throwable throwable) {
        super(mensagem);
    }
}
