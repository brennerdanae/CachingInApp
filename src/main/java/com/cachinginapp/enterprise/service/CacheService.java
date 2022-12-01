package com.cachinginapp.enterprise.service;

import com.cachinginapp.enterprise.dao.ICacheDAO;
import com.cachinginapp.enterprise.dao.IPhotoDAO;
import com.cachinginapp.enterprise.dto.Cache;
import com.cachinginapp.enterprise.dto.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CacheService implements ICacheService {

    @Autowired
    private ICacheDAO cacheDAO;

    @Autowired
    private IPhotoDAO photoDAO;

    public CacheService() {}

    public CacheService(ICacheDAO cacheDAO) {

        this.cacheDAO = cacheDAO;
    }

    @Override
    @Cacheable(value="cache", key="#id")
    public Cache fetchCacheById(int id) {
        Cache foundCache = cacheDAO.fetch(id);
        return foundCache;
    }

    @Override
    @CacheEvict(value="cache", key="#id")
    public void delete(int id) throws Exception {
        cacheDAO.delete(id);
    }
    @Override
    @Cacheable("caches")
    public Cache save(Cache cache) throws Exception{
        return cacheDAO.save(cache);
    }

    @Override
    @Cacheable("caches")
    public List<Cache> fetchAll() {

        return cacheDAO.fetchAll();
    }

    @Override
    public void saveImage(MultipartFile imageFile, Photo photo) throws IOException {
        photoDAO.save(photo);
        photoDAO.saveImage(imageFile, photo);
    }

    @Override
    public List<Cache> fetchCaches(String searchTerm) {
        return cacheDAO.fetchPlants(searchTerm);
    }

}
