# Desafio DB1 - API de Gerenciamento de Tarefas

## Descrição

Esta é uma API desenvolvida como parte do desafio trainee, focada no gerenciamento de tarefas. A aplicação permite realizar operações de **CRUD (Create, Read, Update, Delete)** em tarefas, utilizando Spring Boot e documentando todos os endpoints com **Swagger**.

## Funcionalidades

- **Adicionar uma nova tarefa**
- **Buscar todas as tarefas**
- **Buscar uma tarefa específica por ID**
- **Atualizar uma tarefa existente**
- **Deletar uma tarefa por ID**

Cada tarefa possui informações como título, descrição, data de criação, status, prioridade e data limite para conclusão.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.3.5**
- **H2 Database** (banco de dados em memória)
- **Spring Data JPA**
- **Springdoc OpenAPI** (Swagger) para documentação da API

## Endpoints da API

- **POST /tasks**: Adiciona uma nova tarefa
- **GET /tasks**: Retorna todas as tarefas
- **GET /tasks/{id}**: Retorna uma tarefa específica pelo ID
- **PUT /tasks/{id}**: Atualiza uma tarefa específica pelo ID
- **DELETE /tasks/{id}**: Remove uma tarefa pelo ID

## Exemplos de Requisições

### Adicionar uma Tarefa (POST /tasks)

```json
{
  "titulo": "Finalizar relatório",
  "descricao": "Finalizar o relatório do segundo bimestre",
  "prioridade": "Alta",
  "dataFinal": "2024-11-10T18:00:00"
}
```

### Atualizar uma Tarefa (PUT /tasks/{id})

```json
{
  "titulo": "Atualizar sistema",
  "descricao": "Atualizar o backend do sistema para a versão mais recente",
  "prioridade": "Média",
  "status": "Em andamento",
  "dataFinal": "2024-11-12T18:00:00"
}
```

## Estrutura do Projeto

- **model/**: Contém a classe `Tarefa` que representa a entidade de tarefa no sistema.
- **service/**: Contém a lógica de negócios para gerenciamento das tarefas.
- **controller/**: Contém os endpoints REST para comunicação com a API.

## Observação

- O banco de dados H2 é volátil, ou seja significa que todos os dados serão perdidos quando a aplicação for encerrada.
- A documentação do Swagger facilita a visualização e teste dos endpoints.

