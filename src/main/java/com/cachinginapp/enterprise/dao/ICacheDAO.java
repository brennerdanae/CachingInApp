package com.cachinginapp.enterprise.dao;

import com.cachinginapp.enterprise.dto.Cache;

public interface ICacheDAO {
    Cache save(Cache cache) throws Exception;
}
