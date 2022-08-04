/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.demo;

import com.tienda.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author XPC
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
       @Autowired
    private UserService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserService getUserService(){
        return new UserService();
    }
    
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(getUserService());
        return daoAuthenticationProvider;
    }
    
    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler(){
        return new AppAuthenticationSuccessHandler();
    }
    
    public SecurityConfig(UserService userPrincipalDetailsService){
        this.userDetailsService=userPrincipalDetailsService;
    }
    
    @Override
    protected void configure (AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authenticationProvider());
    }
    
    @Override
    protected void configure (HttpSecurity http ) throws Exception{
        http.authorizeRequests().anyRequest().permitAll();
                
    }
}
/*
.antMatchers("/persona","/login","/personasN","/report") //tiene acceso a..
                .hasRole("ADMIN") //siempre y cuando tenga el rol
                .antMatchers("/persona","/","/login") //tiene acceso a..
                .hasAnyRole("USER","VENDEDOR","ADMIN","/report")  //siempre y cuando tenga el rol
                .anyRequest().not().authenticated() //requests todos autenticados
                .and()
                .formLogin()
                .loginPage("/login").permitAll().defaultSuccessUrl("/persona",true);

*/