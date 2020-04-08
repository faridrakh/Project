package com.brs.project.maintenance.dao;

import com.brs.project.maintenance.entity.UserGroupMtn;
import com.sytan.base.lib.ApplicationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserGroupMtnDAOImpl implements UserGroupMtnDAO {
    private static final Logger logger = LogManager.getLogger(UserGroupMtnDAOImpl.class);
    private EntityManager entityManager;

    public UserGroupMtnDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UserGroupMtn> getUserGroupMtnList() throws ApplicationException {
        if(logger.isDebugEnabled()){
            logger.debug("Start Data Access User Group");
        }
        String qr = "SELECT id, cd, name FROM UserGroupMtn";
        Query query = entityManager.createQuery(qr);
        if(logger.isDebugEnabled()){
            logger.debug(qr);
            logger.debug("End Data Access User Group");
        }
        return query.getResultList();
    }

    @Override
    public String getUserGroupMtnByCd(String cd) throws ApplicationException {
        if(logger.isDebugEnabled()){
            logger.debug("Start Data Access User Group By CD");
        }
        String qr = "SELECT id FROM UserGroupMtn mtn WHERE mtn.cd = :cd";
        Query query = entityManager.createQuery(qr);
        query.setParameter("cd", cd);
        if(logger.isDebugEnabled()){
            logger.debug(qr);
            logger.debug("End Data Access User Group By CD");
        }
        return query.getResultList().get(0).toString();
    }
}
