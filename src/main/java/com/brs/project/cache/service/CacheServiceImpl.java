package com.brs.project.cache.service;

import com.brs.project.cache.dao.CacheDAO;
import com.brs.project.cache.entity.Cache;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CacheServiceImpl implements CacheService {
    private CacheDAO cacheDAO;

    public CacheServiceImpl(CacheDAO cacheDAO){
        this.cacheDAO = cacheDAO;
    }
    @Override
    public Cache addCacheByTokenId(String id, String key, String value) {
        return null;
    }

    @Override
    public void UpdateCacheByTokenId(String oldId,String newId) {
        cacheDAO.updateCacheSessionId(oldId,newId);
    }
}
