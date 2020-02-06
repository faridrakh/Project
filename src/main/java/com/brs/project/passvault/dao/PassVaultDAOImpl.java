package com.brs.project.passvault.dao;

import com.brs.project.common.helper.CommonConstants;
import com.brs.project.passvault.entity.PassVault;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

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
    public PassVault getPassword(PassVault passVault) {
        return null;
    }

    @Override
    public List<PassVault> getListPassword(String usrId) {
        String qr = "FROM PassVault p where p.usrId = :usrId ORDER BY p.dtCreate DESC";
        Query query = entityManager.createQuery(qr);
        query.setParameter("usrId", usrId);
        return query.getResultList();
    }
}
