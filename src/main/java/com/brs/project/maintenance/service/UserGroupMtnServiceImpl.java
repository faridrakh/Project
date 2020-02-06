package com.brs.project.maintenance.service;

import com.brs.project.maintenance.controller.UserGroupMtnController;
import com.brs.project.maintenance.dao.UserGroupMtnDAO;
import com.brs.project.maintenance.entity.UserGroupMtn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupMtnServiceImpl implements UserGroupMtnService {
    private static final Logger logger = LogManager.getLogger(UserGroupMtnServiceImpl.class);

    private UserGroupMtnDAO userGroupMtnDAO;

    public UserGroupMtnServiceImpl(UserGroupMtnDAO userGroupMtnDAO){
        this.userGroupMtnDAO = userGroupMtnDAO;
    }

    @Override
    @Cacheable(value = "UserGroupMtnList")
    public List<UserGroupMtn> getUserGroupMtnList() {
        if(logger.isDebugEnabled()){
            logger.debug("Start Listing User Group");
        }
        List<UserGroupMtn> UserGroupMtnList = userGroupMtnDAO.getUserGroupMtnList();

        if(logger.isDebugEnabled()){
            logger.debug("End Listing User Group");
        }
        return UserGroupMtnList;
    }
}
