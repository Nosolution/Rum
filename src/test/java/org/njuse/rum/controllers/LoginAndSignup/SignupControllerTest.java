package org.njuse.rum.controllers.LoginAndSignup;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

@SpringBootTest
@AutoConfigureMockMvc
public class SignupControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSignup() throws Exception {
        RequestBuilder request = post("/signup")
                .contentType(APPLICATION_JSON)
                .content("{\"username\":\"testUsername\",\"password\":\"testPassword\",\"email\":\"123@qq.com\"}");
        mockMvc.perform(request)
                .andExpect(content().string("username=testUsername password=testPassword email=123@qq.com"));
    }
}
