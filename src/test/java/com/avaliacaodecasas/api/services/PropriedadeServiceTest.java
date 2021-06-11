package com.avaliacaodecasas.api.services;

import com.avaliacaodecasas.api.entities.Comodo;
import com.avaliacaodecasas.api.entities.Propriedade;
import com.avaliacaodecasas.api.entities.dto.PropriedadeDTO;
import com.avaliacaodecasas.api.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
public class PropriedadeServiceTest {

    @InjectMocks
    private PropriedadeService propriedadeService;
    private Propriedade propriedade;
    private HashMap<String,Double> bairros = new HashMap<>();

    @BeforeEach
    void init(){

        bairros.put("Saude",200.55);
        bairros.put("Paraiso",400.9);
        bairros.put("Santana",300.53);
        bairros.put("Liberdade",600.0);
        bairros.put("Morumbi",500.55);

        Comodo comodo1 = new Comodo("Suite1", 10.0,10.0);
        Comodo comodo2 = new Comodo("Suite2", 5.0,5.0);
        Comodo comodo3 = new Comodo("Suite3", 3.0,3.0);

        propriedade = new Propriedade();
        propriedade.setProp_name("Prop1");
        propriedade.setProp_district("Saude");
        propriedade.getComodos().addAll(Arrays.asList(comodo1,comodo2,comodo3));
    }

    @Test
    void shouldReturnPropertyTotalValue(){
        Double valor = propriedadeService.calculate(propriedade).getValorDaPropriedade();

        Assertions.assertEquals(134.00*200.55,valor);
    }

    @Test
    void shouldReturnPropertyDto(){
        propriedade.setProp_district("Paraiso");
        PropriedadeDTO propriedadeDTO = propriedadeService.calculate(propriedade);

        Assertions.assertEquals(PropriedadeDTO.class,propriedadeDTO.getClass());
    }

    @Test
    void shouldThrowObjectNotFoundExceptionWhenUsingUnregisteredDistrict(){
        propriedade.setProp_district("Bairro Desconhecido");

        Assertions.assertThrows(ObjectNotFoundException.class,() -> propriedadeService.calculate(propriedade));
    }

    @Test
    void shouldReturnBiggestRoom(){
        PropriedadeDTO propriedadeDTO = propriedadeService.calculate(propriedade);

        Assertions.assertEquals("Suite1",propriedadeDTO.getMaiorComodo().getRoom_name());
    }

    @Test
    void shouldCalculateTotalArea(){
        PropriedadeDTO propriedadeDTO = propriedadeService.calculate(propriedade);

        Assertions.assertEquals(100.00,propriedadeDTO.getComodos().get(0).getAreaDoComodo());
        Assertions.assertEquals(25.00,propriedadeDTO.getComodos().get(1).getAreaDoComodo());
        Assertions.assertEquals(9.00,propriedadeDTO.getComodos().get(2).getAreaDoComodo());
        Assertions.assertEquals(134.00,propriedadeDTO.getAreaTotal());
    }

}
