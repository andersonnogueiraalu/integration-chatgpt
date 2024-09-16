# ChatGPT API Integration com Spring Boot

## Descrição do Projeto

Este projeto consiste em uma aplicação backend desenvolvida em Spring Boot que realiza integração com a API do OpenAI
ChatGPT para enviar prompts de comando e receber respostas. As respostas são armazenadas em um banco de dados PostgreSQL
para consultas posteriores. A API é documentada com Swagger OpenAPI e a aplicação é conteinerizada utilizando Docker e
Docker Compose para facilitar a configuração e a execução em diferentes ambientes.

## Tecnologias Utilizadas

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

- **Java 17**: Linguagem de programação.
- **Spring Boot**: Framework para criação de aplicações Java.
- **Spring Data JPA**: Abstração de persistência de dados.
- **PostgreSQL**: Banco de dados relacional.
- **Swagger**: Ferramenta para documentação e teste de APIs.

## Endpoints

### Chat-controller

   ```http
   POST /api/chat - Descrição: Enviar um promtp para API da OpenIA.
   ```

## Como Executar o Projeto

1. **Clone o repositório**:
   ```sh
   git clone https://github.com/andersonnogueiraalu/integration-chatgpt
   cd integration-chatgpt
   ```
2. **Configure variáveis de ambiente**:
   -Configurar Variáveis de Ambiente Defina a sua chave de API da OpenAI em um arquivo .env ou no docker-compose.yml:

   ```sh
    OPENAI_API_KEY=your-api-key-here
   ```

3. **Build da Aplicação com Docker**:
   -Build da Aplicação com Docker Para rodar a aplicação com o Docker, execute o seguinte comando:

   ```sh
    docker-compose up --build
   ```

4. **Configure o Banco de Dados**:

- Crie um banco de dados PostgreSQL.
- Atualize as configurações de conexão no arquivo application.properties.

5. **Inicie a aplicação**:

   ```sh
    ./mvmw spring-boot:run
   ```

5**Acesse a Documentação Swagger**:

- Abra o navegador e vá para http://localhost:8080/swagger-ui.html para visualizar e testar os endpoints.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo LICENSE para obter mais detalhes.