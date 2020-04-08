package com.brs.project.maintenance.dao;

import com.brs.project.maintenance.entity.UserGroupMtn;
import com.sytan.base.lib.ApplicationException;

import java.util.List;

public interface UserGroupMtnDAO {
    List<UserGroupMtn> getUserGroupMtnList() throws ApplicationException, ApplicationException;
    String getUserGroupMtnByCd(String cd) throws ApplicationException;
}
