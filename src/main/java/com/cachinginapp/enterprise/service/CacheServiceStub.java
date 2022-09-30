package com.cachinginapp.enterprise.service;

import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.stereotype.Component;

/**
 * This class will act as a mock data for ICacheService
 *
 * @return objects created within class
 */
@Component
public class CacheServiceStub implements ICacheService {
    @Override
    public Cache fetchById(int id) {
        Cache cache = new Cache();
        cache.setCacheID(11);
        cache.setLatitude("90");
        cache.setLongitude("100");
        cache.setDescription("I am a cache :)");
        return cache;
    }

}