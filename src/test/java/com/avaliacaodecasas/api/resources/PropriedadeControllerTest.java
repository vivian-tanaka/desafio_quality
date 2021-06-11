package com.avaliacaodecasas.api.resources;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropriedadeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static String request;

    @BeforeAll
    static void init(){
        request = "{\n" +
                "    \"prop_name\": \"Mehas 123 dasdqwe23\",\n" +
                "    \"prop_district\": \"Saude\",\n" +
                "    \"comodos\": [\n" +
                "        {\n" +
                "            \"room_name\": \"Suite Master\",\n" +
                "            \"room_width\": \"4.5\",\n" +
                "            \"room_length\": \"4\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_name\": \"Banheiro\",\n" +
                "            \"room_width\": \"3\",\n" +
                "            \"room_length\": \"3\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_name\": \"Cozinha\",\n" +
                "            \"room_width\": \"2\",\n" +
                "            \"room_length\": \"3\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_name\": \"Sala\",\n" +
                "            \"room_width\": \"3.5\",\n" +
                "            \"room_length\": \"4.5\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    @Test
    void shouldReturnStatusCreatedAndTotalValueO() throws Exception {
        this.mockMvc.perform(
                post("/propriedades")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.valorDaPropriedade").value(9776.81));
    }
}
