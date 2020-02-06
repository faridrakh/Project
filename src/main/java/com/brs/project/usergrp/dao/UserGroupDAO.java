package com.brs.project.usergrp.dao;

import com.brs.project.usergrp.entity.UserGroup;

import java.util.List;

public interface UserGroupDAO {
    UserGroup addUserGrp(UserGroup userGrp);
    List<UserGroup> getUserGroupListByUserId(String userId);
}
