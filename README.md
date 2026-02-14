# 📝 Blog API — Sistema de Blog com Spring Boot e MongoDB

API REST desenvolvida com **Java + Spring Boot + MongoDB** que simula o backend de um sistema de blog com usuários, posts e comentários.

Este projeto foi construído com foco em arquitetura limpa, modelagem NoSQL e boas práticas de desenvolvimento backend.

## 🎯 Objetivos do Projeto

- Aplicar arquitetura em camadas (Controller → Service → Repository)
- Trabalhar com modelagem de dados em MongoDB
- Utilizar DTOs para controle de exposição de dados
- Implementar consultas personalizadas com múltiplos critérios
- Aplicar tratamento global de exceções
- Seguir boas práticas de API REST
- Criar um projeto sólido para portfólio backend Java

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data MongoDB
- MongoDB
- Maven
- Postman

## 🧱 Arquitetura do Projeto

O projeto segue o padrão em camadas:

```

resources            → Camada Web (Controllers REST)
service              → Regras de negócio
repository           → Acesso ao banco (MongoRepository)
domain               → Modelo de domínio
dto                  → Objetos de transferência de dados
services/exceptions  → Exceções do domínio
resources/exceptions → Tratamento global de erros

````

Essa organização garante baixo acoplamento e maior manutenibilidade.

## 🗃️ Modelo de Domínio

### 👤 User
- id
- name
- email
- posts (referência)

### 📝 Post
- id
- date
- title
- body
- author (AuthorDTO)
- comments (Lista de CommentDTO)

### 💬 CommentDTO
- text
- date
- author (AuthorDTO)

### 📌 Estratégia de Modelagem

- Comentários são armazenados como **embedded documents**
- Author é representado por um DTO reduzido
- Relação entre User e Post é feita por referência
- Uso estratégico de DTO para evitar exposição completa das entidades


## 🔎 Consultas Implementadas

### 🔍 Busca por título (case insensitive)

```http
GET /posts/titlesearch?text=viagem
````

Busca posts contendo determinado texto no título.


### 🔍 Busca completa com múltiplos critérios

```http
GET /posts/fullsearch?text=viagem&minDate=2023-01-01&maxDate=2023-12-31
```

Permite:

* Filtrar por texto
* Definir intervalo de datas
* Buscar dentro do título, corpo e comentários
* Utilizar consultas personalizadas com `@Query`


## 🔗 Estratégia NoSQL Utilizada

* Documentos embutidos (Embedded Documents)
* Referência entre documentos
* MongoRepository
* Consultas customizadas com `@Query`
* Conversão entre Entidade e DTO


## ⚠️ Tratamento Global de Exceções

### 📂 Exceções do Domínio

```
services/exceptions
└── ObjectNotFoundException
```

### 📂 Tratamento na Camada Web

```
resources/exceptions
├── StandardError
└── ResourceExceptionHandler
```

### 📄 Exemplo de Resposta de Erro

```json
{
  "timestamp": "2026-02-10T12:10:00Z",
  "status": 404,
  "error": "Object not found",
  "message": "User not found",
  "path": "/users/10"
}
```

## 📡 Endpoints Principais

### 👤 Usuários

```http
GET    /users
GET    /users/{id}
POST   /users
PUT    /users/{id}
DELETE /users/{id}
GET    /users/{id}/posts
```

### 📝 Posts

```http
GET /posts
GET /posts/{id}
GET /posts/titlesearch
GET /posts/fullsearch
```


## 🧪 Como Executar o Projeto

### 1️⃣ Clonar o Repositório

```bash
git clone <url-do-repositorio>
```

### 2️⃣ Certificar que o MongoDB está rodando

Padrão:

```bash
mongodb://localhost:27017
```

### 3️⃣ Configurar `application.properties`

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/workspacemongodb
```

### 4️⃣ Executar a aplicação

```bash
mvn spring-boot:run
```

A API estará disponível em:

```
http://localhost:8080
```

## 🧠 Conceitos Aplicados

* Arquitetura em camadas
* Modelagem NoSQL
* Embedded Documents
* DTO Pattern
* Consultas personalizadas com `@Query`
* Tratamento global de exceções
* Boas práticas REST
* Separação de responsabilidades


## 👨‍💻 Autor

**Matheus Pontes**
📧 [matheus.pontes@mail.uft.edu.br](mailto:matheus.pontes@mail.uft.edu.br)
