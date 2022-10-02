package com.cachinginapp.enterprise.dao;

import com.cachinginapp.enterprise.dto.Cache;

import java.util.List;

public interface CacheDAO {
    public interface ISpecimenDAO {

        boolean save(Cache cacheDTO) throws Exception;

        Iterable<Cache> fetchAll() throws Exception;

        List<Cache> fetchSpecimensByPlantId(int cacheID);

    }
}
