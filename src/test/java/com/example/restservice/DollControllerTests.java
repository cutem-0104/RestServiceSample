package com.example.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DollControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllDolls() throws Exception {
        this.mockMvc.perform(get("/dolls")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].name").exists())
                .andExpect(jsonPath("$[0].type").exists())
                .andExpect(jsonPath("$[0].star").exists())
                .andExpect(jsonPath("$[0].productionMinute").exists())
                .andExpect(jsonPath("$[0].linkUrl").exists())
                .andExpect(jsonPath("$[0].howToGet").exists())
                .andExpect(jsonPath("$[0].imageUrl").exists());
    }

}

