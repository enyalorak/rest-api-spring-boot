package com.teste.spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication //essa anotação condensa essas 3 anotações mencionadas abaixo
//@Configuration define que a classe pode ter metodos que definem bins
//@EnableAutoConfiguration - ativa autoconfiguracao do spring
//@ComponentScan  permite que o sping scaneie td pacote doprojeto embusca dos componentes, classes, etc..

public class SpringAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringAppApplication.class, args);
	}

}
