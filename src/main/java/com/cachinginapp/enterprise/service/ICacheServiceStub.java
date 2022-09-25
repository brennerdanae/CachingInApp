package com.cachinginapp.enterprise.service;

import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.stereotype.Component;

@Component
public class ICacheServiceStub implements ICacheService
{
    @Override
    public Cache fetchCacheById(int cacheId) {
        Cache cache = new Cache();
        cache.setDescription("Filler description");
        cache.setCacheID(63);
        return null;
    }
}
