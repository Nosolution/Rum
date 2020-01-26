package org.njuse.rum.blImpl.user;

import org.njuse.rum.bl.user.AccountService;
import org.njuse.rum.mappers.user.UserMapper;
import org.njuse.rum.po.user.UserPO;
import org.njuse.rum.vo.LoginAndSignup.SignupForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean hasUser(String username) {
        return userMapper.findByUsername(username) != null;
    }

    @Override
    public void register(SignupForm signupForm) {
        UserPO userPO = new UserPO();
        userPO.setEmail(signupForm.getEmail());
        // 加密密码
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userPO.setPassword(bCryptPasswordEncoder.encode(signupForm.getPassword()));

        userPO.setUsername(signupForm.getUsername());
        userMapper.insertUser(userPO);
    }
}
