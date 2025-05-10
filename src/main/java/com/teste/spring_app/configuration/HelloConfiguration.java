package com.teste.spring_app.configuration;
//classe de config é usada no spring para definir bins
//instancias de classe no contexto de uma aplicação spring

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfiguration {
//@Bean usada dentro das classe de @Configuration p indicar pro spring
//que ele deve gerenciar o retorno do metodo (SDKAWS) como um Bean no contexto da aplicação
    //cria instancia de classes que n podem ser gerenciadas pelo spring
    //classes que vem de biblioteca de terceiros ou que precisa de um
// controle específico sobre a implementação dessa classe
  /*  @Bean
    public SDKAWS sdkaws(){
        return new SDKAWS;
    }*/
}
