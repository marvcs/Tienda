/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.demo;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author XPC
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{ /*implements trae de una interfaz*/
    
    @Bean /*inyectando dependencias de coniguracion, de que hacer cuando corre*/
    public SessionLocaleResolver localeResolver(){ 
    var slr = new SessionLocaleResolver(); 
    slr.setDefaultLocale(new Locale("en")); /*objeto locale = idioma el cual se quiere mostrar la pagina, idioma, location, region*/
    return slr;
    }
    
    @Bean /*inyectando dependencias de coniguracion, de que hacer cuando corre, detecta cambios en lang*/
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){/*intercepta cambios en la pagina, y lo pasa por parametro para "lang"*/
        registro.addInterceptor(localeChangeInterceptor());
    }
}
