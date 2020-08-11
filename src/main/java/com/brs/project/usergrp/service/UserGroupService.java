package com.brs.project.usergrp.service;

import com.brs.project.usergrp.entity.UserGroup;
import com.sytan.base.lib.ApplicationException;

public interface UserGroupService {
    void addUserGrp(String userId) throws ApplicationException;
    UserGroup getUserGrp(String userId) throws ApplicationException;
}
