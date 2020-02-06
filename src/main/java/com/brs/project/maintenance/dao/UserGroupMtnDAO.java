package com.brs.project.maintenance.dao;

import com.brs.project.maintenance.entity.UserGroupMtn;

import java.util.List;

public interface UserGroupMtnDAO {
    List<UserGroupMtn> getUserGroupMtnList();
    String getUserGroupMtnByCd(String cd);
}
