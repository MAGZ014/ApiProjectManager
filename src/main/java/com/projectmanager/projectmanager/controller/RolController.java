package com.projectmanager.projectmanager.controller;

import com.projectmanager.projectmanager.model.Rol;
import com.projectmanager.projectmanager.service.RolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rol")
public class RolController {

    private RolService rolService;
    public RolController(RolService rolService){
        this.rolService= rolService;
    }

    @GetMapping
    public List<Rol> rolList() {
        return rolService.getAllRol();
    }

    @PostMapping
    public Rol createRol(@RequestBody Rol rol) {
        return rolService.createRol(rol);
    }

    @PutMapping("/{id}")
    public Rol updateRol(@PathVariable Long id, @RequestBody Rol rol) {
        return rolService.updateRol(id, rol);
    }
}
