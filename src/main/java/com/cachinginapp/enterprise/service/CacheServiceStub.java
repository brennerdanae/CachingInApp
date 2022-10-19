package com.cachinginapp.enterprise.service;

import com.cachinginapp.enterprise.dao.ICacheDAO;
import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.stereotype.Component;

@Component
public class CacheServiceStub implements ICacheService {

    private ICacheDAO cacheDAO;

    public CacheServiceStub() {}

    public CacheServiceStub(ICacheDAO cacheDAO) {

        this.cacheDAO = cacheDAO;
    }

    @Override
    public Cache fetchCacheById(int cacheId) {
        Cache cache = new Cache();
        cache.setDescription("Mountain Overlook");
        cache.setCacheID(420);
        return cache;
    }

    @Override
    public Cache save(Cache cache) throws Exception{
        return cacheDAO.save(cache);
    }
}
