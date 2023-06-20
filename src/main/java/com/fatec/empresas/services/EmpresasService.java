package com.fatec.empresas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.empresas.entities.Empresas;
import com.fatec.empresas.repositories.EmpresasRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpresasService {
    
    @Autowired
    private EmpresasRepository empresasRepository;

    public Empresas getEmpresasById(int id) {
        return empresasRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cliente não encontrado"));
    }

    public List<Empresas> getEmpresas() {
        return empresasRepository.findAll();
    }

   

    public Empresas save(Empresas empresas) {
        return empresasRepository.save(empresas);
    }


}
