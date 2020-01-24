package org.njuse.rum.controllers.LoginAndSignup;

import org.njuse.rum.vo.user.LoginAndSignup.LoginForm;
import org.njuse.rum.vo.user.LoginAndSignup.SignupForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {
    @PostMapping("/signup")
    public String login(@RequestBody SignupForm signupForm){
        return "username=" + signupForm.getUsername() + " password=" + signupForm.getPassword() + " email=" + signupForm.getEmail();
    }
}
