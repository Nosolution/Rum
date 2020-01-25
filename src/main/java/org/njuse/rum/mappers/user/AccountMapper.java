package org.njuse.rum.mappers.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.njuse.rum.po.user.UserPO;

@Mapper
public interface AccountMapper {
    @Select("SELECT username, password, email FROM tbl_user WHERE username = #{username}")
    UserPO findByUsername(String username);
}