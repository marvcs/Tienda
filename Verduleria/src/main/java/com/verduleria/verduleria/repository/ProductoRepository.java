/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.verduleria.verduleria.repository;

import com.verduleria.verduleria.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author XPC
 */
@Repository
public interface ProductoRepository extends CrudRepository<Producto,Long>{
    
}
