package org.njuse.rum.bl.user;


import org.njuse.rum.vo.LoginAndSignup.SignupForm;

public interface AccountService {
    boolean hasUser(String username);

    void register(SignupForm userPO);
}
