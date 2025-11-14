package com.unaagendamento.cadastrousuario; // Pacote principal da aplicação

import org.springframework.boot.SpringApplication; // Importa SpringApplication para rodar a aplicação
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa a anotação de configuração Spring Boot

@SpringBootApplication // Indica que é uma aplicação Spring Boot
public class ProjetounaApplication { // Classe principal da aplicação

	public static void main(String[] args) { // Método principal
		SpringApplication.run(ProjetounaApplication.class, args); // Inicializa a aplicação Spring Boot
	}
}