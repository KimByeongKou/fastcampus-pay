package com.fastcampuspay.banking;

import com.fastcampuspay.banking.adapter.in.web.RegisterBankAccountRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegisterBankAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    public void testRegisterMembership() throws Exception {
        RegisterBankAccountRequest request = new RegisterBankAccountRequest("1", "국민은행", "1234567890", true);
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/banking/account/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(request))
                )
                .andExpect(MockMvcResultMatchers.status().isOk());
                // .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(expect)));
    }
}
