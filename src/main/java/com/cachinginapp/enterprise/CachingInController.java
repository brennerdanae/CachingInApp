package com.cachinginapp.enterprise;

import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/cache")
    public ResponseEntity fetchAllCaches(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/cache/id/")
    public ResponseEntity fetchCacheById(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value="/cache", consumes="application/json", produces="application/json")
    public Cache createCache(@RequestBody Cache cache){
        return cache;
    }

    @DeleteMapping("/cache/id/")
    public ResponseEntity deleteCache(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);
    }

}
