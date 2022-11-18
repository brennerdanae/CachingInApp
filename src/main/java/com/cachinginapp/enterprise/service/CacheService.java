package com.cachinginapp.enterprise.service;

import com.cachinginapp.enterprise.dao.ICacheDAO;
import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.beans.factory.annotation.Autowired;
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

    public CacheService() {}

    public CacheService(ICacheDAO cacheDAO) {

        this.cacheDAO = cacheDAO;
    }

    @Override
    @Cacheable("cache")
    public Cache fetchCacheById(int id) {
        return cacheDAO.fetch(id);
    }

    @Override
    public void delete(int id) throws Exception {
        cacheDAO.delete(id);
    }
    @Override
    @Cacheable("caches")
    public Cache save(Cache cache) throws Exception{
        return cacheDAO.save(cache);
    }

    @Override
    public List<Cache> fetchAll() {
        return cacheDAO.fetchAll();
    }

    @Override
    public void saveImage(MultipartFile imageFile) throws IOException {
        String folder = "/photos/";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }

}
