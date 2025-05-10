# Spring Boot Hello World API

Este projeto é um exemplo simples de uma API REST criada com Spring Boot. Ele demonstra os conceitos básicos de controle REST, injeção de dependência e mapeamento de requisições HTTP.

## Estrutura do Projeto

```
com.teste.spring_app
├── controller
│   └── HelloWorldController.java
├── domain
│   └── User.java
└── service
    └── HelloWorldService.java
```

## Objetivo

O objetivo desta aplicação é expor endpoints HTTP do tipo GET e POST utilizando o padrão REST. Cada camada do projeto possui uma responsabilidade bem definida:

- `controller`: lida com as requisições HTTP e as respostas.
- `service`: contém a lógica de negócio.
- `domain`: contém as classes de modelo utilizadas na aplicação.

## Detalhes Técnicos

### `@RestController`

A anotação `@RestController` informa ao Spring que a classe é um controller REST, ou seja, ela tratará requisições HTTP e retornará respostas diretamente (sem a necessidade de utilizar `@ResponseBody` em cada método).

Ela é equivalente a:

```java
@Controller
@ResponseBody
```

### Stateless x Stateful

- **Stateless**: O servidor não armazena estado entre as requisições. Cada requisição contém todas as informações necessárias para ser processada. Os controllers REST normalmente seguem esse padrão.
- **Stateful**: O servidor mantém o estado entre as requisições do cliente (ex: sessões de login).

### Injeção de Dependência com `@Autowired`

A anotação `@Autowired` é usada para realizar a injeção de dependência automaticamente. Neste projeto, ela injeta a instância de `HelloWorldService` no controller para que possa ser usada nos métodos de endpoint.

### Arquitetura em Camadas

Esta separação segue a arquitetura em camadas:

- **Controller**: recebe as requisições e envia as respostas.
- **Service**: centraliza a lógica de negócio.
- **Domain/Model**: define as entidades da aplicação.

### `@RequestMapping("/hello-world")`

Define o prefixo do endpoint. Todas as requisições feitas para `/hello-world` serão tratadas pelos métodos desta classe.

### Métodos

#### `GET /hello-world`

```java
@GetMapping
public String helloWorld() {
    return helloWorldService.helloWorld("Karol");
}
```

Esse endpoint retorna uma mensagem simples, utilizando a lógica da camada de serviço.

#### `POST /hello-world`

```java
@PostMapping
public String helloWorldPost(@RequestBody User body) {
    return "Hello World Post " + body.getName();
}
```

Este endpoint aceita um objeto JSON representando um usuário e retorna uma saudação personalizada.

## Classe `User`

```java
@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private String email;
}
```

- Utiliza anotações do [Lombok](https://projectlombok.org/) para gerar automaticamente métodos comuns, como `get`, `set` e o construtor com todos os argumentos.

## Classe `HelloWorldService`

```java
@Service
public class HelloWorldService {
    public String helloWorld(String name) {
        return "Hello World " + name;
    }
}
```

Contém a lógica de geração da mensagem de saudação. Está anotada com `@Service` para ser gerenciada pelo Spring e poder ser injetada nos controllers.

## Requisitos

- Java 17+
- Spring Boot 3+
- Lombok

## Como rodar

1. Clone o repositório
2. Importe em sua IDE como projeto Maven/Gradle
3. Execute a classe principal
4. Teste os endpoints com Postman, Insomnia ou curl

### Exemplos de Requisição

```bash
# GET request
curl http://localhost:8080/hello-world

# POST request
curl -X POST http://localhost:8080/hello-world \
  -H "Content-Type: application/json" \
  -d '{"name": "Maria", "email": "maria@email.com"}'
```

## Melhorias Futuras

- ✅ Separar DTOs de entidades de domínio
- ⬜ Validar dados recebidos no corpo da requisição com `@Valid`
- ⬜ Adicionar tratamento de erros com `@ControllerAdvice`
- ⬜ Documentar a API com Swagger/OpenAPI
