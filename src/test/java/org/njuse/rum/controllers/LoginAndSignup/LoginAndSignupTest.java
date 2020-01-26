package org.njuse.rum.controllers.LoginAndSignup;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

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
        // 测试注册
        // 要先确保数据库中没有testSignup的用户
        RequestBuilder request = post("/signup")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content("{\"username\":\"testSignup\",\"password\":\"123qwe\",\"email\":\"456@qq.com\"}");
        mockMvc.perform(request)
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    public void test2() throws Exception {
        // 测试注册重名用户
        // 要先确保数据库中没有名为exist的用户
        RequestBuilder request = post("/signup")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content("{\"username\":\"exist\",\"password\":\"123qwe\",\"email\":\"456@qq.com\"}");
        mockMvc.perform(request)
                .andExpect(status().is(HttpStatus.OK.value()));

        request = post("/signup")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content("{\"username\":\"exist\",\"password\":\"123qwe\",\"email\":\"456@qq.com\"}");
        mockMvc.perform(request)
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void test3() throws Exception {
        // 测试密码加密
        // 账户为encry的密码是经过加密的
        RequestBuilder request = post("/signup")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content("{\"username\":\"encry\",\"password\":\"123qwe\",\"email\":\"456@qq.com\"}");
        mockMvc.perform(request)
                .andExpect(status().is(HttpStatus.OK.value()));
        request = post("/login")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content("{\"username\":\"encry\",\"password\":\"123qwe\"}");
        mockMvc.perform(request)
                .andExpect(status().is(HttpStatus.OK.value()));
    }

}
