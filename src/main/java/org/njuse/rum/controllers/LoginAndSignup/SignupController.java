package org.njuse.rum.controllers.LoginAndSignup;

import org.njuse.rum.bl.user.AccountService;
import org.njuse.rum.vo.LoginAndSignup.Msg;
import org.njuse.rum.vo.LoginAndSignup.SignupForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {
    public static final String EXIST_MSG = "用户名已存在";

    @Autowired
    AccountService as;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupForm signupForm) {
        // 用户名已存在
        if (as.hasUser(signupForm.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Msg(EXIST_MSG));
        }
        as.register(signupForm);
        return ResponseEntity.ok("");
    }
}
