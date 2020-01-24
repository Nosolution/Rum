package org.njuse.rum.controllers.LoginAndSignup;

import org.njuse.rum.vo.user.LoginAndSignup.LoginForm;
import org.njuse.rum.vo.user.LoginAndSignup.SignupForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping("/login")
    public String login(@RequestBody LoginForm loginForm){
        return "username=" + loginForm.getUsername() + " password=" + loginForm.getPassword();
    }
}
