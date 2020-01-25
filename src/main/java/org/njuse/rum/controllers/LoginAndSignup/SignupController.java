package org.njuse.rum.controllers.LoginAndSignup;

import org.njuse.rum.vo.LoginAndSignup.SignupForm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {
    @GetMapping("/signup")
    public String login() {
        return "xxx";
    }
}
