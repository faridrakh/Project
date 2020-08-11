package com.brs.project.financial.account.dao;

import com.brs.project.financial.account.entity.Account;
import com.sytan.base.lib.ApplicationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private static final Logger logger = LogManager.getLogger(AccountDAOImpl.class);
    private EntityManager entityManager;

    public AccountDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addAccount(Account account) throws ApplicationException {
        entityManager.persist(account);
    }

    @Override
    public void updateAccount(Account account) throws ApplicationException {
        entityManager.merge(account);
    }

    @Override
    public Account getAccount(String uid) throws ApplicationException {
        Account result;
        String qr = "FROM Account u WHERE u.id = :id";
        Query query = entityManager.createQuery(qr);
        query.setParameter("id", uid);
        result = (Account) query.getSingleResult();
        return result;
    }

    @Override
    public Account getAccount(String uid, String accountId) throws ApplicationException {
        Account result;
        String qr = "FROM Account u WHERE u.usrId = :id and u.id = :aid";
        Query query = entityManager.createQuery(qr);
        query.setParameter("id", uid);
        query.setParameter("aid",  accountId);
        result = (Account) query.getSingleResult();
        return result;
    }

    @Override
    public Map<String,Object> getAccountList(String userId, Integer page) throws ApplicationException {
        Map<String,Object> res = new LinkedHashMap<>();
        int pageSize = 5 * page;
        Query countQuery = entityManager.createQuery("Select count(p.id) FROM Account p where p.usrId = :usrId");
        countQuery.setParameter("usrId", userId);
        Long countResults = (Long) countQuery.getSingleResult();

        String qr = "FROM Account p where p.usrId = :usrId ORDER BY p.dtCreate DESC";
        Query query = entityManager.createQuery(qr);
        query.setParameter("usrId", userId);
        query.setFirstResult(0);
        query.setMaxResults(pageSize);
        List<Account> list = query.getResultList();
        res.put("page", page);
        res.put("perPage", pageSize);
        res.put("total", countResults);
        res.put("accountList", list);
        return res;
    }
}
