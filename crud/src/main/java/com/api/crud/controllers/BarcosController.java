package com.api.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.crud.models.BarcosModel;
import com.api.crud.services.BarcosService;

@RestController
@RequestMapping("/Barcos")
public class BarcosController {

    @Autowired
    private BarcosService barcosService;

    @GetMapping
    public List<BarcosModel> getBarcos() {
        return barcosService.getBarcos();
    }

    @PostMapping
    public BarcosModel saveBarco(@RequestBody BarcosModel barco) {
        return barcosService.saveBarco(barco);
    }

    @GetMapping(path = "/{barco_id}")
    public BarcosModel getBarcoById(@PathVariable("barco_id") long barco_id) {
        return barcosService.getById(barco_id);
    }

    @PutMapping(path = "/{barco_id}")
    public BarcosModel updateBarcoById(@RequestBody BarcosModel request, @PathVariable("barco_id") Long barco_id) {
        return barcosService.updateById(request, barco_id);
    }

    @DeleteMapping(path = "/{barco_id}")
    public String deleteById(@PathVariable("barco_id") Long barco_id) {
        boolean ok = barcosService.deleteBarco(barco_id);

        if (ok) {
            return "Barco con id " + barco_id + " eliminado";
        } else {
            return "Error, hubo un problema, no se puede eliminar el barco " + barco_id;
        }
    }
}
