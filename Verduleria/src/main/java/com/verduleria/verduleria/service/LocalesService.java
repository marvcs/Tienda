/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.verduleria.verduleria.service;

import com.verduleria.verduleria.entity.Locales;
import com.verduleria.verduleria.repository.LocalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author XPC
 */
@Service
public class LocalesService implements ILocalService{
    @Autowired
    private LocalRepository localRepository;
    
    @Override
    public List<Locales> listCountry() {
        return (List<Locales>)localRepository.findAll();
    }
}
