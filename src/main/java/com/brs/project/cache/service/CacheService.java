package com.brs.project.cache.service;

import com.brs.project.cache.entity.Cache;


public interface CacheService {
    Cache addCacheByTokenId(String id, String key, String value);
    void UpdateCacheByTokenId(String oldId,String newId);
}
