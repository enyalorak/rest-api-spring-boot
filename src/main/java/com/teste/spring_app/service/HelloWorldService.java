package com.teste.spring_app.service;
//logica da aplicação,conexoes com o banco de dados

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public String helloWorld(String name){
        return "Hello World " + name;
    }
}
