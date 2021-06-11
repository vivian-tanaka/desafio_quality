package com.avaliacaodecasas.api.services;

import com.avaliacaodecasas.api.entities.Propriedade;
import com.avaliacaodecasas.api.entities.dto.PropriedadeDTO;
import com.avaliacaodecasas.api.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

@Service
public class PropriedadeService {

    private HashMap<String,Double> bairros = new HashMap<>();

    public PropriedadeService(){

        bairros.put("Saude",200.55);
        bairros.put("Paraiso",400.9);
        bairros.put("Santana",300.53);
        bairros.put("Liberdade",600.0);
        bairros.put("Morumbi",500.55);
    }

    public PropriedadeDTO calculate(Propriedade propriedade){

        PropriedadeDTO propriedadeDTO = new PropriedadeDTO(propriedade);
        Double totalValue = getTotalValue(propriedadeDTO.getAreaTotal(),propriedadeDTO.getProp_district());

        DecimalFormat df =  new DecimalFormat("#.00",
                new DecimalFormatSymbols(Locale.ENGLISH));
        propriedadeDTO.setValorDaPropriedade(Double.valueOf(df.format(totalValue)));

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
