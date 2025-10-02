# Room Booker API

API para gerenciamento e reserva de salas, desenvolvida em Java com Spring Boot e conteinerizada com Docker.

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

* [Docker](https://www.docker.com/get-started)
* [Docker Compose](https://docs.docker.com/compose/install/) (geralmente já vem incluído com o Docker Desktop)

## Como Executar

Existem duas maneiras de executar esta aplicação localmente: usando Docker Compose (recomendado para desenvolvimento) ou executando a imagem Docker diretamente.

### Opção 1: Com Docker Compose (Ambiente Completo)

Este é o método **recomendado**, pois ele irá configurar e iniciar tanto a aplicação quanto o banco de dados PostgreSQL, já conectados e prontos para uso.

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/Viihcerq/RoomBooker.git
    ```

2.  **Inicie os serviços:**
    Execute o seguinte comando na raiz do projeto (onde o arquivo `docker-compose.yml` está localizado):
    ```bash
    docker-compose up --build
    ```
    * O comando irá construir a imagem da API e iniciar os contêineres da aplicação e do banco de dados.
    * Para rodar em segundo plano, adicione a flag `-d`: `docker-compose up --build -d`.

3.  **Para parar os serviços:**
    Quando terminar, pressione `CTRL + C` no terminal ou, se estiver rodando em segundo plano, execute:
    ```bash
    docker-compose down
    ```

## Acessando a Documentação da API (Swagger)

Após iniciar a aplicação por **qualquer um dos métodos acima**, a interface do Swagger UI estará disponível no seu navegador para visualizar e testar os endpoints da API.

Acesse o seguinte endereço:

[**http://localhost:8080/swagger-ui.html**](http://localhost:8080/swagger-ui.html)