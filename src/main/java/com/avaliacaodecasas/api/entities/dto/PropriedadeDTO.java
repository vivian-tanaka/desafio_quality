package com.avaliacaodecasas.api.entities.dto;

import com.avaliacaodecasas.api.entities.Comodo;
import com.avaliacaodecasas.api.entities.Propriedade;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PropriedadeDTO {

    private Integer id;

    private String prop_name;

    private String prop_district;

    private List<Comodo> comodos = new ArrayList<>();

    private Double valorDaPropriedade;

    public PropriedadeDTO(){}

    public PropriedadeDTO(Propriedade propriedade){
        this.id = propriedade.getId();
        this.prop_name = propriedade.getProp_name();
        this.prop_district = propriedade.getProp_district();
        this.comodos.addAll(propriedade.getComodos());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public String getProp_district() {
        return prop_district;
    }

    public void setProp_district(String prop_district) {
        this.prop_district = prop_district;
    }

    public List<Comodo> getComodos() {
        return comodos;
    }

    public void setComodos(List<Comodo> comodos) {
        this.comodos = comodos;
    }

    public Double getValorDaPropriedade() {
        return valorDaPropriedade;
    }

    public void setValorDaPropriedade(Double valorDaPropriedade) {
        this.valorDaPropriedade = valorDaPropriedade;
    }

    public Double getAreaTotal(){
        Double totalArea = 0.0;
        for(Comodo comodo : comodos){
            totalArea += comodo.getAreaDoComodo();
        }

        return totalArea;
    }

    public Comodo getMaiorComodo(){
        Comodo comodo = comodos
                .stream()
                .max(Comparator.comparing(Comodo::getAreaDoComodo))
                .get();

        return comodo;
    }
}
