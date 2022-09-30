package com.cachinginapp.enterprise.service;

import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.stereotype.Component;

@Component
public class CacheServiceStub implements ICacheService {
    @Override
    public Cache fetchById(int id) {
        Cache cache = new Cache();
        cache.setCacheID(11);
        cache.setDescription("I am a cache :)");
        return cache;
    }

}

