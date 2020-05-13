package com.brs.project.financial.transaction.dao;

import com.brs.project.financial.transaction.entity.Transaction;
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
public class TransactionDAOImpl implements TransactionDAO {
    private static final Logger logger = LogManager.getLogger(TransactionDAOImpl.class);
    private EntityManager entityManager;

    public TransactionDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insertTrxn(Transaction trxn) throws ApplicationException {
        entityManager.persist(trxn);
    }

    @Override
    public void updateTrxn(Transaction trxn) throws ApplicationException {
        entityManager.merge(trxn);
    }

    @Override
    public Transaction getTrxn(String id) throws ApplicationException {
        Transaction result;
        String qr = "FROM Transaction u WHERE u.id = :id";
        Query query = entityManager.createQuery(qr);
        query.setParameter("id", id);
        result = (Transaction) query.getSingleResult();
        return result;
    }

    @Override
    public Map<String, Object> getTrxnList(String userId, Integer page) throws ApplicationException {
        Map<String,Object> res = new LinkedHashMap<>();
        int pageSize = 5 * page;
        Query countQuery = entityManager.createQuery("Select count(p.id) FROM Transaction p where p.usrId = :usrId");
        countQuery.setParameter("usrId", userId);
        Long countResults = (Long) countQuery.getSingleResult();

        String qr = "FROM Transaction p where p.usrId = :usrId ORDER BY p.dtCreate DESC";
        Query query = entityManager.createQuery(qr);
        query.setParameter("usrId", userId);
        query.setFirstResult(0);
        query.setMaxResults(pageSize);
        List<Transaction> list = query.getResultList();
        res.put("page", page);
        res.put("perPage", pageSize);
        res.put("total", countResults);
        res.put("transactionList", list);
        return res;
    }
}
