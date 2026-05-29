# Kessler API

## Global Solution 2026.1 — FIAP

API REST desenvolvida em Java com Spring Boot para gerenciamento de missões espaciais, tecnologias espaciais, detritos orbitais e créditos orbitais.

O projeto foi criado no contexto da Global Solution 2026.1, cujo tema é **Indústria Espacial**, propondo soluções tecnológicas para sustentabilidade orbital e mitigação de lixo espacial.

---

# Tecnologias Utilizadas

* Java 21
* Spring Boot
* MySQL
* Docker
* Swagger / OpenAPI
* Maven

---

# Como Executar o Projeto

## 1. Clonar o repositório

```bash
git clone <URL_DO_REPOSITORIO>
```

---

## 2. Subir o banco MySQL com Docker

Na raiz do projeto execute:

```bash
docker-compose up -d
```

O banco será criado utilizando o arquivo:

```txt
docker-compose.yml
```

---

# Credenciais do Banco

```properties
DATABASE=kessler_db
USERNAME=root
PASSWORD=root
PORT=3306
```

---

# 3. Rodar a aplicação Spring Boot

Execute o comando:

```bash
mvn spring-boot:run
```

A aplicação iniciará na porta:

```txt
9000
```

---

# Swagger / Documentação

A documentação da API estará disponível em:

```txt
http://localhost:9000/
```

---

# Versionamento da API

Todos os endpoints utilizam:

```txt
/api/v2
```

Exemplo:

```txt
GET /api/v2/missoes
```

---

# Como Testar a API

1. Execute o MySQL com Docker
2. Rode a aplicação Spring Boot
3. Acesse o Swagger
4. Teste os endpoints CRUD das entidades:

   * Tecnologias
   * Missões
   * Detritos Orbitais
   * Créditos Orbitais
