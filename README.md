# Agendamento_Cadastro_Usuario

Microserviço de Cadastro (Projeto Acadêmico)

Este repositório contém o microserviço de cadastro, parte de um projeto acadêmico com intuito de desenvolvimento de um app de agendamento de serviços.

1. Objetivo do Serviço
A única responsabilidade deste microserviço é receber os dados de um novo usuário (via API REST) e persisti-los no banco de dados.

Ele NÃO faz autenticação.

Ele NÃO faz login.

Ele NÃO consulta usuários (em um primeiro momento).

Essas outras funcionalidades serão de responsabilidade de outros microserviços.

2. Tecnologias Utilizadas
Java 21

Spring Boot 3.5.6

Spring Web (para a API REST)

Spring Data JPA (para persistência de dados)

MySQL (Driver de banco de dados)

Maven (Gerenciador de dependências)

3. Como Executar Localmente
Pré-requisitos
Java 21+ (JDK)

MySQL (um servidor de banco de dados rodando localmente ou em um contêiner Docker).

Passos para Configurar
Clone o repositório:

Bash

git clone [URL_DO_SEU_REPOSITORIO_GIT]
cd [nome-do-repositorio]
Crie o Banco de Dados: Acesse seu servidor MySQL e crie um banco de dados (schema).

SQL

CREATE DATABASE db_agendamento;
Configure a Conexão: Abra o arquivo /src/main/resources/application.properties e adicione as credenciais do seu banco de dados:

Properties

# --- Configuração do Banco de Dados MySQL ---
spring.datasource.url=jdbc:mysql://localhost:3306/db_agendamento
spring.datasource.username=root
spring.datasource.password=sua_senha_do_banco

# --- Configuração do Hibernate (JPA) ---
# "update": O Hibernate tentará criar/atualizar as tabelas automaticamente
spring.jpa.hibernate.ddl-auto=update

# --- Porta da Aplicação ---
# O serviço irá rodar na porta 8081 (para não conflitar com outros)
server.port=8081
Execute o Projeto: Abra um terminal na raiz do projeto e use o Maven Wrapper:

No Windows:

Bash

./mvnw.cmd spring-boot:run
No Linux ou Mac:

Bash

./mvnw spring-boot:run
Se tudo der certo, você verá no console que a aplicação subiu na porta 8081.

4. Como Usar (Teste via Postman)
Este serviço expõe apenas um endpoint para criar usuários.

Passo 1: Abrir o Postman
Abra o Postman e crie uma nova requisição.

Passo 2: Configurar a Requisição
Selecione o método POST.

Na URL, coloque: http://localhost:8081/api/v1/usuarios (Assumindo que seu Controller está mapeado para /api/v1/usuarios)

Passo 3: Montar o "Corpo" (Body)
Clique na aba Body.

Selecione a opção raw.

No menu dropdown que aparecerá ao lado, selecione JSON.

Passo 4: Escrever o JSON de Cadastro
No campo de texto, insira os dados do usuário que você quer cadastrar. (Os campos "nome", "email", "senha" devem existir na sua classe Usuario.java).

JSON

{
    "nome": "Teste Postman",
    "cpf": "12345678900",
    "email": "teste@postman.com",
    "senha": "senha123",
    "telefone": "31999998888"
}

Passo 5: Enviar e Ver a Resposta
Clique no botão azul Send.

Se o cadastro for bem-sucedido, você deverá receber uma resposta Status: 201 Created e, idealmente, o JSON do usuário que foi criado (sem a senha).

Resposta Esperada (Exemplo):

JSON

{
    "nome": "Teste Postman",
    "cpf": "12345678900",
    "email": "teste@postman.com",
    "senha": "senha123",
    "telefone": "31999998888"
}
