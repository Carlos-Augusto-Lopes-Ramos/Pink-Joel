🧠 Pink-Joel API

REST API developed with Spring Boot for managing Users, Posts, and
Comments, featuring token-based authentication, email password recovery,
and Docker containerization.

------------------------------------------------------------------------

📌 Overview

-   User registration and authentication
-   Token generation and validation
-   Password recovery via email
-   CRUD operations for posts (with pagination)
-   Comment system with authorization control
-   JSON communication with proper HTTP status codes

------------------------------------------------------------------------

🏗️ Architecture

-   Layered Architecture (Controller → Service → Repository)
-   DTO Pattern
-   Token-based authentication
-   Relational database integration
-   Dockerized environment

------------------------------------------------------------------------

🚀 Technologies

-   Java 17+
-   Spring Boot (Web, Data JPA)
-   PostgreSQL
-   SMTP (Email Service)
-   Docker
-   Maven

------------------------------------------------------------------------

🔐 Authentication

Authentication is token-based.

Token must be sent in protected requests:

Authorization: Bearer {token}

CORS is currently open (*) — restrict in production.

------------------------------------------------------------------------

👤 Users API

Base URL: /api/users

Create User

POST /api/users

{ “email”: “user@email.com”, “name”: “Name”, “pswrd”: “password123” }

Login

POST /api/users/login

{ “email”: “user@email.com”, “pswrd”: “password123” }

Get Authenticated User

GET /api/users/me Header: Authorization: Bearer {token}

Request Password Recovery

POST /api/users/recover

{ “email”: “user@email.com” }

Reset Password

PUT /api/users/recover

{ “token”: “received_token”, “pswrd”: “newPassword123” }

------------------------------------------------------------------------

📝 Posts API

Base URL: /api/posts

Create Post

POST /api/posts

{ “title”: “Post Title”, “content”: “Post content”, “image”:
“https://img.com/image.png” }

List Posts

GET /api/posts

List Paginated Posts

GET /api/posts?page=0&size=10

Delete Post

DELETE /api/posts/{id} (Associated comments are automatically removed.)

------------------------------------------------------------------------

💬 Comments API

Base URL: /api/comments

Create Comment

POST /api/comments Header: Authorization: Bearer {token}

{ “postId”: 10, “content”: “Comment text”, “image”:
“https://img.com/image.png” }

Update Comment

PUT /api/comments/{id} Header: Authorization: Bearer {token}

Delete Comment

DELETE /api/comments/{id} Header: Authorization: Bearer {token}

------------------------------------------------------------------------

📦 DTO Summary

UserDto → email, name, pswrd LoginDto → email, pswrd RecoverDto → email
PostDto → title, content, image CommentDto → postId, content, image

------------------------------------------------------------------------

🔒 Security Rules

-   Users can only edit/delete their own comments
-   Authorization is validated using the authenticated user from the
    token

------------------------------------------------------------------------

🐳 Docker

docker build -t pink-joel-api . docker run -p 8080:8080 pink-joel-api

------------------------------------------------------------------------

⚙️ Running Locally

git clone https://github.com/your-username/pink-joel-api.git cd
pink-joel-api ./mvnw spring-boot:run

Application runs at: http://localhost:8080

------------------------------------------------------------------------

👨‍💻 Author

Carlos Augusto Academic / Professional Project
