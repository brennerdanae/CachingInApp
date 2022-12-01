package com.cachinginapp.enterprise.dao;

import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("dev")
public class CacheSQLDAO implements ICacheDAO {

    @Autowired
    CacheRepository cacheRepository;

    @Override
    public Cache save(Cache cache) throws Exception {
        return cacheRepository.save(cache);
    }

    @Override
    public List<Cache> fetchAll() {
        List<Cache> allCaches = new ArrayList<>();
        Iterable<Cache> caches = cacheRepository.findAll();
        for (Cache cache : caches){
            allCaches.add(cache);
        }
        return allCaches;
    }

    @Override
    public Cache fetch(int id){

        return cacheRepository.findById(id).get();
    }

    @Override
    public void delete(int id){
        cacheRepository.deleteById(id);
    }

    @Override
    public List<Cache> fetchPlants(String searchTerm) {
        return null;
    }
}
