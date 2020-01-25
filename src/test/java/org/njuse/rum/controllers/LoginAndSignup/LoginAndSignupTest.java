package org.njuse.rum.controllers.LoginAndSignup;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.njuse.rum.config.JwtAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginAndSignupTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test1() throws Exception {
        RequestBuilder request = post("/login")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content("{\"username\":\"root\",\"password\":\"qweasdzx\"}");
        mockMvc.perform(request)
                .andExpect(content().string("{\"msg\":\"" + JwtAuthenticationEntryPoint.WRONG_MSG + "\"}\n"))
                .andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));
    }

    @Test
    public void test2() throws Exception {
        RequestBuilder request = post("/login")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content("{\"username\":\"root\",\"password\":\"qweasdzxc\"}");
        mockMvc.perform(request)
                .andExpect(status().is(HttpStatus.OK.value()));

    }

    @Test
    public void test3() throws Exception {
        RequestBuilder request = post("/signup")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content("{\"username\":\"testSignup\",\"password\":\"123qwe\",\"email\":\"456@qq.com\"}");
        mockMvc.perform(request)
                .andExpect(status().is(HttpStatus.OK.value()));

    }
}
