package com.cachinginapp.enterprise.service;

import com.cachinginapp.enterprise.dao.ICacheDAO;
import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheServiceStub implements ICacheService {

    @Autowired
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
        cache.setLatitude("35.3606");
        cache.setLongitude("138.7274");
        return cache;
    }

    @Override
    public Cache save(Cache cache) throws Exception{
        return cacheDAO.save(cache);
    }

    @Override
    public List<Cache> fetchAll() {
        return cacheDAO.fetchAll();
    }

}
