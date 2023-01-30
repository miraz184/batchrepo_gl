package com.gltrainings.bootdemo;

import com.gltrainings.bootdemo.beans.Canvas;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 1) @Configuration
 * 2) @ComponentScan
 * 3) @EnableAutoConfiguration
 */

@SpringBootApplication
public class BootdemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BootdemoApplication.class, args);
		Canvas canvas =context.getBean(Canvas.class);
		canvas.drawShape();
    }


}
