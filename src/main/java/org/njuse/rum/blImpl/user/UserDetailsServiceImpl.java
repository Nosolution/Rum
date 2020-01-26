package org.njuse.rum.blImpl.user;

import org.njuse.rum.mappers.user.UserMapper;
import org.njuse.rum.po.user.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service("self-definition")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserPO u = userMapper.findByUsername(username);
        Collection<? extends GrantedAuthority> n = new ArrayList<>();
        UserDetails res = new User(u.getUsername(), u.getPassword(), n);
        return res;
    }
}
