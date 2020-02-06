package com.brs.project.user.dao;

import com.brs.project.common.helper.CommonConstants;
import com.brs.project.user.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private static final Logger logger = LogManager.getLogger(UserDAOImpl.class);
    private EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User addUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public String updateUser(User user) {
        entityManager.merge(user);
        return CommonConstants.SUCCESS_DESCP;
    }

    @Override
    public String deleteUser(String id) {
        User user = new User();
        user.setId(id);
        entityManager.remove(user);
        return CommonConstants.SUCCESS_DESCP;
    }

    @Override
    public User getUser(String id) throws NoResultException  {
        User result;
        String qr = "FROM User u WHERE u.id = :id";
        Query query = entityManager.createQuery(qr);
        query.setParameter("id", id);
        result = (User) query.getSingleResult();
        return result;
    }

    @Override
    public User getUser(String user, String password) throws NoResultException  {
        User result;
        String qr = "FROM User u WHERE u.userName = :userName and u.password = :password";
        Query query = entityManager.createQuery(qr);
        query.setParameter("userName", user);
        query.setParameter("password", password);
        result = (User) query.getSingleResult();
        return result;
    }

    @Override
    public User getUserByUserName(String value) {
        User result = null;
        String qr = "FROM User u WHERE u.userName = :userName";
        Query query = entityManager.createQuery(qr);
        query.setParameter("userName", value);
        try {
            Object obj = query.getSingleResult();
            if (null != obj){
                result = (User) obj;
            }
        } catch (NoResultException e) {
            result = null;
        }
        return result;
    }

    @Override
    public List<User> getUserList() {
        List<Object> result = new ArrayList<>();
        String qr = "FROM User u";
        Query query = entityManager.createQuery(qr);
        return query.getResultList();
    }

    @Override
    public User getUserByEmail(String value) {
        User result = null;
        String qr = "FROM User u WHERE u.email = :email";
        Query query = entityManager.createQuery(qr);
        query.setParameter("email", value);
        try {
            Object obj = query.getSingleResult();
            if (null != obj){
                result = (User) obj;
            }
        } catch (NoResultException e) {
            result = null;
        }
        return result;
    }
}
