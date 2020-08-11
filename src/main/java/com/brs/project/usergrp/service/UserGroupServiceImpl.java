package com.brs.project.usergrp.service;

import com.brs.project.common.helper.CommonConstants;
import com.brs.project.common.helper.CommonUtils;
import com.brs.project.maintenance.dao.UserGroupMtnDAO;
import com.brs.project.usergrp.dao.UserGroupDAO;
import com.brs.project.usergrp.entity.UserGroup;
import com.sytan.base.lib.ApplicationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserGroupServiceImpl implements UserGroupService{
    private UserGroupDAO userGroupDAO;
    private UserGroupMtnDAO userGroupMtnDAO;

    private final CommonUtils commonUtils = new CommonUtils();

    public UserGroupServiceImpl(UserGroupDAO userGroupDAO,UserGroupMtnDAO userGroupMtnDAO){
        this.userGroupDAO = userGroupDAO;
        this.userGroupMtnDAO = userGroupMtnDAO;
    }

    @Override
    public void addUserGrp(String userId) throws ApplicationException {
        UserGroup userGroupModel = new UserGroup();
        String uuid = commonUtils.generateUUID();
        String mtGrpId = userGroupMtnDAO.getUserGroupMtnByCd(CommonConstants.UL1_CODE);
        userGroupModel.setId(uuid);
        userGroupModel.setMtGrpId(mtGrpId);
        userGroupDAO.addUserGrp(userGroupModel);
    }

    @Override
    public UserGroup getUserGrp(String id) throws ApplicationException {
        return userGroupDAO.getUserGroupCodeById(id);
    }
}
