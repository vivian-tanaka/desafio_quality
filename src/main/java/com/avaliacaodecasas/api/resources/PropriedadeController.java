package com.avaliacaodecasas.api.resources;

import com.avaliacaodecasas.api.entities.Propriedade;
import com.avaliacaodecasas.api.entities.dto.PropriedadeDTO;
import com.avaliacaodecasas.api.services.PropriedadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/propriedades")
public class PropriedadeController {

    private PropriedadeService propriedadeService;

    public PropriedadeController(PropriedadeService propriedadeService){
        this.propriedadeService = propriedadeService;
    }

    @PostMapping
    public ResponseEntity<PropriedadeDTO> addNewProperty(@Valid @RequestBody Propriedade propriedade){
        PropriedadeDTO propriedadeDTO = propriedadeService.calculate(propriedade);
        return ResponseEntity.status(201).body(propriedadeDTO);
    }
}
