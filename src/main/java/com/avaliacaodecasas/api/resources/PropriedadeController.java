package com.avaliacaodecasas.api.resources;

import com.avaliacaodecasas.api.entities.Propriedade;
import com.avaliacaodecasas.api.entities.dto.PropriedadeDTO;
import com.avaliacaodecasas.api.services.PropriedadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/propriedades")
public class PropriedadeController {

    private PropriedadeService propriedadeService;

    public PropriedadeController(PropriedadeService propriedadeService){
        this.propriedadeService = propriedadeService;
    }

    @GetMapping("/{propriedadeId}")
    public ResponseEntity<PropriedadeDTO> getPropertyDetails(@PathVariable Integer propriedadeId){
        PropriedadeDTO propriedadeDTO = new PropriedadeDTO(propriedadeService.findById(propriedadeId));

        return ResponseEntity.ok().body(propriedadeDTO);
    }

    @PostMapping
    public ResponseEntity<Void> addNewProperty(@Valid @RequestBody Propriedade propriedade){

        return ResponseEntity.status(201).build();
    }
}
