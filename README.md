# Sistema Cadastro de Usuario

Este projeto é um sistema básico de cadastro de usuários desenvolvido com **Java**, **Spring Boot** e **MySQL**, seguindo boas práticas de arquitetura (hexagonal) e utilizando DTOs para entrada e saída de dados.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.x**
  - Spring Web
  - Spring Data JPA
  - Spring Validation
- **MySQL**
- **Maven**
- **Swagger (Springdoc OpenAPI)** para documentação da API
- **Arquitetura Hexagonal**
- **Postman** ou **Swagger UI** para testes

---

## 📂 Estrutura do Projeto

```
com.leonardo.sistema
├── application       → Serviços (regras de negócio)
├── domain            → Entidades e interfaces
├── infrastructure    → Persistência (Spring Data JPA)
├── web               → Controllers REST
├── dto               → DTOs (request e response)
└── config            → Configurações (Swagger, etc)
```

---

## ⚙️ Como Rodar o Projeto

1. **Pré-requisitos**
   - Java 21/25 instalado
   - MySQL rodando
   - Maven instalado

2. **Criar banco de dados**
   ```sql
   CREATE DATABASE sistema_fullstack CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   ```

3. **Configurar `application.properties`**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/sistema_fullstack
   spring.datasource.username=SEU_USUARIO
   spring.datasource.password=SUA_SENHA
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. **Rodar o projeto**
   ```bash
   mvn spring-boot:run
   ```
   ou pelo IDE (IntelliJ, VS Code).

---

## 🔍 Como Testar

Após rodar o projeto, acesse:

```
http://localhost:8080/swagger-ui.html
```

### Endpoints disponíveis:

- **POST /usuarios** → Criar usuário
  ```json
  {
    "nome": "Leonardo",
    "email": "leonardo@email.com",
    "senha": "123456"
  }
  ```

- **GET /usuarios** → Listar todos os usuários
- **GET /usuarios/{id}** → Buscar usuário por ID
- **GET /usuarios/nome/{nome}** → Buscar usuário por nome
- **DELETE /usuarios/{id}** → Deletar usuário por ID
- **DELETE /usuarios/email/{email}** → Deletar usuário por e-mail

---

## ✅ Próximos Passos

- Implementar criptografia de senha
---

## 📜 Licença
Este projeto é livre para uso e aprendizado.
