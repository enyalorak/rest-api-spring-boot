package com.teste.spring_app.controller;
//para que o spring identifique que essa classe é um controller REST e faça tds as
//config para que ela recebas as requisições, consiga fazer as respostas do http
//pra quem fez as requsições para a aplicação
//sera necessario algumas anotações
//@RestController - indica que a classe é um controller rest
//@RestController é uma combinação de @Controller + @ResponseBody,
// o que evita a necessidade de colocar @ResponseBody em cada método.

import com.teste.spring_app.domain.User;
import com.teste.spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// STATELESS -> O servidor não armazena informações da sessão do cliente entre requisições
//STATELESS -> a cada nova req recebo eu recebo tds as  informacoes que eu preciso
//para fazer aquela funcionalidade que o cliente ta pedindo
// STATEFUL  -> O servidor mantém o estado da sessão do cliente entre requisições.
// Controllers REST geralmente são STATELESS, ou seja, cada requisição é independente.
@RequestMapping("/hello-world")
//mapear os endpoints
//escuta tds as req que chegar no endpoint de /hello-world
public class HelloWorldController {
    @Autowired //indica para o spring que essa dependencia tem que ser injetada
    private HelloWorldService helloWorldService;


    //GET /hello-world
    @GetMapping
    public String helloWorld(){
        return helloWorldService.helloWorld("Karol");
    }

   // @PostMapping("")
    //public String helloWorldPost(@RequestBody User body){
      //  return "Hello World Post" + body.getName();
  //  }

    @PostMapping
    public String helloWorldPost(@RequestBody User body){
        return "Hello World Post" + body.getName();
    }
}
