package com.api.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.crud.exceptions.ResourceNotFoundException;
import com.api.crud.models.SalidasModel;
import com.api.crud.services.SalidasService;

@RestController
@RequestMapping("/Salidas")
public class SalidasController {

    @Autowired
    private SalidasService salidasService;
    
    @GetMapping
    public List<SalidasModel> getSalidas() {
        List<SalidasModel> salidas = salidasService.getSalidas();
        if (salidas.isEmpty()) {
            throw new ResourceNotFoundException("No existen Salidas");
        }
        return salidas;
    }
    
    @PostMapping
    public SalidasModel saveSalida(@RequestBody SalidasModel salida) {
        return salidasService.saveSalida(salida);
    }
    
    @GetMapping(path="/{salida_id}")
    public SalidasModel getSalidaById(@PathVariable("salida_id") long salida_id) {
        return (SalidasModel) salidasService.getById(salida_id);
    }
    
    @PutMapping(path="/{salida_id}")
    public SalidasModel updateSalidaById(@RequestBody SalidasModel request, @PathVariable("salida_id") Long salida_id) {
        return salidasService.updateById(request, salida_id);
    }
    
    @DeleteMapping(path="/{salida_id}")
    public String deleteById(@PathVariable("salida_id") Long salida_id) {
        boolean ok = salidasService.deleteSalida(salida_id);
        if (ok) {
            return "Salida con id " + salida_id + " eliminada";
        } else {
            throw new ResourceNotFoundException("No se encontró ninguna salida con el ID proporcionado: " + salida_id);
        }
    }
}
