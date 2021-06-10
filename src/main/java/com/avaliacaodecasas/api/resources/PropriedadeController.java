package com.avaliacaodecasas.api.resources;

import com.avaliacaodecasas.api.entities.Propriedade;
import com.avaliacaodecasas.api.entities.dto.PropriedadeDTO;
import com.avaliacaodecasas.api.services.PropriedadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/propriedades")
public class PropriedadeController {

    private PropriedadeService propriedadeService;

    public PropriedadeController(PropriedadeService propriedadeService){
        this.propriedadeService = propriedadeService;
    }

    @GetMapping
    public ResponseEntity<List<PropriedadeDTO>> getAllProperties(){
        return ResponseEntity.ok().body(propriedadeService.findAllProperties());
    }

    @GetMapping("/{propriedadeId}")
    public ResponseEntity<PropriedadeDTO> getPropertyDetails(@PathVariable Integer propriedadeId){
        return ResponseEntity.ok().body(propriedadeService.getPropertyDetails(propriedadeId));
    }

    @PostMapping
    public ResponseEntity<Void> addNewProperty(@Valid @RequestBody Propriedade propriedade){
        propriedadeService.savePropriedade(propriedade);
        return ResponseEntity.status(201).build();
    }
}
