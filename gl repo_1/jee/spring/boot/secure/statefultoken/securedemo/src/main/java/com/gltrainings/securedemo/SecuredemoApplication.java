package com.gltrainings.securedemo;

import com.gltrainings.securedemo.dto.AddAdmin;
import com.gltrainings.securedemo.dto.AdminDetails;
import com.gltrainings.securedemo.service.IAdminService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SecuredemoApplication {

	public static void main(String[] args) {
	ApplicationContext context =SpringApplication.run(SecuredemoApplication.class, args);
	IAdminService service=context.getBean(IAdminService.class);
	AddAdmin request=new AddAdmin();
	request.setUsername("miraz");
	request.setPassword("1234");
	AdminDetails admin=service.register(request);
	System.out.println("***admin registered with username "+admin.getUsername());
	}

}
