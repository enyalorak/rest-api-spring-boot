package com.teste.spring_app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//gera automaticamente os met getter setter e o contrutor
@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private String email;


}
