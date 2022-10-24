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

    /**
     * Save a cache
     * @param cache a Cache object
     * @return the saved cache
     * @throws Exception
     */
    Cache save(Cache cache) throws Exception;

    /**
     * Fetches all the caches
     * @return a list of all the caches
     */
    List<Cache> fetchAll();

}
