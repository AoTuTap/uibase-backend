# UIBase Backend

Spring Boot backend for a Flowbase-like UI component marketplace.

## Stack

- Java 21
- Spring Boot 3
- Maven
- Spring Web
- Spring Data JPA
- Spring Security
- PostgreSQL
- Supabase PostgreSQL
- Docker
- Render deploy

## Required environment variables

```env
DATABASE_URL=jdbc:postgresql://db.xxxxxx.supabase.co:5432/postgres?sslmode=require
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=your_supabase_database_password
JWT_SECRET=change-me-super-long-secret-key
FRONTEND_URL=http://localhost:3000
```

If you use Supabase Session Pooler, username may look like:

```env
DATABASE_USERNAME=postgres.xxxxxx
```

## Run locally

```bash
./mvnw spring-boot:run
```

Or on Windows:

```bash
mvnw.cmd spring-boot:run
```

Health check:

```bash
curl http://localhost:8080/api/health
```

## Build

```bash
./mvnw -DskipTests package
```

## Deploy to Render

Create a Render Web Service:

- Runtime: Docker
- Branch: main
- Plan: Free

Set environment variables:

```env
DATABASE_URL=jdbc:postgresql://.../postgres?sslmode=require
DATABASE_USERNAME=postgres...
DATABASE_PASSWORD=...
JWT_SECRET=...
FRONTEND_URL=https://your-frontend.vercel.app
```

## Current APIs

```text
GET /api/health
GET /api/categories
GET /api/platforms
GET /api/assets
GET /api/assets/{slug}
```

Notes:

- Do not hardcode Supabase credentials.
- Database tables already exist in Supabase.
- JPA uses `ddl-auto: validate`.
- Flyway is included but disabled for now.
