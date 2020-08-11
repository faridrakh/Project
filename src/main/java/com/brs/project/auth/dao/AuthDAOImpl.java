package com.brs.project.auth.dao;

import com.brs.project.auth.entity.LoginSession;
import com.sytan.base.lib.ApplicationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.Date;

@Repository
public class AuthDAOImpl implements AuthDAO {
    private static final Logger logger = LogManager.getLogger(AuthDAOImpl.class);
    private EntityManager entityManager;

    public AuthDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public LoginSession insertLoginSession(LoginSession login) throws ApplicationException {
        entityManager.persist(login);
        return login;
    }

    @Override
    public LoginSession updateLoginSession(LoginSession login) throws ApplicationException {
        LoginSession lmodel = entityManager.find(LoginSession.class,login.getId());
        //lmodel.setIsActive("N");
        lmodel.setLoginDate(new Timestamp(new Date().getTime()));
        entityManager.merge(lmodel);
        return lmodel;
    }

    @Override
    public LoginSession getSession(String tokenId) throws ApplicationException {
        LoginSession result;
        String qr = "FROM LoginSession ls INNER JOIN FETCH ls.user um WHERE ls.id = :tokenId AND ls.isActive <> 'N'";
        Query query = entityManager.createQuery(qr);
        query.setParameter("tokenId", tokenId);
        try {
            return (LoginSession) query.getSingleResult();
        } catch (NoResultException ex){
            return null;
        }
    }
}
