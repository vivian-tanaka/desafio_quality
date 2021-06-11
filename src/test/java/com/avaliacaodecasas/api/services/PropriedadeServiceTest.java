package com.avaliacaodecasas.api.services;

import com.avaliacaodecasas.api.entities.Comodo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class PropriedadeServiceTest {

    private static PropriedadeService propriedadeService;
    private static HashMap<String,Double> bairros = new HashMap<>();

    @BeforeAll
    static void init(PropriedadeService service){
        propriedadeService = service;

        bairros.put("Saude",200.54);
        bairros.put("Paraiso",400.9);
        bairros.put("Santana",300.53);
        bairros.put("Liberdade",600.0);
        bairros.put("Morumbi",500.55);

        Comodo comodo1 = new Comodo("Suite1", 10.0,10.0);
        Comodo comodo2 = new Comodo("Suite2", 5.0,5.0);
        Comodo comodo3 = new Comodo("Suite3", 3.0,3.0);

    }

    @Test
    void shouldReturnPropertyTotalValue(){

    }

}
