package com.brs.project.user.service;

import com.brs.project.common.helper.CommonConstants;
import com.brs.project.common.helper.CommonUtils;
import com.brs.project.maintenance.dao.UserGroupMtnDAO;
import com.brs.project.user.dao.UserDAO;
import com.brs.project.user.entity.User;
import com.brs.project.usergrp.dao.UserGroupDAO;
import com.brs.project.usergrp.entity.UserGroup;
import com.sytan.base.lib.ApplicationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private UserGroupMtnDAO userGroupMtnDAO;
    private UserGroupDAO userGroupDAO;
    private final CommonUtils commonUtils  = new CommonUtils();

    public UserServiceImpl(UserDAO userDAO, UserGroupMtnDAO userGroupMtnDAO, UserGroupDAO userGroupDAO){
        this.userDAO = userDAO;
        this.userGroupMtnDAO = userGroupMtnDAO;
        this.userGroupDAO = userGroupDAO;
    }

    @Override
    public User addUser(User user) throws ApplicationException {
        User newUser;
        String uid = commonUtils.generateUUID();
        String gid = commonUtils.generateUUID();
        user.setId(uid);
        user.setCreateBy(uid);
        user.setDtCreate(commonUtils.generateDate());

        UserGroup userGroupModel = new UserGroup();
        String mtGrpId = userGroupMtnDAO.getUserGroupMtnByCd(CommonConstants.UL1_CODE);
        userGroupModel.setId(gid);
        userGroupModel.setMtGrpId(mtGrpId);
        userGroupDAO.addUserGrp(userGroupModel);

        user.setUserGrpId(gid);
        //user.setUserGroup(userGroupModel);
        newUser = userDAO.addUser(user);
        return newUser;
    }

    @Override
    public String updateUser(User user) {
        user.setDtUpdate(commonUtils.generateDate());
        user.setUpdateBy(user.getId());
        return userDAO.updateUser(user);
    }

    @Override
    public String deleteUser(String id) {
        return userDAO.deleteUser(id);
    }

    @Override
    public User getUser(String id) {
        return userDAO.getUser(id);
    }

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public User getUserByUserName(String username) {
        User user = userDAO.getUserByUserName(username);
        if (null != user) {
            return user;
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userDAO.getUserByEmail(email);
        if (null != user) {
            return user;
        }
        return null;

    }
}
