package com.avaliacaodecasas.api.services;

import com.avaliacaodecasas.api.entities.Comodo;
import com.avaliacaodecasas.api.entities.Propriedade;
import com.avaliacaodecasas.api.entities.dto.PropriedadeDTO;
import com.avaliacaodecasas.api.repositories.ComodoRepository;
import com.avaliacaodecasas.api.repositories.PropriedadeRepository;
import com.avaliacaodecasas.api.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropriedadeService {

    private PropriedadeRepository propriedadeRepository;
    private ComodoRepository comodoRepository;
    private HashMap<String,Double> bairros = new HashMap<>();

    public PropriedadeService(PropriedadeRepository propriedadeRepository, ComodoRepository comodoRepository){
        this.propriedadeRepository = propriedadeRepository;
        this.comodoRepository = comodoRepository;

        bairros.put("Saude",200.54);
        bairros.put("Paraiso",400.9);
        bairros.put("Santana",300.53);
        bairros.put("Liberdade",600.0);
        bairros.put("Morumbi",500.55);
    }

    public Propriedade findById(Integer propriedadeId) {
        if(!propriedadeRepository.findById(propriedadeId).isPresent()){
            throw new ObjectNotFoundException("Propriedade de id: "+propriedadeId+" não encontradoa");
        }

        return propriedadeRepository.findById(propriedadeId).get();
    }

    public PropriedadeDTO getPropertyDetails(Integer propriedadeId) {
        PropriedadeDTO propriedadeDetails = new PropriedadeDTO(findById(propriedadeId));

        Double valorBairro = bairros.get(propriedadeDetails.getProp_district());
        Double valorTotal = propriedadeDetails.getAreaTotal()*valorBairro;

        propriedadeDetails.setValorDaPropriedade(valorTotal);

        return propriedadeDetails;
    }

    public void savePropriedade(Propriedade propriedade){
        for(Comodo comodo : propriedade.getComodos()){
            comodo.setPropriedade(propriedade);
        }

        propriedadeRepository.save(propriedade);
    }

    public List<PropriedadeDTO> findAllProperties() {
        List<Propriedade> propriedades = propriedadeRepository.findAll();
        List<PropriedadeDTO> propriedadeDTOS = propriedades
                .stream()
                .map(propriedade -> new PropriedadeDTO(propriedade))
                .collect(Collectors.toList());

        for(PropriedadeDTO prop : propriedadeDTOS){
            Double valorBairro = bairros.get(prop.getProp_district());
            Double valorTotal = prop.getAreaTotal()*valorBairro;

            prop.setValorDaPropriedade(valorTotal);
        }

        return propriedadeDTOS;
    }
}
