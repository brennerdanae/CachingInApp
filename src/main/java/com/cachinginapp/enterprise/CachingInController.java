package com.cachinginapp.enterprise;

import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CachingInController {

    /**
     * Handle the root (/) endpoint and return a start page.
     * @return the page used as the index page
     */

    @RequestMapping("/")
    public String index() {
        return "start";
    }

    /**
     * Fetches all caches that have been saved
     * @return HTTP Status Code 200
     */

    @GetMapping("/cache/")
    public ResponseEntity fetchAllCaches(){
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Fetches a cache using its ID
     * @return HTTP Status Code 200
     */

    @GetMapping("/cache/{id}/")
    public ResponseEntity fetchCacheById(@PathVariable("id") int id){
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Creates a new cache by consuming JSON
     * @return The cache that was just created
     */

    @PostMapping(value="/cache/", consumes="application/json", produces="application/json")
    public Cache createCache(@RequestBody Cache cache){
        return cache;
    }

    /**
     * Deletes a cache by using its ID
     * @return HTTP Status Code 200
     */

    @DeleteMapping("/cache/{id}/")
    public ResponseEntity deleteCache(@PathVariable("id") int id){
        return new ResponseEntity(HttpStatus.OK);
    }

}
