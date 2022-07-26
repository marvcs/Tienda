/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.demo.service;

import com.tienda.demo.entity.Persona;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author XPC
 */
@Service
public interface IPersonaService {
    public List<Persona> getAllPersona();
    public Persona getPersonaById(long id);
    public void savePersona(Persona persona);
    public void delete(long id);
    public Persona findByNombre(String nombre);
}
