package com.gltraining.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;


@EnableAspectJAutoProxy
@PropertySource("app.properties")
@ComponentScan("com.gltraining.aopdemo")
@Configuration
public class JavaConfig {

}
