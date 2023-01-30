package com.gltrainings.bootdemo;

import com.gltrainings.bootdemo.beans.Canvas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER= LoggerFactory.getLogger(BootdemoApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BootdemoApplication.class, args);
		Canvas canvas =context.getBean(Canvas.class);
		canvas.drawShape();

        LOGGER.debug("*** i am debug");
        LOGGER.info("*** i am info");
        LOGGER.error("*** i am error");


    }


}
