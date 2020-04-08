package com.brs.project.passvault.dao;

import com.brs.project.common.helper.CommonConstants;
import com.brs.project.passvault.entity.PassVault;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PassVaultDAOImpl implements PassVaultDAO {
    private static final Logger logger = LogManager.getLogger(PassVaultDAOImpl.class);
    private EntityManager entityManager;

    public PassVaultDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public PassVault insertPassword(PassVault passVault) {
        entityManager.persist(passVault);
        return passVault;
    }

    @Override
    public String updatePassword(PassVault passVault) {
        entityManager.merge(passVault);
        return CommonConstants.SUCCESS_DESCP;
    }

    @Override
    public String deletePassword(String id) {
        PassVault passVault = new PassVault();
        passVault.setId(id);
        entityManager.remove(passVault);
        return CommonConstants.SUCCESS_DESCP;
    }

    @Override
    public PassVault getPassword(String id) {
        PassVault result;
        String qr = "FROM PassVault u WHERE u.id = :id";
        Query query = entityManager.createQuery(qr);
        query.setParameter("id", id);
        result = (PassVault) query.getSingleResult();
        return result;
    }

    @Override
    public Map<String,Object> getListPassword(String usrId, Integer page) {
        Map<String,Object> res = new LinkedHashMap<>();
        int pageSize = 5 * page;
        Query countQuery = entityManager.createQuery("Select count(p.id) FROM PassVault p where p.usrId = :usrId");
        countQuery.setParameter("usrId", usrId);
        Long countResults = (Long) countQuery.getSingleResult();

        String qr = "FROM PassVault p where p.usrId = :usrId ORDER BY p.dtCreate DESC";
        Query query = entityManager.createQuery(qr);
        query.setParameter("usrId", usrId);
        query.setFirstResult(0);
        query.setMaxResults(pageSize);
        List<PassVault> list = query.getResultList();
        res.put("page", page);
        res.put("perPage", pageSize);
        res.put("total", countResults);
        res.put("passVaultList", list);
        return res;
    }


//    public Map<String,Object> getListPasswords(String usrId, Integer page) {
//        Map<String,Object> res = new LinkedHashMap<>();
//        int pageSize = 5;
//        Query countQuery = entityManager.createQuery("Select count(p.id) FROM PassVault p where p.usrId = :usrId");
//        countQuery.setParameter("usrId", usrId);
//        Long countResults = (Long) countQuery.getSingleResult();
//
//        int lastPageNumber = (int) (Math.ceil(countResults / (double) pageSize));
//        String qr = "FROM PassVault p where p.usrId = :usrId ORDER BY p.dtCreate DESC";
//        Query query = entityManager.createQuery(qr);
//        query.setParameter("usrId", usrId);
//        query.setFirstResult((page - 1) * pageSize);
//        query.setMaxResults(pageSize);
//        List<PassVault> list = query.getResultList();
//        res.put("page", page);
//        res.put("perPage", pageSize);
//        res.put("total", countResults);
//        res.put("totalPages", lastPageNumber);
//        res.put("passVaultList", list);
//        return res;
//    }
}
