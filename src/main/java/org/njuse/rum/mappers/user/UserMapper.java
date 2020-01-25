package org.njuse.rum.mappers.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.njuse.rum.po.user.UserPO;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("SELECT * FROM tbl_user WHERE username = #{username}")
    UserPO findByUsername(String username);

    void insertUser(UserPO userPO);
}