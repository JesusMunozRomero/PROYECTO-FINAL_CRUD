package com.api.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.exceptions.ResourceNotFoundException;
import com.api.crud.models.BarcosModel;
import com.api.crud.repositories.IBarcosRepository;

@Service
public class BarcosService {

    @Autowired
    IBarcosRepository barcosRepository;

    public List<BarcosModel> getBarcos() {
        List<BarcosModel> barcos = barcosRepository.findAll();
        if (barcos.isEmpty()) {
            throw new ResourceNotFoundException("No existen barcos");
        }
        return barcos;
    }

    public BarcosModel saveBarco(BarcosModel barco) {
        return barcosRepository.save(barco);
    }

    public BarcosModel getById(Long barco_id) {
        return barcosRepository.findById(barco_id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró ningún barco con el ID proporcionado"));
    }

    public BarcosModel updateById(BarcosModel request, Long barco_id) {
        if (barco_id == null) {
            throw new IllegalArgumentException("El ID del barco no puede ser nulo");
        }

        BarcosModel barco = barcosRepository.findById(barco_id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró ningún barco con el ID proporcionado"));

        barco.setSocio_id(request.getSocio_id());
        barco.setNumero_matricula(request.getNumero_matricula());
        barco.setNombre_barco(request.getNombre_barco());
        barco.setNumero_amarre(request.getNumero_amarre());
        barco.setCuota_amarre(request.getCuota_amarre());

        return barcosRepository.save(barco);
    }

    public Boolean deleteBarco(Long barco_id) {
        if (!barcosRepository.existsById(barco_id)) {
            throw new ResourceNotFoundException("No se encontró ningún barco con el ID proporcionado");
        }

        try {
            barcosRepository.deleteById(barco_id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
