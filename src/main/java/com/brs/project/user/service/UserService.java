package com.brs.project.user.service;

import com.brs.project.common.model.DataContainer;
import com.brs.project.user.entity.User;
import com.sytan.base.lib.ApplicationException;

import java.util.List;

public interface UserService {
    User addUser(User user) throws ApplicationException;
    String updateUser(User user);
    String deleteUser(String id);
    User getUser(String id);
    List<User> getUserList();
    User getUserByUserName(String username);
    User getUserByEmail(String email);
}
