package com.api.crud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.crud.exceptions.ResourceNotFoundException;
import com.api.crud.models.SociosModel;
import com.api.crud.services.SociosService;

@RestController
@RequestMapping("/Socios")
public class SociosController {

    @Autowired
    private SociosService sociosService;
    
    @GetMapping
    public ArrayList<SociosModel> getSocios(){
        return this.sociosService.getSocios();
    }
    
    @PostMapping
    public SociosModel saveSocio(@RequestBody SociosModel socio) {
        return sociosService.saveSocio(socio);
    }
    
    @GetMapping(path="/{socio_id}")
    public Optional<SociosModel> getSocioById(@PathVariable("socio_id") long socio_id){
        return Optional.ofNullable(this.sociosService.getById(socio_id)
                .orElseThrow(() -> new ResourceNotFoundException("Elige un id de socio valido")));
    }
    
    @PutMapping(path="/{socio_id}")
    public SociosModel updateSocioById(@RequestBody SociosModel request, @PathVariable("socio_id") Long socio_id) {
        return this.sociosService.updateById(request, socio_id);
    }
    
    @DeleteMapping(path="/{socio_id}")
    public String deleteById(@PathVariable("socio_id") Long socio_id) {
        if (this.sociosService.deleteSocio(socio_id)) {
            return "Socio con id " + socio_id + " eliminado";
        } else {
            return "Error, hubo un problema, no se puede eliminar el socio " + socio_id;
        }
    }
}
