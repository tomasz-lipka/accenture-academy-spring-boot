package com.accenture.academy.leader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class LeaderIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    LeaderService leaderService;

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

    @Test
    @WithMockUser(roles = "ADMIN")
    void deleteTest() throws Exception {
        LeaderDto leaderDto = new LeaderDto("Ggzrzr", 22);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(
                        MockMvcRequestBuilders.post("http://localhost:8080/api/leaders")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(leaderDto)));

        int sizeOfLeaderList = leaderService.getAllLeaders().size();
        mockMvc.perform(
                        MockMvcRequestBuilders.delete("http://localhost:8080/api/leaders/" + sizeOfLeaderList)
                                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(204));

        int sizeOfLeaderListAfterDelete = leaderService.getAllLeaders().size();
        assertEquals(sizeOfLeaderListAfterDelete + 1, sizeOfLeaderList);
    }
}
