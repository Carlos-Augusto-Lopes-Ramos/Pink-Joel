🧠 Pink-Joel API

REST API built with Spring Boot for managing users, posts, and comments, featuring token-based authentication, password recovery via email, and Docker containerization.

📌 Overview

User registration and authentication

Token generation and validation

Password recovery via email

Post CRUD with pagination

Comments with authorization control

Communication via JSON and HTTP Status Codes.

🚀 Technologies

Java 17+

Spring Boot (Web, Data JPA)

Relational Database (PostgreSQL)

SMTP (emails)

DTO Pattern

🔐 Authentication

Login generates a token

Token is sent in the header Authorization: Bearer {token}

Token is required for protected operations and password reset

CORS enabled (*) — restrict in production

👤 Users API

Base URL

/api/users

Create user

POST /api/users

{
  "email": "user@email.com",
  "name": "Name",
  "pswrd": "password123"
}

Login

POST /api/users/login

{
  "email": "user@email.com",
  "pswrd": "password123"
}

Authenticated user

GET /api/users/me

Authorization: Bearer {token}

Request password recovery

POST /api/users/recover

{
  "email": "user@email.com"
}

Reset password

PUT /api/users/recover

{
  "token": "received_token",
  "pswrd": "newPassword123"
}

📝 Posts API

Base URL

/api/posts

Create post

POST /api/posts

{
  "title": "Title",
  "content": "Content",
  "image": "https://img.com/img.png"
}

List posts

GET /api/posts

List paginated posts

GET /api/posts?page=0&size=10

Delete post

DELETE /api/posts/{id}

Related comments are automatically removed.

💬 Comments API

Base URL

/api/comments

Create comment

POST /api/comments

Authorization: Bearer {token}

{
  "postId": 10,
  "content": "Comment text",
  "image": "https://img.com/img.png"
}

Update comment

PUT /api/comments/{id}

Authorization: Bearer {token}

Delete comment

DELETE /api/comments/{id}

Authorization: Bearer {token}

📦 DTOs (Summary)
UserDto    → email, name, pswrd
LoginDto   → email, pswrd
RecoverDto → email
PostDto    → title, content, image
CommentDto → postId, content, image

🔒 Security Rules

A user can only edit/delete their own comments

Validation is based on the user extracted from the token

🚧 Roadmap

JWT + Spring Security

BCrypt

Token expiration

Rate limiting

Logging and automated tests

👨‍💻 Author

Carlos Augusto

Academic/professional project. Contributions are welcome.
