# 📚 Exemplo de Aplicação Spring Boot Integrado com MongoDB + Swagger 🍃

Um projeto modelo para integrar Spring Boot com MongoDB, incluindo documentação de API via Swagger/OpenAPI.

---

## 🚀 Pré-requisitos

- Java 17+
- Maven instalado
- MongoDB local ou acesso a uma instância remota
- Conexão com internet para dependências Maven

---

## ⚙️ Configuração Inicial

1. **Banco de Dados MongoDB**
   - Recomendado usar Docker para instância local:
   ```bash
   docker run -d -p 27017:27017 --name meu-mongo mongo:latest
   ```
   - Ou instale manualmente seguindo a [documentação oficial](https://www.mongodb.com/docs/manual/installation/)

2. **Configurar Conexão**  
   Edite o arquivo `src/main/resources/application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/meu-banco-dados
   ```
   - Altere `meu-banco-dados` para o nome do seu banco
   - Ajuste host/porta conforme sua instalação

---

## 🛠 Como Executar o Projeto

**Passo 1:** Build do projeto
```bash
# Usando wrapper Maven
./mvnw clean install

# Ou com Maven instalado globalmente
mvn clean install
```

**Passo 2:** Iniciar a aplicação
```bash
mvn spring-boot:run
```

**Acesso:**
- Aplicação disponível em: http://localhost:8080
- Health Check: http://localhost:8080/actuator/health

---

## 📖 Documentação da API (Swagger UI)

Acesse a interface interativa para testar os endpoints:
http://localhost:8080/docs

**Recursos disponíveis:**
- Teste de endpoints diretamente no navegador
- Esquemas de requisição/resposta
- Modelos de dados detalhados

---

## 🚨 Solução de Problemas Comuns

**Conexão com MongoDB falha:**
- Verifique se o MongoDB está rodando (`docker ps` para instâncias Docker)
- Confira porta e credenciais no `application.properties`
- Teste conexão manualmente com cliente MongoDB

**Swagger não aparece:**
- Confira dependências no `pom.xml` (springdoc-openapi-starter-webmvc-ui)
- Acesse via `/docs` (não `/swagger-ui.html`)

---

*Desenvolvido com ❤️ por [Marcus Lima] - Atualizado em 2025*
