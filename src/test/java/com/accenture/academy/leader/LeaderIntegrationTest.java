package com.accenture.academy.leader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class LeaderIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "ADMIN")
    void postTest() throws Exception {
        LeaderDto leaderDto = new LeaderDto("Adamam", 22);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(
                        MockMvcRequestBuilders.post("http://localhost:8080/api/leaders")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(leaderDto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}
