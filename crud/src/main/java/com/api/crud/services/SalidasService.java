package com.api.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.exceptions.ResourceNotFoundException;
import com.api.crud.models.SalidasModel;
import com.api.crud.repositories.ISalidasRepository;

@Service
public class SalidasService {

    @Autowired
    private ISalidasRepository salidasRepository;
    
    public List<SalidasModel> getSalidas(){
        return salidasRepository.findAll();
    }
    
    public SalidasModel saveSalida(SalidasModel salida) {
        return salidasRepository.save(salida);
    }
    
    public SalidasModel getById(Long salida_id){
        return salidasRepository.findById(salida_id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró ninguna salida con el ID proporcionado"));
    }
    
    public SalidasModel updateById(SalidasModel request, Long salida_id) {
        if (salida_id == null) {
            throw new IllegalArgumentException("El ID de la salida no puede ser nulo");
        }
        
        SalidasModel salida = salidasRepository.findById(salida_id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró ninguna salida con el ID proporcionado"));
        
        salida.setBarco_id(request.getBarco_id());
        salida.setFecha_salida(request.getFecha_salida());
        salida.setHora_salida(request.getHora_salida());
        salida.setDestino(request.getDestino());
        salida.setPatron_id(request.getPatron_id());
        
        return salidasRepository.save(salida);
    }

    public Boolean deleteSalida(Long salida_id) {
        if (!salidasRepository.existsById(salida_id)) {
            throw new ResourceNotFoundException("No se encontró ninguna salida con el ID proporcionado");
        }
        salidasRepository.deleteById(salida_id);
        return true;
    }
}
