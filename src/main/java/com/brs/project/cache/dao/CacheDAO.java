package com.brs.project.cache.dao;

import com.brs.project.cache.entity.Cache;

public interface CacheDAO {
    void updateCacheSessionId(String oldSessionId,String newSessionId);
    Cache getCache(String tokenId, String key);
    void updateCache(String tokenId,String key,String value);
}
