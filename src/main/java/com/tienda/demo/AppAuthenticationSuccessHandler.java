/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 *
 * @author XPC
 */

public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
    protected void handle(HttpServlet request, HttpServletResponse response,
            Authentication authentication)throws IOException,ServletException{}
}

//maneja exceptions y la autentication si es aprobada
/*
$2a$12$4SfHG6MrSgQDu1MOsTGQ3Ob6eCPI0E5jnOTGSDH6aRswb4DH42pIG
$2a$12$UR8GU7bPRGFojeumOM2YhurHXrRXTLJMjbIYzBipcuJV1X4c/dHZW
$2a$12$dfCdBImYXMeCd9he92N7a.yLpyGr.etd19.WRDUbUluRPA1vNsCHO

456789

*/