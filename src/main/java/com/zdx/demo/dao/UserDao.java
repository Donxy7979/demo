package com.zdx.demo.dao;

import com.zdx.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface UserDao {
    User selectUserByName(String userName);
    User selectUserByNameAndPassword(User user);
    int createUser(User user);
    int updateUser(User user);
}
