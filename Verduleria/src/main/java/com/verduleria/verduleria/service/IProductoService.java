/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.verduleria.verduleria.service;
import com.verduleria.verduleria.entity.Producto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author XPC
 */
@Service
public interface IProductoService {
    public List<Producto> getAllProducto();
    public Producto getProductoById(long id);
    public void saveProducto(Producto producto);
    public void delete(long id);
}
