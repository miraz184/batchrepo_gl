package com.gltrainings.securedemo.util;

import com.gltrainings.securedemo.dto.AdminDetails;
import com.gltrainings.securedemo.dto.CustomerDetails;
import com.gltrainings.securedemo.entity.Admin;
import com.gltrainings.securedemo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AdminnUtil {


    public AdminDetails adminDetails(Admin admin) {
        User user = admin.getUser();
        AdminDetails desired = new AdminDetails();
        desired.setAdminId(admin.getId());
        desired.setRoles(user.getRoles());
        desired.setUsername(user.getUsername());
        return desired;
    }

}
