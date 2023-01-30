package com.gltrainings.securedemo.service;

import com.gltrainings.securedemo.dto.AddAdmin;
import com.gltrainings.securedemo.dto.AdminDetails;
import com.gltrainings.securedemo.entity.Admin;
import com.gltrainings.securedemo.entity.User;
import com.gltrainings.securedemo.repository.IAdminRepository;
import com.gltrainings.securedemo.util.AdminnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service
public class AdminServiceImpl implements IAdminService {

    private IAdminRepository repository;
    private AdminnUtil adminUtil;

    @Autowired
    public AdminServiceImpl(IAdminRepository repository, AdminnUtil adminUtil){
        this.repository=repository;
        this.adminUtil=adminUtil;
    }


    @Transactional
    @Override
    public AdminDetails register(AddAdmin requestData) {
        User user=new User();
        user.setUsername(requestData.getUsername());
        user.setPassword(requestData.getPassword());
        Set<String> roles=new HashSet<>();
        roles.add("ADMIN");
        user.setRoles(roles);
        Admin admin = new Admin();
        admin.setUser(user);
        admin=repository.save(admin);
       return adminUtil.adminDetails(admin);
    }
}
