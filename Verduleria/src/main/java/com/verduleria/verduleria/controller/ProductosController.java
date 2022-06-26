/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.verduleria.verduleria.controller;

import com.verduleria.verduleria.entity.Locales;
import com.verduleria.verduleria.entity.Producto;
import com.verduleria.verduleria.service.ILocalService;
import com.verduleria.verduleria.service.IProductoService;
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
public class ProductosController {
    @Autowired
    private IProductoService productoService;
    
    @Autowired
    private ILocalService localService;

    @GetMapping("/producto") /*url como se comunica controller con servicio*/
    public String index (Model model){ /*permite pasar variable al html*/
        List<Producto> listaProducto = productoService.getAllProducto();
        model.addAttribute("titulo","Tabla Productos");
        model.addAttribute("productos",listaProducto);
        return "productos";
    }
    @GetMapping("/productoN") /*url como se comunica controller con servicio*/
    public String crearProducto (Model model){ /*permite pasar variable al html*/
        List<Locales> listaLocales = localService.listCountry();
        model.addAttribute("producto", new Producto());
        model.addAttribute("local",listaLocales);
        return "crear";
    }
    
    
    @PostMapping("/save") /*url como se comunica controller con servicio*/
    public String guardarPersona (@ModelAttribute Producto prod){ /*permite pasar variable al html*/
        productoService.saveProducto(prod);
        return "redirect:/producto";
    }
    
    @GetMapping("/editProducto/{producto_id}") /*url como se comunica controller con servicio*/
    public String editarPersona (@PathVariable("producto_id") Long idProducto, Model model){ /*permite pasar variable al html*/
        Producto producto = productoService.getProductoById(idProducto);
        List<Locales> listaLocales = localService.listCountry();
        model.addAttribute("producto", producto);
        model.addAttribute("local",listaLocales);
        return "crear";
    }
    
    @GetMapping("/delete/{producto_id}") /*url como se comunica controller con servicio*/
    public String deleteProducto (@PathVariable("producto_id") Long idProducto){ /*permite pasar variable al html*/
        productoService.delete(idProducto);
        return "redirect:/producto";
    }
}
