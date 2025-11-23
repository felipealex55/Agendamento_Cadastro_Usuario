# 📌 Agendamento_Cadastro_Usuario

### 🧩 *Microserviço de Cadastro (Projeto Acadêmico)*  
Repositório responsável pelo microserviço de **cadastro de usuários**, parte de um projeto acadêmico cujo objetivo é criar um app de agendamento de serviços.

📎 Repositório do front-end: https://github.com/P3dr0EM/Una_Agendamento

---

## 🎯 1. Objetivo do Serviço

Este microserviço possui **apenas uma responsabilidade**:

✔️ Receber dados de um novo usuário via **API REST**  
✔️ Persisti-los no **banco de dados**

❌ **Ele NÃO faz autenticação**  
❌ **Ele NÃO faz login**  
❌ **Ele NÃO consulta usuários** (em um primeiro momento)

➡️ Essas funcionalidades serão responsabilidade de outros microserviços.

---

## 🛠️ 2. Tecnologias Utilizadas

| Tecnologia | Versão |
|-----------|---------|
| ☕ **Java** | 21 |
| 🚀 **Spring Boot** | 3.5.6 |
| 🌐 **Spring Web** | API REST |
| 🗄️ **Spring Data JPA** | Persistência |
| 🐬 **MySQL** | Banco de dados |
| 📦 **Maven** | Gerenciador de dependências |

---

## ⚙️ 3. Como Executar Localmente

### 🔧 Pré-requisitos
- ☕ **Java 21+ (JDK)**
- 🐬 **MySQL** rodando localmente ou via Docker

---

## 📥 Passos para Configuração

### <details>
<summary><strong>📁 1. Clonar o Repositório</strong></summary>

\`\`\`bash
git clone [URL_DO_SEU_REPOSITORIO_GIT]
cd [nome-do-repositorio]
\`\`\`

</details>

---

### <details>
<summary><strong>🗄️ 2. Criar o Banco de Dados no MySQL</strong></summary>

\`\`\`sql
CREATE DATABASE db_agendamento;
\`\`\`

</details>

---

### <details>
<summary><strong>⚙️ 3. Configurar o arquivo <code>application.properties</code></strong></summary>

\`\`\`properties
# --- Configuração do Banco de Dados MySQL ---
spring.datasource.url=jdbc:mysql://localhost:3306/db_agendamento
spring.datasource.username=root
spring.datasource.password=sua_senha_do_banco

# --- Configuração do Hibernate (JPA) ---
spring.jpa.hibernate.ddl-auto=update

# --- Porta da Aplicação ---
server.port=8081
\`\`\`

</details>

---

### <details>
<summary><strong>▶️ 4. Executar o Projeto</strong></summary>

#### No Windows:
\`\`\`bash
./mvnw.cmd spring-boot:run
\`\`\`

#### No Linux/Mac:
\`\`\`bash
./mvnw spring-boot:run
\`\`\`

A aplicação iniciará em **http://localhost:8081**

</details>

---

### <details>
<summary><strong>🧪 Testar via Postman</strong></summary>

#### 1. URL da requisição
\`\`\`
POST http://localhost:8081/api/v1/usuarios
\`\`\`

#### 2. Body (JSON)
\`\`\`json
{
  "nome": "Teste Postman",
  "cpf": "12345678900",
  "email": "teste@postman.com",
  "senha": "senha123",
  "telefone": "31999998888"
}
\`\`\`

</details>

---
