package com.cachinginapp.enterprise;

import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Handle the root (/) endpoint and return a start page.
     * @return
     */

    @RequestMapping("/")
    public String index(Model model) {
        Cache cache = new Cache();
        cache.setCacheID(84);
        cache.setDescription("Eden Park Cache");
        cache.setLatitude("39.74");
        cache.setLongitude("-84.51");
        model.addAttribute(cache);
        return "start";
    }

    /**
     * Fetches all caches
     *
     * Returns one of the following status codes:
     * 200: if found
     * 400: if null
     */
    @GetMapping("/cache")
    public ResponseEntity fetchAllCaches(){
        return new ResponseEntity(HttpStatus.OK);
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
    @GetMapping("/cache/id/")
    public ResponseEntity fetchCacheById(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);
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
    public Cache createCache(@RequestBody Cache cache){
        return cache;
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
     * @return message confirming the cache was removed. TODO: create a message that confirms the cache was removed.
     */
    @DeleteMapping("/cache/id/")
    public ResponseEntity deleteCache(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);
    }

}
