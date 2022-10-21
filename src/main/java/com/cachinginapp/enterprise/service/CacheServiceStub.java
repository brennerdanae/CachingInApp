package com.cachinginapp.enterprise.service;

import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.stereotype.Component;

@Component
public class CacheServiceStub implements ICacheService{
    @Override
    public Cache fetchById(int id) {
        Cache cache = new Cache();
        cache.setDescription("Mount Auburn");
        cache.setCacheID(83);
        return cache;
    }
}
