# 📦 Produto API

API REST para gerenciamento de produtos, construída com **Spring Boot** e **PostgreSQL**, como projeto de estudo prático de back-end Java.

## 🎯 Sobre o projeto

Este projeto implementa um CRUD completo (Create, Read, Update, Delete) de produtos, aplicando os principais conceitos de uma API REST profissional: camadas bem definidas (Controller, Repository, Model), persistência de dados com JPA/Hibernate, e tratamento global de erros para respostas padronizadas em JSON.

Foi desenvolvido do zero, configurando manualmente a conexão com o banco de dados, resolvendo problemas reais de ambiente (PATH, estrutura de pacotes, compilação) e testando cada endpoint com requisições HTTP — o tipo de fluxo de trabalho que um desenvolvedor back-end enfrenta no dia a dia.

## 🛠️ Tecnologias utilizadas

- **Java 17**
- **Spring Boot 3** (Spring Web, Spring Data JPA)
- **PostgreSQL** — banco de dados relacional
- **Maven** — gerenciamento de dependências
- **Hibernate** — ORM (mapeamento objeto-relacional)

## ⚙️ Funcionalidades

- ✅ Cadastrar novos produtos
- ✅ Listar todos os produtos
- ✅ Buscar produto por ID
- ✅ Atualizar dados de um produto
- ✅ Remover um produto
- ✅ Tratamento centralizado de erros (respostas JSON padronizadas, incluindo status 404 para recursos não encontrados)

## 📋 Endpoints da API

| Método   | Endpoint                | Descrição                        |
|----------|--------------------------|-----------------------------------|
| `GET`    | `/api/produtos`          | Lista todos os produtos          |
| `GET`    | `/api/produtos/{id}`     | Busca um produto pelo ID         |
| `POST`   | `/api/produtos`          | Cria um novo produto             |
| `PUT`    | `/api/produtos/{id}`     | Atualiza um produto existente    |
| `DELETE` | `/api/produtos/{id}`     | Remove um produto                |

### Exemplo de requisição — criar produto

**POST** `/api/produtos`

```json
{
  "nome": "Teclado Mecânico",
  "descricao": "Teclado mecânico RGB switch azul",
  "preco": 250.00,
  "quantidadeEstoque": 15
}
```

### Exemplo de resposta de erro (404)

```json
{
  "timestamp": "2026-09-25T06:59:24.593",
  "status": 404,
  "erro": "Recurso não encontrado",
  "mensagem": "Produto não encontrado com id: 999"
}
```

## 🚀 Como rodar o projeto localmente

### Pré-requisitos

- [JDK 17+](https://adoptium.net/)
- [PostgreSQL](https://www.postgresql.org/download/) instalado e rodando
- Maven (ou use o Maven Wrapper incluso no projeto — `mvnw`)

### Passo a passo

1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU-USUARIO/produto-api.git
   cd produto-api
   ```

2. Crie o banco de dados no PostgreSQL:
   ```sql
   CREATE DATABASE produtodb;
   ```

3. Configure a conexão em `src/main/resources/application.yaml`:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/produtodb
       username: postgres
       password: SUA_SENHA_AQUI
   ```

4. Rode a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```
   *(no Windows PowerShell: `.\mvnw.cmd spring-boot:run`)*

5. A API estará disponível em `http://localhost:8080`

### Testando os endpoints

Você pode usar `curl`, [Postman](https://www.postman.com/), [Insomnia](https://insomnia.rest/) ou o `Invoke-RestMethod` do PowerShell. Exemplo:

```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/produtos" -Method Get
```

## 📁 Estrutura do projeto

```
src/main/java/com/example/produto_api/
├── ProdutoApiApplication.java     # Classe principal
├── controller/
│   └── ProdutoController.java     # Endpoints REST (rotas HTTP)
├── model/
│   └── Produto.java               # Entidade JPA (tabela do banco)
├── repository/
│   └── ProdutoRepository.java     # Acesso a dados via Spring Data JPA
└── exception/
    ├── RecursoNaoEncontradoException.java
    └── GlobalExceptionHandler.java # Tratamento global de erros
```

## 🔮 Próximos passos

Ideias para evoluir o projeto:

- [ ] Validação de dados de entrada (`@NotBlank`, `@Positive`)
- [ ] Documentação interativa com Swagger/OpenAPI
- [ ] Testes automatizados (JUnit + Mockito)
- [ ] Paginação na listagem de produtos
- [ ] Autenticação com Spring Security + JWT
- [ ] Deploy em nuvem (Render, Railway ou AWS)

## 👤 Autor

Desenvolvido por **[Seu Nome]** como projeto de estudo de desenvolvimento back-end com Java e Spring Boot.

- LinkedIn: [seu-linkedin](https://www.linkedin.com/in/pablo-fernandes-melo/)
- GitHub: [@seu-usuario](https://github.com/PabloFMelo)

---

⭐ Se este projeto te ajudou de alguma forma, considere deixar uma estrela no repositório!
