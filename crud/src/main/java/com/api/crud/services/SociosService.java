package com.api.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.exceptions.ResourceNotFoundException;
import com.api.crud.models.SociosModel;
import com.api.crud.repositories.ISociosRepository;

@Service
public class SociosService {

    @Autowired
    ISociosRepository sociosRepository;
    
    public ArrayList<SociosModel> getSocios(){
        return (ArrayList<SociosModel>) sociosRepository.findAll();
    }
    
    public SociosModel saveSocio(SociosModel socio) {
        return sociosRepository.save(socio);
    }
    
    public Optional<SociosModel> getById(Long socio_id){
        return sociosRepository.findById(socio_id);
    }
    
    public SociosModel updateById(SociosModel request, Long socio_id) {
        SociosModel socio = sociosRepository.findById(socio_id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró ningún socio con el ID proporcionado"));
        
        socio.setNombre(request.getNombre());
        socio.setApellido(request.getApellido());
        socio.setDireccion(request.getDireccion());
        socio.setTelefono(request.getTelefono());
        socio.setEmail(request.getEmail());
        
        return sociosRepository.save(socio);
    }

    public Boolean deleteSocio(Long socio_id) {
        if (!sociosRepository.existsById(socio_id)) {
            throw new ResourceNotFoundException("No se encontró ningún socio con el ID proporcionado: " + socio_id);
        }
        sociosRepository.deleteById(socio_id);
        return true;
    }
}
