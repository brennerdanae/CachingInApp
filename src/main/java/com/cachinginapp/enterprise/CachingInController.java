package com.cachinginapp.enterprise;

import com.cachinginapp.enterprise.dto.Cache;
import com.cachinginapp.enterprise.service.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Cache cache = new Cache();
        cache.setCacheID(84);
        cache.setDescription("Eden Park Cache");
        cache.setLatitude("39.74");
        cache.setLongitude("-84.51");
        model.addAttribute(cache);
        return "start";
    }

    @RequestMapping("/map")
    public String map() {
        return "map";
    }

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

    @GetMapping("/cache/id/")
    public ResponseEntity fetchCacheById(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);
    }

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

    @DeleteMapping("/cache/id/")
    public ResponseEntity deleteCache(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);

    }


    @GetMapping("/cachepoints")
    public ResponseEntity searchCaches(@RequestParam(value="searchTerm", required = false, defaultValue ="None") String searchTerm){

        return new ResponseEntity(HttpStatus.OK);
    }

}
