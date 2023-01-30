package com.gltraining;

import com.gltraining.beans.Square;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("app.properties")
@ComponentScan("com.gltraining")
@Configuration
public class JavaConfig {
/*
    @Bean
    public Square square(){
        Square square=new Square();
        return square;
    }
    */

}
