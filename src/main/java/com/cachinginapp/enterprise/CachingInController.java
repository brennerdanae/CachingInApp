package com.cachinginapp.enterprise;

import com.cachinginapp.enterprise.dto.Cache;
import com.cachinginapp.enterprise.service.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The controller for CachingInApp REST endpoints and web UI
 * <p>
 * This class handles the CRUD operations for CachingInApp "caches", via HTTP actions.
 * </p>
 * <p>
 * This class also serves HTML based web pages, for UI interactions with geo-cache objects.
 * </p>
 */
@Controller
public class CachingInController {

    @Autowired
    ICacheService cacheService;

    /**
     * Handle the root (/) endpoint and return a start page.
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        return "start";
    }
    /**
     * Map Page?
     * TODO: Explain methods purpose, and any @params and @return
     *
     */
    @RequestMapping("/map")
    public String map() {
        return "map";
    }

    /**
     * Saves all caches
     * @return
     */
    @RequestMapping("/saveCache")
    public String saveCache(Cache cache){
        try {
            cacheService.save(cache);
        } catch (Exception e) {
            e.printStackTrace();
            return "start";
        }
        return "start";
    }
    @GetMapping("/cache")
    @ResponseBody
    public List<Cache> fetchAllCaches(){
        return cacheService.fetchAll();
    }

    /**
     * Fetch a cache with the given ID.
     *
     * Given the parameter id, find a cache that corresponds to this unique ID.
     *
     * Returns one of the following status codes:
     * 200: if found
     * 400: if null
     *
     * @param id a unique identifier for this cache
     */
    @GetMapping("/cache/{id}/")
    public ResponseEntity fetchCacheById(@PathVariable("id") int id){
        Cache foundCache = cacheService.fetchCacheById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(foundCache, headers, HttpStatus.OK);
    }

    /**
     * Creates a new cache object
     *
     * returns one of the following status codes:
     * 201
     * 409
     *
     * @param cache a JSON representation of a cache object.
     * @return the newly created cache object.
     */
    @PostMapping(value="/cache", consumes="application/json", produces="application/json")
    public Cache createCache(@RequestBody Cache cache) {
        Cache newCache = null;
        try {
            newCache = cacheService.save(cache);
        } catch (Exception e) {
            //TODO add logging
        }
        return newCache;

    }
    /**
     * removes a cache with given id
     *
     * Given the parameter id, remove the cache that corresponds to this unique ID.
     *
     * Returns one of the following status codes:
     * 200: if found
     * 400: if null
     *
     * @param id a JSON representation of a cache object.
     * @return message confirming the cache was removed.
     */
    @DeleteMapping("/cache/{id}/")
    public ResponseEntity deleteCache(@PathVariable("id") int id){

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * searchesCaches with searchTerm value
     *
     * TODO: Describe the purpose of this method
     *
     * Returns one of the following status codes:
     * 200: if found
     * 400: if null
     *
     * @param searchTerm TODO: What is this parameter?
     * @return TODO: What does this return?
     */
    @GetMapping("/cachepoints")
    public ResponseEntity searchCaches(@RequestParam(value="searchTerm", required = false, defaultValue ="None") String searchTerm){

        return new ResponseEntity(HttpStatus.OK);
    }
}
