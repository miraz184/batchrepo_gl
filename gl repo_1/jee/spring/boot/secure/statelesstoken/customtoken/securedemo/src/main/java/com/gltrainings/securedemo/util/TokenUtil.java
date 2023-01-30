package com.gltrainings.securedemo.util;

import com.gltrainings.securedemo.exceptions.InvalidTokenException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Component
public class TokenUtil {
    //private final  DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-YY");

    public String encode(String username, Set<String> roles) {
        //   String date=LocalDate.now().format(formatter);
        String token = username + "-" + roles.toString();
        return token;
    }

    public String decode(String token) {
        if (token.isBlank()) {
            throw new InvalidTokenException("token s not valid");
        }
        String parts[] = token.split("-");
        System.out.println("token decoded user="+parts[0]);
        if (parts.length != 2) {
            throw new InvalidTokenException("token s not valid");
        }
       /*
       String dateText= parts[2];
       LocalDate currentDate=LocalDate.now();
       LocalDate createdDate=LocalDate.parse(dateText,formatter);
       LocalDate expiryDate=createdDate.minusDays(2);
       if(expiryDate.isAfter(currentDate)){
           throw new InvalidTokenException("your token has expired");
       }
       */
        String username = parts[0];
        String role = parts[1];
        return username;
    }


}
