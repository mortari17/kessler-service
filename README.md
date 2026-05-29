# Kessler Service API

## Global Solution - Microservice and Web Engineering & IT Services

API REST desenvolvida em Java com Spring Boot para gerenciamento de tecnologias espaciais, missões, detritos orbitais e créditos orbitais.

O projeto foi desenvolvido com base no tema da Global Solution, abordando o problema da Síndrome de Kessler e o monitoramento de objetos espaciais em órbita terrestre.

---

# Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* Docker
* Docker Compose
* Swagger / OpenAPI
* Maven

---

# Estrutura do Projeto

```txt
src/main/java/br/com/fiap/kessler_service
├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── config
└── exception
```

---

# Como Executar o Projeto

## 1. Clonar o repositório

```bash
git clone <URL_DO_REPOSITORIO>
```

---

## 2. Entrar na pasta do projeto

```bash
cd kessler-service
```

---

# Como Subir o Banco de Dados MySQL

O banco de dados é executado utilizando Docker.

## Executar o MySQL com Docker

Na raiz do projeto execute:

```bash
docker-compose up -d
```

Esse comando utilizará o arquivo:

```txt
docker-compose.yml
```

para criar e iniciar o container do MySQL.

---

# Credenciais do Banco de Dados

```properties
DATABASE=kessler_db
USERNAME=root
PASSWORD=root
PORT=3306
```

---

# Como Rodar a Aplicação Spring Boot

Após subir o MySQL, execute a aplicação com o comando:

```bash
mvn spring-boot:run
```

A aplicação iniciará na porta:

```txt
9000
```

---

# Swagger / Documentação da API

Após iniciar a aplicação, acessar:

```txt
http://localhost:9000/
```

A documentação Swagger/OpenAPI ficará disponível nessa URL.

---

# Versionamento da API

Todos os endpoints utilizam versionamento:

```txt
/api/v2
```

Exemplo:

```txt
GET /api/v2/missoes
```

---

# Entidades da Aplicação

A API possui 4 entidades principais:

* Tecnologia
* Missao
* DetritoOrbital
* CreditoOrbital

---

# Relacionamentos

## Tecnologia → Missão

Uma tecnologia pode estar relacionada a várias missões.

---

## Missão → Detrito Orbital

Uma missão pode possuir vários detritos orbitais.

---

## Detrito Orbital → Crédito Orbital

Um detrito orbital pode possuir vários créditos orbitais.

---

# Como Testar a API do Zero

## Passo 1 - Subir o MySQL

```bash
docker-compose up -d
```

---

## Passo 2 - Rodar a aplicação Spring Boot

```bash
mvn spring-boot:run
```

---

## Passo 3 - Abrir o Swagger

Acessar:

```txt
http://localhost:9000/
```

---

## Passo 4 - Testar os endpoints

Utilizar o Swagger para:

* Criar tecnologias
* Criar missões
* Criar detritos orbitais
* Criar créditos orbitais
* Consultar registros
* Atualizar registros
* Remover registros

---

# Observações

* O projeto utiliza arquitetura em camadas.
* A aplicação utiliza DTOs para entrada e saída de dados.
* O banco de dados é criado automaticamente pelo Hibernate.
* Os relacionamentos utilizam chaves estrangeiras no MySQL.
* A API segue o padrão REST.
