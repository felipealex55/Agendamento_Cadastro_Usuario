📌 Agendamento_Cadastro_Usuario
🧩 Microserviço de Cadastro (Projeto Acadêmico)

Repositório responsável pelo microserviço de cadastro de usuários, parte de um projeto acadêmico cujo objetivo é criar um app de agendamento de serviços.

🎯 1. Objetivo do Serviço

Este microserviço possui apenas uma responsabilidade:

✔️ Receber dados de um novo usuário via API REST
✔️ Persistir no banco de dados

❌ Ele NÃO faz autenticação
❌ Ele NÃO faz login
❌ Ele NÃO consulta usuários (por enquanto)

➡️ Essas funcionalidades pertencem a outros microserviços.

🛠️ 2. Tecnologias Utilizadas
Tecnologia	Versão
☕ Java	21
🚀 Spring Boot	3.5.6
🌐 Spring Web	API REST
🗄️ Spring Data JPA	Persistência
🐬 MySQL	Banco de dados
📦 Maven	Dependências
⚙️ 3. Como Executar Localmente
🔧 Pré-requisitos

☕ Java 21+ (JDK)

🐬 MySQL rodando localmente ou via Docker

📥 Passos para Configuração
<details> <summary><strong>📁 1. Clonar o Repositório</strong></summary>
git clone [URL_DO_SEU_REPOSITORIO_GIT]
cd [nome-do-repositorio]

</details>
<details> <summary><strong>🗄️ 2. Criar o Banco de Dados no MySQL</strong></summary>
CREATE DATABASE db_agendamento;

</details>
<details> <summary><strong>⚙️ 3. Configurar o <code>application.properties</code></strong></summary>
# --- Configuração do Banco de Dados MySQL ---
spring.datasource.url=jdbc:mysql://localhost:3306/db_agendamento
spring.datasource.username=root
spring.datasource.password=sua_senha_do_banco

# --- Configuração do Hibernate (JPA) ---
spring.jpa.hibernate.ddl-auto=update

# --- Porta da Aplicação ---
server.port=8081

</details>
<details> <summary><strong>▶️ 4. Executar o Projeto</strong></summary>
No Windows:
./mvnw.cmd spring-boot:run

No Linux/Mac:
./mvnw spring-boot:run


Se tudo estiver correto, a aplicação iniciará na porta 8081.

</details>
🧪 4. Como Usar (Testar via Postman)

Este serviço expõe apenas um endpoint para criar usuários.

📨 Passo a Passo
<details> <summary><strong>📍 1. Abrir o Postman</strong></summary> Abra o Postman e crie uma nova requisição. </details> <details> <summary><strong>🌐 2. Configurar a Requisição</strong></summary>

Método: POST

URL:

http://localhost:8081/api/v1/usuarios

</details>
<details> <summary><strong>📝 3. Definir o Body da Requisição</strong></summary>

Vá na aba Body

Selecione raw

Escolha JSON

{
    "nome": "Teste Postman",
    "cpf": "12345678900",
    "email": "teste@postman.com",
    "senha": "senha123",
    "telefone": "31999998888"
}

</details>
<details> <summary><strong>📤 4. Enviar e Ver a Resposta</strong></summary>

Clique em Send.

Se tudo estiver OK, você deve receber:

Status: 201 Created

Um JSON com o usuário criado (idealmente sem a senha)

{
    "nome": "Teste Postman",
    "cpf": "12345678900",
    "email": "teste@postman.com",
    "senha": "senha123",
    "telefone": "31999998888"
}
