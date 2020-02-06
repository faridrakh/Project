package com.brs.project.usergrp.dao;

import com.brs.project.usergrp.entity.UserGroup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserGroupDAOImpl implements UserGroupDAO {
    private static final Logger logger = LogManager.getLogger(UserGroupDAOImpl.class);
    private EntityManager entityManager;

    public UserGroupDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public UserGroup addUserGrp(UserGroup userGrp) {
        entityManager.persist(userGrp);
        return userGrp;
    }

    @Override
    public List<UserGroup> getUserGroupListByUserId(String userId) {
        return null;
    }
}
