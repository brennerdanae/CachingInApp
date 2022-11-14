package com.cachinginapp.enterprise.service;

import com.cachinginapp.enterprise.dao.ICacheDAO;
import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheService implements ICacheService {

    @Autowired
    private ICacheDAO cacheDAO;

    public CacheService() {}

    public CacheService(ICacheDAO cacheDAO) {

        this.cacheDAO = cacheDAO;
    }

    @Override
    @Cachable("cache")
    public Cache fetchCacheById(int id) {
        return cacheDAO.fetch(id);
    }

    @Override
    public void delete(int id) throws Exception {
        cacheDAO.delete(id);
    }
    @Override
    @Cachable("caches")
    public Cache save(Cache cache) throws Exception{
        return cacheDAO.save(cache);
    }

    @Override
    public List<Cache> fetchAll() {
        return cacheDAO.fetchAll();
    }

}
