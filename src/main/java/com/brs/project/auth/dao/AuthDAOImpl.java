package com.brs.project.auth.dao;

import com.brs.project.auth.entity.LoginSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class AuthDAOImpl implements AuthDAO {
    private static final Logger logger = LogManager.getLogger(AuthDAOImpl.class);
    private EntityManager entityManager;

    public AuthDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public LoginSession insertLoginSession(LoginSession login) {
        entityManager.persist(login);
        return login;
    }

    @Override
    public LoginSession updateLoginSession(LoginSession login) {
        LoginSession lmodel = entityManager.find(LoginSession.class,login.getId());
        lmodel.setIsActive("N");
        entityManager.merge(lmodel);
        return lmodel;
    }

    @Override
    public LoginSession getSession(String tokenId) {
        LoginSession result;
        String qr = "FROM LoginSession ls INNER JOIN FETCH ls.user um WHERE ls.id = :tokenId AND ls.isActive <> 'N'";
        Query query = entityManager.createQuery(qr);
        query.setParameter("tokenId", tokenId);
        result = (LoginSession) query.getSingleResult();
        return result;
    }
}
