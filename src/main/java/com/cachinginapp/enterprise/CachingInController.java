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
     * @return
     */

    @RequestMapping("/")
    public String index() {
        return "start";
    }

    @GetMapping("/cache/")
    public ResponseEntity fetchAllCaches(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/cache/{id}/")
    public ResponseEntity fetchCacheById(@PathVariable("id") int id){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value="/cache/", consumes="application/json", produces="application/json")
    public Cache createCache(@RequestBody Cache cache){
        return cache;
    }

    @DeleteMapping("/cache/{id}/")
    public ResponseEntity deleteCache(@PathVariable("id") int id){
        return new ResponseEntity(HttpStatus.OK);
    }

}
