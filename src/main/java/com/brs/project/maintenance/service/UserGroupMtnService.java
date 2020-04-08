package com.brs.project.maintenance.service;

import com.brs.project.maintenance.entity.UserGroupMtn;
import com.sytan.base.lib.ApplicationException;

import java.util.List;

public interface UserGroupMtnService {
    List<UserGroupMtn> getUserGroupMtnList() throws ApplicationException;
}
