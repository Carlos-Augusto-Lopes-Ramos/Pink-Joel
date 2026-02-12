# 🧠 Pink-Joel API

REST API built with **Spring Boot** for managing **users**, **posts**, and **comments**, featuring **token-based authentication**, password recovery via **email**, and **Docker containerization**.

---

## 📌 Overview

- User registration and authentication  
- Token generation and validation  
- Password recovery via email  
- Post CRUD with pagination  
- Comments with authorization control  

Communication via **JSON** and standard **HTTP Status Codes**.

---

## 🚀 Technologies

- Java 17+  
- Spring Boot (Web, Data JPA)  
- PostgreSQL (Relational Database)  
- SMTP (Email service)  
- DTO Pattern  
- Docker  

---

## 🔐 Authentication

- Login generates a **token**
- Token must be sent in the header:

```http
Authorization: Bearer {token}
Required for protected operations and password reset

CORS enabled (*) — restrict in production

👤 Users API
Base URL
/api/users

➕ Create User
POST /api/users

{
  "email": "user@email.com",
  "name": "Name",
  "pswrd": "password123"
}

🔑 Login
POST /api/users/login

{
  "email": "user@email.com",
  "pswrd": "password123"
}

👤 Get Authenticated User
GET /api/users/me

Authorization: Bearer {token}

🔄 Request Password Recovery
POST /api/users/recover

{
  "email": "user@email.com"
}

🔁 Reset Password
PUT /api/users/recover

{
  "token": "received_token",
  "pswrd": "newPassword123"
}

📝 Posts API
Base URL
/api/posts

➕ Create Post
POST /api/posts

{
  "title": "Title",
  "content": "Content",
  "image": "https://img.com/img.png"
}

📄 List Posts
GET /api/posts

📄 List Paginated Posts
GET /api/posts?page=0&size=10

❌ Delete Post
DELETE /api/posts/{id}


Related comments are automatically removed.

💬 Comments API
Base URL
/api/comments

➕ Create Comment
POST /api/comments

Authorization: Bearer {token}

{
  "postId": 10,
  "content": "Comment text",
  "image": "https://img.com/img.png"
}

✏️ Update Comment
PUT /api/comments/{id}

Authorization: Bearer {token}

❌ Delete Comment
DELETE /api/comments/{id}

Authorization: Bearer {token}

📦 DTOs
UserDto    → email, name, pswrd
LoginDto   → email, pswrd
RecoverDto → email
PostDto    → title, content, image
CommentDto → postId, content, image

🔒 Security Rules

Users can only edit/delete their own comments

Validation is based on the authenticated user extracted from the token

🚧 Roadmap

JWT + Spring Security

BCrypt password encryption

Token expiration

Rate limiting

Logging

Automated tests

👨‍💻 Author

Carlos Augusto

Academic/professional project. Contributions are welcome.
