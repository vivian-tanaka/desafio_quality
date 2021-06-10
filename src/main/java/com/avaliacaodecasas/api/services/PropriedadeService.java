package com.avaliacaodecasas.api.services;

import com.avaliacaodecasas.api.entities.Propriedade;
import com.avaliacaodecasas.api.repositories.ComodoRepository;
import com.avaliacaodecasas.api.repositories.PropriedadeRepository;
import com.avaliacaodecasas.api.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PropriedadeService {

    private PropriedadeRepository propriedadeRepository;
    private ComodoRepository comodoRepository;

    public PropriedadeService(PropriedadeRepository propriedadeRepository, ComodoRepository comodoRepository){
        this.propriedadeRepository = propriedadeRepository;
        this.comodoRepository = comodoRepository;
    }

    public Propriedade findById(Integer propriedadeId) {
        if(propriedadeRepository.findById(propriedadeId).isPresent()){
            throw new ObjectNotFoundException("Propriedade de id: "+propriedadeId+" não encontradoa");
        }

        return propriedadeRepository.findById(propriedadeId).get();
    }
}
