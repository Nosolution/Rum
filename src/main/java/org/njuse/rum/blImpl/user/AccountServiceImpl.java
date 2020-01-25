package org.njuse.rum.blImpl.user;

import org.njuse.rum.bl.user.AccountService;
import org.njuse.rum.mappers.user.UserMapper;
import org.njuse.rum.po.user.UserPO;
import org.njuse.rum.vo.LoginAndSignup.SignupForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserMapper am;

    @Override
    public boolean hasUser(String username) {
        return am.findByUsername(username) != null;
    }

    @Override
    public void register(SignupForm signupForm) {
        UserPO userPO = new UserPO();
        userPO.setEmail(signupForm.getEmail());
        userPO.setPassword(signupForm.getPassword());
        userPO.setUsername(signupForm.getUsername());
        am.insertUser(userPO);
    }
}
