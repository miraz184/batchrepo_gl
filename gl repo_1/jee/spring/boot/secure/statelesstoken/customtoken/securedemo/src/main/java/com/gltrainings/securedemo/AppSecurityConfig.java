package com.gltrainings.securedemo;


import com.gltrainings.securedemo.util.CustomAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class AppSecurityConfig {

    @Autowired
    private CustomAuthenticationFilter filter;


    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.cors()//.configurationSource(corsConfiguration())
                .and()
                .csrf().disable().httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/p/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/c/**").hasAnyRole("CUSTOMER","ADMIN")
                .antMatchers("/a/**").hasAnyRole("ADMIN")
                .and()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }
/*
    @Bean
    public CorsConfigurationSource corsConfiguration() {
        UrlBasedCorsConfigurationSource configuration = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://ourfrontend.com");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        configuration.registerCorsConfiguration("/**", corsConfiguration);
        return configuration;
    }
*/

}
