/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.demo.controller;

import com.tienda.demo.entity.Pais;
import com.tienda.demo.entity.Persona;
import com.tienda.demo.service.IPaisService;
import com.tienda.demo.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author XPC
 */
@Controller
public class PersonaController {
    @Autowired
    private IPersonaService personaService;
    
    @Autowired
    private IPaisService paisService;

    @GetMapping("/persona") /*url como se comunica controller con servicio*/
    public String index (Model model){ /*permite pasar variable al html*/
        List<Persona> listaPersona = personaService.getAllPersona();
        model.addAttribute("titulo","Tabla Personas");
        model.addAttribute("personas",listaPersona);
        return "personas";
    }
    @GetMapping("/personaN") /*url como se comunica controller con servicio*/
    public String crearPersona (Model model){ /*permite pasar variable al html*/
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", new Persona());
        model.addAttribute("paises",listaPaises);
        return "crear";
    }
    
    
    @PostMapping("/save") /*url como se comunica controller con servicio*/
    public String guardarPersona (@ModelAttribute Persona persona){ /*permite pasar variable al html*/
        personaService.savePersona(persona);
        return "redirect:/persona";
    }
    
    @GetMapping("/editPersona/{id}") /*url como se comunica controller con servicio*/
    public String editarPersona (@PathVariable("id") Long idPersona, Model model){ /*permite pasar variable al html*/
        Persona persona = personaService.getPersonaById(idPersona);
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", persona);
        model.addAttribute("paises",listaPaises);
        return "crear";
    }
    
    @GetMapping("/delete/{id}") /*url como se comunica controller con servicio*/
    public String editarPersona (@PathVariable("id") Long idPersona){ /*permite pasar variable al html*/
        personaService.delete(idPersona);
        return "redirect:/persona";
    }
}
