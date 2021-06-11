package com.avaliacaodecasas.api.services;

import com.avaliacaodecasas.api.entities.Propriedade;
import com.avaliacaodecasas.api.entities.dto.PropriedadeDTO;
import com.avaliacaodecasas.api.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PropriedadeService {

    private HashMap<String,Double> bairros = new HashMap<>();

    public PropriedadeService(){

        bairros.put("Saude",200.54);
        bairros.put("Paraiso",400.9);
        bairros.put("Santana",300.53);
        bairros.put("Liberdade",600.0);
        bairros.put("Morumbi",500.55);
    }

    public PropriedadeDTO savePropriedade(Propriedade propriedade){

        PropriedadeDTO propriedadeDTO = new PropriedadeDTO(propriedade);
        Double totalValue = getTotalValue(propriedadeDTO.getAreaTotal(),propriedadeDTO.getProp_district());
        propriedadeDTO.setValorDaPropriedade(totalValue);

       return propriedadeDTO;
    }

    private Double getTotalValue(Double area, String district){
        if(bairros.containsKey(district)){
            Double districtValue = bairros.get(district);
            return districtValue * area;
        }else{
            throw new ObjectNotFoundException("Bairro "+district+" não cadastrado");
        }

    }


}
