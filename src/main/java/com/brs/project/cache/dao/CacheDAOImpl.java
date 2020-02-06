package com.brs.project.cache.dao;

import com.brs.project.cache.entity.Cache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class CacheDAOImpl implements CacheDAO {
    private static final Logger logger = LogManager.getLogger(CacheDAOImpl.class);
    private EntityManager entityManager;

    public CacheDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void updateCacheSessionId(String oldSessionId, String newSessionId) {
        String qr = "UPDATE Cache lc " +
                "SET lc.sessionId = :newSessionId " +
                "WHERE lc.sessionId = :oldSessionId";
        Query query = entityManager.createQuery(qr);
        query.setParameter("newSessionId",newSessionId);
        query.setParameter("oldSessionId",oldSessionId);
        query.executeUpdate();
    }

    @Override
    public Cache getCache(String tokenId, String key) {
        Cache result;
        String qr = "FROM LoginCache lc " +
                "INNER JOIN LoginSession ls " +
                "ON ls.id = lc.sessionId " +
                "WHERE ls.id = :tokenId " +
                "AND ls.isActive <> 'N' " +
                "AND lc.key = :key";
        Query query = entityManager.createQuery(qr);
        query.setParameter("tokenId", tokenId);
        query.setParameter("key", key);
        result = (Cache) query.getSingleResult();
        return result;
    }

    @Override
    public void updateCache(String tokenId, String key, String value) {
        Cache lc = getCache(tokenId,key);
        lc.setValue(value);
        entityManager.merge(lc);
    }
}
