package com.cachinginapp.enterprise.dao;

import com.cachinginapp.enterprise.dto.Cache;

import java.util.List;

public interface ICacheDAO {
    Cache save(Cache cache) throws Exception;

    List<Cache> fetchAll();
}
