![image](https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=github-actions&logoColor=white)
![image](https://img.shields.io/badge/Render-46E3B7?style=for-the-badge&logo=render&logoColor=white)
![image](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![image](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)
![image](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![image](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![image](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)

# Projeto de API em Rest

Este é um projeto de exemplo de uma API REST feito em Java

## Link de acesso ao projeto

https://django-potencia-tech.onrender.com/api/v1/docs/

## Sumário:

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias](#tecnologias)
- [Setup](#setup)
- [Abordagem](#abordagem)
- [License](#license)

## Sobre o Projeto

Este projeto demonstra a criação de uma API RESTful usando o framework Spring boot. O objetivo é fornecer um exemplo simples para configurar e executar o projeto.

## Tecnologias

Este projeto faz uso de diversas tecnologias e ferramentas, incluindo:

- **Spring Boot**: Framework para simplificação do desenvolvimento de aplicações Java baseadas em Spring.
  - `spring-boot-starter-web`: Starter para construir aplicações web, incluindo RESTful, utilizando Spring MVC.
  - `spring-boot-starter-data-jpa`: Starter para simplificar a implementação de JPA baseado no Hibernate.
  - `spring-boot-starter-test`: Starter para testes unitários e de integração utilizando JUnit, Hamcrest e Mockito.
- **PostgreSQL**: Banco de dados relacional utilizado pela aplicação.
  - `postgresql`: Driver JDBC para conexão com o banco de dados PostgreSQL.
- **java-dotenv**: Biblioteca para carregar variáveis de ambiente a partir de um arquivo `.env`.
- **Springdoc OpenAPI**: Ferramenta para geração automática de documentação da API RESTful.
  - `springdoc-openapi-starter-webmvc-ui`: Integração com Spring Boot e Spring MVC para geração de documentação OpenAPI.
- **Docker**: Plataforma para criar, implantar e executar aplicativos em contêineres.

## Setup

### Iniciando o Projeto Localmente

Para iniciar o projeto localmente, siga as instruções abaixo:

1. **Clone o Repositório**: Faça uma cópia deste repositório em sua máquina local.

2. **Configuração do Ambiente Java**: Certifique-se de que você possui um ambiente java configurado.

3. **Inicie o Servidor de Desenvolvimento do Spring boot**:

   ```bash
   ./mvnw spring-boot:run
   ```

4. **Crie um arquivo .env e cole o seguinte**:

```bash
## Prencha seus dados aqui
POSTGRESDB_USER=
POSTGRESDB_ROOT_PASSWORD=
POSTGRESDB_DATABASE=orders
POSTGRESDB_LOCAL_PORT=5430
POSTGRESDB_DOCKER_PORT=5432

SPRING_LOCAL_PORT=8080
SPRING_DOCKER_PORT=8080
```

5. Agora, você pode acessar o projeto em [http://localhost:8080/](http://localhost:8080/).

### Iniciando o Projeto com Docker

Se preferir usar Docker, siga estas etapas:

1. **Clone o Repositório**: Clone o repositório em sua máquina local.

2. Certifique-se de que o Docker e o Docker Compose estejam instalados.

3. Execute o seguinte comando para construir o ambiente de desenvolvimento:

   ```bash
   docker-compose up
   ```

4. **Crie um arquivo .env e cole o seguinte**:

```bash
## Prencha seus dados aqui
POSTGRESDB_USER=
POSTGRESDB_ROOT_PASSWORD=
POSTGRESDB_DATABASE=orders
POSTGRESDB_LOCAL_PORT=5430
POSTGRESDB_DOCKER_PORT=5432

SPRING_LOCAL_PORT=8080
SPRING_DOCKER_PORT=8080
```

5. Agora, você pode acessar o projeto em [http://localhost:8080/](http://localhost:8080/).

## Abordagem

- **Design Patterns**: Aplicamos padrões de design reconhecidos, como o modelo MVC (Model-View-Controller) do java, que promove a separação de responsabilidades em nossa aplicação.

- **Versionamento de API**: Para garantir a estabilidade e compatibilidade, adotamos um sistema de versionamento de API. Isso permite a evolução controlada da API sem impactar os clientes existentes.

- **Estilo de Código**: Seguimos um estilo de código consistente e claro, aderindo às diretrizes java 17 para Java. Utilizamos nomes de variáveis descritivos.

- **Commits Semânticos**: Adotamos a prática de commits semânticos para manter um histórico de alterações legível e informativo.

## LICENÇAS DE UTILIZAÇÃO

Este projeto é distribuído sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para obter detalhes completos sobre os termos da licença.

Sinta-se à vontade para contribuir com melhorias ou correções para este projeto. Basta abrir uma issue ou enviar um pull request.
