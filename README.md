[![CircleCI](https://circleci.com/gh/JonatasRodrigues/sistema-solar.svg?style=svg)](https://circleci.com/gh/JonatasRodrigues/sistema-solar)
[![codecov](https://codecov.io/gh/JonatasRodrigues/sistema-solar/branch/main/graph/badge.svg)](https://codecov.io/gh/JonatasRodrigues/sistema-solar)


# sistema-solar

Aplicação para calcular a previsão do tempo de um determinado sistema solar em um período de tempo.

# Pré-requisitos

<li>Java 8</li>
<li>SpringBoot e SpringJPA</li>
<li>Maven 3.5.2</li>
<li>Docker e Docker-Compose</li>
<li>Mysql v. 14 14 for linux</li>
<li>JUnit</li>
<li>CircleCi</li>
<li>Prometheus</li>
<li>Grafana</li>

# Instruções

O comando deverá ser executado via terminal.

Fazer o checkout via GitHub e na raiz do projeto executar os comandos abaixo para criar os conteiners Java, Grafana, Prometheus e Mysql-server.
O JobTask realizará a carga no banco de dados.

- mvn clean compile install
- docker-compose up --build

A partir de agora você poderá acessar os serviços pelos endpoints.


### Endpoint
- http://localhost:80/api/v1/clima?dia={dia}

### Swagger
- http://localhost:80/swagger-ui.html

### Prometheus
- http://localhost:9090/

### Grafana
- http://localhost:3000


# Release Notes

- JobTask -> job que realiza a carga inicial no banco de dados
- CalculoUtil -> classe responsável pelo calculos geométricos
- SistemaSolar -> classe main 
