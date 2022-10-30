package com.cachinginapp.enterprise.dao;

import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CacheDAOStub implements ICacheDAO {

    List<Cache> allCaches = new ArrayList<Cache>();

    @Override
    public Cache save(Cache cache) throws Exception {
        allCaches.add(cache);
        return cache;
    }

    @Override
    public List<Cache> fetchAll() {
        return allCaches;
    }
    @Override
    public Cache fetchCacheById(int id) {
        for (Cache cache: allCaches) {
            if (cache.getCacheID() == id) {
                return cache;
            }
        }
        return null;
    }
}
