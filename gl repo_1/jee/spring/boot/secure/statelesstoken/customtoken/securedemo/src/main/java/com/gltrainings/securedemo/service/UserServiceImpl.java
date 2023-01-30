package com.gltrainings.securedemo.service;

import com.gltrainings.securedemo.dto.LoginRequest;
import com.gltrainings.securedemo.dto.UserDetailsImpl;
import com.gltrainings.securedemo.entity.User;
import com.gltrainings.securedemo.exceptions.IncorrectCredentialsException;
import com.gltrainings.securedemo.repository.UserRepository;
import com.gltrainings.securedemo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService, IUserService {

    private UserRepository repository;

    private TokenUtil tokenUtil;

    @Autowired
    public UserServiceImpl(UserRepository repository, TokenUtil tokenUtil) {
        this.repository = repository;
        this.tokenUtil = tokenUtil;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=findByUsername(username);
        return toUserDetails(user);
    }

    User findByUsername(String username) {
        Optional<User> optional = repository.findUserByUsername(username);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException("user not found by username=" + username);
        }
        return optional.get();
    }

    public UserDetails toUserDetails(User user) {
        UserDetailsImpl details = new UserDetailsImpl();
        details.setUsername(user.getUsername());
        details.setPassword(user.getPassword());
        Set<String> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase())).collect(Collectors.toList());
        details.setAuthorities(authorities);
        return details;
    }


    @Override
    public String login(LoginRequest requestData) {
       User user=findByUsername(requestData.getUsername());
         if(!user.getPassword().equals(requestData.getPassword().trim())){
             throw new IncorrectCredentialsException("username or password is incorrect");
         }
        Set<String>roles= user.getRoles();
        String token = tokenUtil.encode(requestData.getUsername(), roles);
        return token;
    }

}
