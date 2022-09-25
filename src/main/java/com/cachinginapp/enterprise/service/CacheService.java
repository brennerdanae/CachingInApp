package com.cachinginapp.enterprise.service;

import com.cachinginapp.enterprise.dto.Cache;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CacheService {
    /**
     * Get specimens from persistence layer.
     * @param id a unique lookup
     * @return a specimen with a matching ID.
     */
    SpecimenDTO fetchById(int id);

    /**
     * Persist the given DTO
     * @param specimenDTO
     */
    boolean save(SpecimenDTO specimenDTO) throws Exception;

    /**
     * Return a list of plants that contain this String.
     * @param string the search criteria: can be genus, species, cultivar, or common
     * @return a list of matching plants.
     */
    List<Cache> fetchPlants(String string) throws Exception;

    void setSpecimenDAO(ISpecimenDAO specimenDAO);

    CacheDAO getSpecimenDAO();

    Iterable<Cache> fetchAllSpecimens() throws Exception;

    List<Cache> fetchSpecimensByPlantId(String latitude);
}
