# 🧠 Pink-Joel API

API REST em **Spring Boot** para gerenciamento de **usuários**, **posts** e **comentários**, com autenticação por **token** e recuperação de senha via **e-mail** e **containerização em Docker**

---

## 📌 Visão Geral

* Cadastro e autenticação de usuários
* Geração e validação de tokens
* Recuperação de senha por e-mail
* CRUD de posts com paginação
* Comentários com controle de autorização

Comunicação via **JSON** e **HTTP Status Codes**.

---

## 🚀 Tecnologias

* Java 17+
* Spring Boot (Web, Data JPA)
* Banco Relacional (PostgreSQL)
* SMTP (e-mails)
* DTO Pattern

---

## 🔐 Autenticação

* Login gera um **token**
* Token é enviado no header `Authorization: Bearer {token}`
* Token é usado para operações protegidas e recuperação de senha
* CORS liberado (`*`) — restringir em produção

---

# 👤 Users API

**Base URL**

```
/api/users
```

### Criar usuário

**POST** `/api/users`

```json
{
  "email": "user@email.com",
  "name": "Nome",
  "pswrd": "senha123"
}
```

### Login

**POST** `/api/users/login`

```json
{
  "email": "user@email.com",
  "pswrd": "senha123"
}
```

### Usuário autenticado

**GET** `/api/users/me`

```
Authorization: Bearer {token}
```

### Solicitar recuperação de senha

**POST** `/api/users/recover`

```json
{
  "email": "user@email.com"
}
```

### Redefinir senha

**PUT** `/api/users/recover`

```json
{
  "token": "token_recebido",
  "pswrd": "novaSenha123"
}
```

---

# 📝 Posts API

**Base URL**

```
/api/posts
```

### Criar post

**POST** `/api/posts`

```json
{
  "title": "Título",
  "content": "Conteúdo",
  "image": "https://img.com/img.png"
}
```

### Listar posts

**GET** `/api/posts`

### Listar posts paginados

**GET** `/api/posts?page=0&size=10`

### Remover post

**DELETE** `/api/posts/{id}`

> Comentários vinculados são removidos automaticamente.

---

# 💬 Comments API

**Base URL**

```
/api/comments
```

### Criar comentário

**POST** `/api/comments`

```
Authorization: Bearer {token}
```

```json
{
  "postId": 10,
  "content": "Texto do comentário",
  "image": "https://img.com/img.png"
}
```

### Atualizar comentário

**PUT** `/api/comments/{id}`

```
Authorization: Bearer {token}
```

### Remover comentário

**DELETE** `/api/comments/{id}`

```
Authorization: Bearer {token}
```

---

## 📦 DTOs (Resumo)

```text
UserDto    → email, name, pswrd
LoginDto   → email, pswrd
RecoverDto → email
PostDto    → title, content, image
CommentDto → postId, content, image
```

---

## 🔒 Regras de Segurança

* Usuário só pode editar/remover **seus próprios comentários**
* Validação baseada no usuário do token

---

## 🚧 Roadmap

* JWT + Spring Security
* BCrypt
* Expiração de token
* Rate limit
* Logs e testes automatizados

---

## 👨‍💻 Autor

**Carlos Augusto**

> Projeto acadêmico/profissional. Contribuições são bem-vindas.
