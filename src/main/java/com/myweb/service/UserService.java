package com.myweb.service;

import com.myweb.pojo.User;


public interface UserService {
    User getUserById(Integer id);
    Integer insertUser(User user);
    Integer getUserNumber();

}
