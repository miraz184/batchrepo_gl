package org.globaltrainings.springjpademo;

import org.globaltrainings.springjpademo.frontend.FrontEnd;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationLaunch {
    public static void main(String args[]){
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        FrontEnd frontEnd=context.getBean(FrontEnd.class);
        frontEnd.runUI();

    }
}
