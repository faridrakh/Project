package com.brs.project.user.dao;

import com.brs.project.user.entity.User;

import java.util.List;

public interface UserDAO {
    User addUser(User user);
    String updateUser(User user);
    String deleteUser(String id);
    User getUser(String id);
    User getUser(String user,String password);
    User getUserByUserName(String value);
    List<User> getUserList();
    User getUserByEmail(String value);
}
