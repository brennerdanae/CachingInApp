package com.cachinginapp.enterprise.dao;

import com.cachinginapp.enterprise.dto.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {

}
