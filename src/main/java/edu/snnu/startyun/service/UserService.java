package edu.snnu.startyun.service;

import edu.snnu.startyun.entity.User;

import java.util.Map;

public interface UserService {

    Map<String, Object> userLogin(String openId);

    void userRegister(User user, String identity);

    boolean getUserById(Integer id, String identity);
}
