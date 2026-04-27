# HabiTrack - Sistema de Controle de Hábitos

Aplicação web para gerenciamento de hábitos, composta por uma API REST (backend) e interface web com renderização server-side utilizando Spring MVC.

Projeto desenvolvido com foco em boas práticas de desenvolvimento backend, organização em camadas e separação de responsabilidades.

## 🔧 Tecnologias
- Backend: Java, Spring Boot
- Frontend: HTML, CSS, Templates e Thymeleaf (renderização server-side com Spring MVC)
- Banco de dados: MySQL

## 🚀 Funcionalidades
- Cadastro de usuários
- Criação e gerenciamento de hábitos
- Listagem de dados
- Edição e exclusão (CRUD completo)

## 🏗️ Arquitetura do Projeto

A aplicação foi estruturada seguindo o padrão MVC e separação de responsabilidades:

- **Controllers REST** → Responsáveis pelos endpoints da API (HabitoController, UsuarioController)
- **Controllers de View** → Responsáveis pela renderização das páginas HTML (HabitoViewController, UsuarioViewController)
- **Service** → Camada de regras de negócio
- **Repository** → Acesso ao banco de dados com Spring Data JPA
- **Model** → Entidades da aplicação (Habito, Usuario)
- **Templates** → Interface web renderizada no servidor
- **Static** → Arquivos estáticos (CSS)
Essa abordagem permite separar a lógica de API da interface, facilitando manutenção e possibilitando o uso independente da API, aproximando o projeto de arquiteturas modernas baseadas em serviços.

## 🔌 Endpoints da API (exemplo)

| Método | Rota                  | Descrição                 |
|--------|-----------------------|---------------------------|
| GET    | /usuario/{id}         | Lista um usuario          |
| POST   | /usuario              | Cria um novo usuário      |
| PUT    | /usuario/{id}/editar  | Atualiza um usuario       |
| DELETE | /usuario/{id}/delete  | Remove um usuario         |
| GET    | /habito/{id}          | Lista hábitos             |
| POST   | /habito               | Cria um hábito            |
| PUT    | /habito/{id}/editar   | Atualiza um hábito        |
| DELETE | /habito/{id}/delete   | Remove um hábito          |

## ⚙️ Como executar o projeto

### 🔹 Pré-requisitos
- Java 17+
- MySQL
- Maven

---

### 🔹 Passos

1. Clone o repositório:
```bash
git clone https://github.com/Pedro-Emanuel-79/HabiTrackAPI.git
```

2. Configure o banco de dados no `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/habitrack
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

3. Execute a aplicação:
./mvnw spring-boot:run

4. Acesse no navegador:
http://localhost:8080
