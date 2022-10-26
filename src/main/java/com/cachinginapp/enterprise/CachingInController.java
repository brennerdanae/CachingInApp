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
import java.util.logging.Level;
import java.util.logging.Logger;

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

    Logger logger = Logger.getLogger(CachingInController.class.getName());
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
        try{
            return cacheService.fetchAll();
        } catch (Exception e) {
            logger.log(Level.WARNING, "No caches were fetched!");
            throw new RuntimeException(e);
        }


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
        try {
            Cache foundCache = cacheService.fetchCacheById(id);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity(foundCache, headers, HttpStatus.OK);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Unable to fetch cache with ID: " + id + ", message: " + e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
            logger.log(Level.WARNING, "Your cache was not created.");
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
        try {
            //TODO: cacheService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Unable to delete cache with ID: " + id + ", message: " + e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

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
