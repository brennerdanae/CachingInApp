package com.cachinginapp.enterprise.dao;

import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("!test")
public interface CacheRepository extends CrudRepository<Cache, Integer> {


}
