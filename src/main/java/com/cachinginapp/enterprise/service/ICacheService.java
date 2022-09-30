package com.cachinginapp.enterprise.service;

import com.cachinginapp.enterprise.dto.Cache;

public interface ICacheService {
        /**
         * Fetch a cache with a given ID.
         * @param id is a unique identifier for a cache.
         * @return the matching cache, or null if no matches are found.
         */
        Cache fetchById(int id);
}
