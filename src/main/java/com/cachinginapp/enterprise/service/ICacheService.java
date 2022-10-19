package com.cachinginapp.enterprise.service;

import com.cachinginapp.enterprise.dto.Cache;

import java.util.List;

public interface ICacheService {
    /**
     * Fetch a cache with a given ID.
     * @param cacheId unique identifier for a cache.
     * @return the matching cache, or none if found.
     */
    Cache fetchCacheById(int cacheId);

    Cache save(Cache cache) throws Exception;

    List<Cache> fetchAll();
}
