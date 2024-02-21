package com.nhnacademy.edu.springboot.Account.domain.adapter.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springboot.Account.domain.Account;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @Order(1)
    void testGetAccounts() throws Exception {
        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].number", equalTo("me")));
    }

    @Test
    @Order(2)
    void testGetAccount() throws Exception {
        mockMvc.perform(get("/accounts/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.number", equalTo("me")));
    }

    @Test
    @Order(3)
    void testCreateAccount() throws Exception {
        Account input = new Account(3L, "Manty", 100);
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/accounts").content(objectMapper.writeValueAsString(input))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.number", equalTo("Manty")))
                .andExpect(jsonPath("$.balance", equalTo(100)));
    }

    @Test
    @Order(4)
    void testDeleteAccount() throws Exception {
        mockMvc.perform(delete("/accounts/{id}", 3L))
                .andExpect(status().isOk());
    }

}