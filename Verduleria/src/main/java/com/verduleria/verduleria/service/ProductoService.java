/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.verduleria.verduleria.service;

import com.verduleria.verduleria.entity.Producto;
import com.verduleria.verduleria.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author XPC
 */
@Service
public class ProductoService implements IProductoService {
    @Autowired /*inyeccion de dependencias, conexion con repositorio*/
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProducto() {
        return (List<Producto>)productoRepository.findAll();    
    }

    @Override
    public Producto getProductoById(long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProducto(Producto prod) {
        productoRepository.save(prod);
    }

    @Override
    public void delete(long id) {
        productoRepository.deleteById(id); 
    }
}
