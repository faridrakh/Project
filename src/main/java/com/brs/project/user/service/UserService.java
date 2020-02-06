package com.brs.project.user.service;

import com.brs.project.common.model.DataContainer;
import com.brs.project.user.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    String updateUser(User user);
    String deleteUser(String id);
    User getUser(String id);
    List<User> getUserList();
    User getUserByUserName(String username);
    User getUserByEmail(String email);
}
