# CRUD com Arquitetura Hexagonal - Java + Spring Boot

## 📌 Sobre o projeto

Este projeto é um CRUD (Create, Read, Update e Delete) feito com **Java e Spring Boot**, usando o padrão de **Arquitetura Hexagonal**.

A ideia foi praticar uma forma mais organizada de desenvolver aplicações, separando bem as responsabilidades e deixando o código mais fácil de entender e manter.

---

## 🛠️ Tecnologias usadas

- Java  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Maven  

---

## 🏗️ Estrutura do projeto

O projeto foi dividido em partes para facilitar a organização:

- **domain** → onde ficam as regras de negócio  
- **application** → onde ficam os casos de uso  
- **adapters** → comunicação com o mundo externo (API e banco)  
- **config** → configurações do sistema  
