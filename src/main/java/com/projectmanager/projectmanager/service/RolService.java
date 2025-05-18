package com.projectmanager.projectmanager.service;

import com.projectmanager.projectmanager.model.Rol;
import com.projectmanager.projectmanager.respository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository){
        this.rolRepository=rolRepository;
    }

    public List<Rol> getAllRol(){
        return rolRepository.findAll();
    }

    public Rol createRol(Rol rol){
        return rolRepository.save(rol);
    }

    public Rol updateRol(Long id,Rol data){
        Rol rol =rolRepository.findById(id).orElseThrow(() -> new RuntimeException("Rol not found"));
        rol.setRol(data.getRol());

        return rolRepository.save(rol);
    }
}
